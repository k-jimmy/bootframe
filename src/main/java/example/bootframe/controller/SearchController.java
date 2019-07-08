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
public class SearchController {
    @Resource
    private BookService bookService;

    @RequestMapping("/search")
    public String index(HttpServletRequest request, Model model) {
        String bookName = request.getParameter("bookName");
        model.addAttribute("book", bookName);
        return "search";
    }

    @ResponseBody
    @RequestMapping("/searchBook")
    public String searchBook(String url) {
        return bookService.searchBook(url, "");
    }
}

