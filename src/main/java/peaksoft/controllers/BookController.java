package peaksoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Book;
import peaksoft.service.BookService;
import peaksoft.service.UserService;


@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getBooks(Model model) {
        model.addAttribute("books",bookService.getAll());
        return "/book";
    }

    @GetMapping("/create")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        return "/createBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/books/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/editBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute Book book, @PathVariable("id") Long id) {
        bookService.update(id, book);
        return "redirect:/books/list";
    }

}
