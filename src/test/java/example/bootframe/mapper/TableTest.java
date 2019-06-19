package example.bootframe.mapper;

import example.bootframe.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTest {

    //    @Resource
//    TableMapper tableMapper;
//    @Resource
//    UserMapper userMapper;
//    @Resource
//    TopwayAgentMapper topwayAgentMapper;
    @Resource
    BookService bookService;

    @Test
    public void getCatalog() {
        System.out.println(bookService.getCatalog("https://www.bqg99.cc/book/2639610/", "listmain"));
    }

    @Test
    public void searchBook() {
        bookService.getCatalog("", "");
    }

    @Test
    public void getContent() {
        System.out.println(bookService.getContent("https://www.bqg99.cc/book/2639610/554393756.html", "content"));
    }

}
