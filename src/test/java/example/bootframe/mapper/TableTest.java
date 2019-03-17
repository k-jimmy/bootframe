package example.bootframe.mapper;

import example.bootframe.entity.User;
import example.bootframe.entity.topway.TopwayAgent;
import example.bootframe.entity.topway.TopwayAgentExample;
import example.bootframe.mapper.topway.TopwayAgentMapper;
import example.bootframe.unit.SqlEntityTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTest {

    @Resource
    TableMapper tableMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    TopwayAgentMapper topwayAgentMapper;

    //    @Resource
//    BroadMapper broadMapper;
    @Test
    public void contextLoads() throws Exception {
        List<Map> list = tableMapper.listTable();
        SqlEntityTool.getTableMap(list);
    }


//    @Test
//    public void testBroad() {
//        Broad broad = broadMapper.selectByPrimaryKey(1);
//        System.out.println("---");
//    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("测试11111");
        user.setPassword("123456");
        user.setAddress("伤害");
        user.setEmail("234@sdrege.com");
        userMapper.insertSelective(user);
    }

    @Test
    public void testSelect() {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println();
    }

    @Test
    public void testBroadDe() {
//        TopwayAgent topwayAgent = topwayAgentMapper.selectByPrimaryKey(1);
//        System.out.println("---");
        TopwayAgent topwayAgent = new TopwayAgent();
        topwayAgent.setAddress("asd");
        topwayAgentMapper.insertSelective(topwayAgent);
    }


}
