package com.zhangxing.springbootweb;

import com.zhangxing.springbootweb.controller.ConsumerController;
import com.zhangxing.springbootweb.entities.Book;
import com.zhangxing.springbootweb.entities.Employee;
import com.zhangxing.springbootweb.entities.Employee_cache;
import com.zhangxing.springbootweb.mapper.EmpCacheMapper;
import com.zhangxing.springbootweb.mapper.EmployeeMapper;
import com.zhangxing.springbootweb.service.DepartmentService;
import com.zhangxing.springbootweb.service.EmployeeCacheService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootWebApplicationTests {

    @Autowired
    ConsumerController consumerController;

    @Test
    public void testConsumerController() throws Exception {
        consumerController.hello();
    }

    @Autowired
    JavaMailSender javaMailSender;

    @Test
    public void testJavaMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("开会");
        message.setText("7.30");
        message.setTo("1375871334@qq.com");
        message.setFrom("1017073490@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void testJavaMail2() throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);
        helper.setSubject("开会");
        helper.setText("<b style='color:blue'>7.30</b>",true);
        helper.setTo("1375871334@qq.com");
        helper.setFrom("1017073490@qq.com");
        helper.addAttachment("配置",new File("D:\\Study\\IDEA\\Project\\SpringBoot-Study\\spring-boot-web\\src\\main\\resources\\application.properties"));
        javaMailSender.send(message);
    }

    @Autowired
    JestClient jestClient;

    @Test
    public void testJest() throws Exception {
        Book book = new Book();
        book.setBookName("zx");
        book.setAuthor("xz");
        //构建索引
        Index index = new Index.Builder(book).index("atguigu").type("news").id("1").build();
        jestClient.execute(index);
    }

    @Test
    public void testJestSearch() throws Exception {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match_phrase\" : {\n" +
                "            \"bookName\" : \"zx\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.
                Builder(json).
                addIndex("atguigu").
                addType("news").
                build();
        System.out.println(jestClient.execute(search).getJsonString());
    }

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
//        amqpAdmin.declareExchange(new DirectExchange("adqpadmin.exchange"));
//        amqpAdmin.declareQueue(new Queue("adqpadmin.quene", true));
//        System.out.println("创建完成");

        amqpAdmin.declareBinding(new Binding("adqpadmin.quene",
                Binding.DestinationType.QUEUE,
                "adqpadmin.exchange",
                "amqp.hh", null));
    }

    @Autowired
    EmployeeCacheService employeeCacheService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RedisTemplate<Object, Employee_cache> empRedisTemplate;

    @Autowired
    EmpCacheMapper empCacheMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    DataSource dataSource;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.info("测试");
    }

    @Test
    public void Test_JDBC() throws Exception {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        logger.info("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        logger.info(connection.toString());
        logger.info("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
        connection.close();
    }

    @Test
    public void Test_Cache() throws Exception {
        Employee_cache emp = empCacheMapper.getEmpById(1);
        System.out.println(emp);

    }

    @Test
    public void Test_Redis() throws Exception {
        //stringRedisTemplate.opsForValue().append("msg","ZXNB");
        //System.out.println(stringRedisTemplate.opsForValue().get("msg"));
//        stringRedisTemplate.opsForList().leftPush("mylist", "1");
//        stringRedisTemplate.opsForList().leftPush("mylist", "10");
//        stringRedisTemplate.opsForList().leftPush("mylist", "100");
        //如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
        //将数据以json方式保存
        //redisTemplate.opsForValue().set("zx",empCacheMapper.getEmpById(1));
        //改变默认的序列化规则
        empRedisTemplate.opsForValue().set("mm", empCacheMapper.getEmpById(1));
    }

    @Test
    public void testRabbitMQSend() throws Exception {
        //单播
        Map<String, Object> map = new HashMap<>();
        map.put("msg1", "idea的消息1");
        map.put("msg2", Arrays.asList("123", "zx", false));
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news",
                map);
        //new Book("qssymm","qy"));
    }

    @Test
    public void testRabbitMQReceive() throws Exception {
        //单播
        Object convert = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(convert.getClass());
        System.out.println(convert);
    }


}
