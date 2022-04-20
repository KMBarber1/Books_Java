package com.katebarber.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.katebarber.books.models.Book;
import com.katebarber.books.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
	
    // SHOW ALL   
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    
	   // SHOW ONE
    @GetMapping("/books/{Id}")
    public String index(@PathVariable("Id") Long Id, Model model) {
    	Book book = bookService.findBook(Id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
    
}
