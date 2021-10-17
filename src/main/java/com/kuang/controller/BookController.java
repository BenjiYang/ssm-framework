package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    // controller层调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部书籍，并且返回一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    // 跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "addBook";
    }

    // 添加书籍到请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook=>" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook";  // 重定向到 @RequestMapping("/allBook") 请求；
    }

    // 跳转到修改页面
    @RequestMapping("/toUpdate")
    public String toUpdate(int id, Model model) {
        Books book = bookService.queryBookById(id);
        model.addAttribute("QBook", book);
        return "updateBook";
    }

    // 修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        int i = bookService.updateBook(books);
        if (i>0) {
            System.out.println("修改books成功" + books);
        } else {
            System.out.println("修改books失败" + books);
        }
        return "redirect:/book/allBook";
    }

    // 删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        int i = bookService.deleteBookById(id);
        if (i>0) {
            System.out.println("删除books成功" + id);
        } else {
            System.out.println("删除books失败" + id);
        }
        return "redirect:/book/allBook";
    }
}
