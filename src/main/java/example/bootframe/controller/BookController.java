package example.bootframe.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import example.bootframe.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {
    @Resource
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value="/getContent",method = {RequestMethod.POST})
    public JSONObject getContent(String url) {
        return bookService.getContent(url, "content");
    }

    @RequestMapping("/getCatalog")
    public String getCatalog(HttpServletRequest request, Model model) {
        String url = request.getParameter("url");
        JSONObject str = bookService.getCatalog(url, "listmain");
        model.addAttribute("catalog", str);
        return "catalog";
    }

    @RequestMapping(value="/getContent",method={RequestMethod.GET})
    public String getContent(HttpServletRequest request, Model model) {
        String url = request.getParameter("url");
        System.out.println(url);
        if ("".equals(url) || url == null) {
            return "/getContent";
        }
        JSONObject str = bookService.getContent(url, "content");
        model.addAttribute("content", str);
        return "content";
    }
}
