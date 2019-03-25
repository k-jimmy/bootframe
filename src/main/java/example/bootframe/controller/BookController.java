package example.bootframe.controller;

import com.alibaba.fastjson.JSONObject;
import example.bootframe.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
        return bookService.searchBook(url,"");
    }
    @ResponseBody
    @RequestMapping("/getCatalog")
    public JSONObject getCatalog(String url) {
        return bookService.getCatalog(url,"listmain");
    }
    @ResponseBody
    @RequestMapping("/getContent")
    public JSONObject getContent(String url) {
        return bookService.searchBook(url,"content");
    }

    @RequestMapping("/catalog")
    public String list(String url,Model model) {
        JSONObject str =bookService.getCatalog(url,"listmain");
        model.addAttribute("catalog", str);
        return "catalog";
    }
}
