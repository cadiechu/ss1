package ra.orm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.orm1.model.Author;
import ra.orm1.model.Book;
import ra.orm1.reppsitory.IAuthorRepo;
import ra.orm1.reppsitory.IBookRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
@EnableSpringDataWebSupport
public class BookController {
    @Autowired
    private IBookRepo bookRepo;
    @Autowired
    private IAuthorRepo authorRepo;

    @RequestMapping("/add")
    public String add() {
        Book book = new Book(8L, "Hiep Sy Lon", "Nghe Sy Vo Danh");
        Book book1 = new Book(9L, "Den Men", "To Hoai");
        Book book2 = new Book(10L, "Sóng", "Xuan Dieu");
        //Thêm mới
        bookRepo.save(book);
        bookRepo.save(book2);
        bookRepo.save(book1);
        //Thêm Author
        book1.setAuthor_name(book1.getAuthor_name());
        book2.setAuthor_name(book2.getAuthor_name());
        book.setAuthor_name(book.getAuthor_name());
        return "home";
    }

    @RequestMapping("/listBook")
    public String listBook() {
        List<Book> ls = bookRepo.findAll();
        List<Author> la = authorRepo.findAll();
        return "home";
    }
}
