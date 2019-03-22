package example.bootframe.controller;

import com.alibaba.fastjson.JSONObject;
import example.bootframe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class BookController {
    @Resource
    private BookService bookService;
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/searchBook")
    public JSONObject searchBook(String url) {
        return bookService.searchBook(url);
    }
}
