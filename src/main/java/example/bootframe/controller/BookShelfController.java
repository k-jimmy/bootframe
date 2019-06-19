package example.bootframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BookShelfController {
//    @Resource
//    private BookService bookService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        return "default";
    }
//    @RequestMapping("/")
//    public String index(HttpServletRequest request, Model model) {
//        return "index";
//    }
    @RequestMapping("/bookShelf")
    public String bookShelf(HttpServletRequest request, Model model) {
//        String bookName = request.getParameter("bookName");
//        model.addAttribute("book", bookName);
        return "bookShelf";
    }
}
