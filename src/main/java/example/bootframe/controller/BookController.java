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
        return bookService.searchBook(url, "");
    }

//    @ResponseBody
//    @RequestMapping("/getContent")
//    public JSONObject getContent(String url) {
//        return bookService.getContent(url, "content");
//    }

    @RequestMapping("/getCatalog")
    public String getCatalog(HttpServletRequest request, Model model) {
        String url = request.getParameter("url");
        JSONObject str = bookService.getCatalog(url, "listmain");
        model.addAttribute("catalog", str);
        return "catalog";
    }

    @RequestMapping("/getContent")
    public String getContent(HttpServletRequest request, Model model) {
        String url = request.getParameter("url");
        JSONObject str = bookService.getContent(url, "content");
        model.addAttribute("content", str);
        return "content";
    }
}
