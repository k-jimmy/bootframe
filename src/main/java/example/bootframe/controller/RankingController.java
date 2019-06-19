package example.bootframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RankingController {
//    @Resource
//    private BookService bookService;

    @RequestMapping("/ranking")
    public String index(HttpServletRequest request, Model model) {
        String bookName = request.getParameter("bookName");
        model.addAttribute("book", bookName);
        return "ranking";
    }
}
