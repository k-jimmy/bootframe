package example.bootframe.controller;

import com.alibaba.fastjson.JSONObject;
import example.bootframe.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
        return bookService.getContent(url,"content");
    }

    @RequestMapping("/catalog")
    public String list(HttpServletRequest request,Model model) {
        String url = request.getParameter("url");
        JSONObject str =bookService.getCatalog(url,"listmain");
        model.addAttribute("catalog", str);
        return "catalog";
    }
}
