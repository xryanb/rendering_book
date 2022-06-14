package com.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mvc.models.Book;
import com.mvc.services.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	
		@GetMapping("/books/{bookId}")
		public String index(@PathVariable("bookId") Long bookId, Model model){
			System.out.println(bookId);
			Book book=bookService.findBook(bookId);
			System.out.println(book);
//			ArrayList<Book> books= (ArrayList<Book>) bookService.allBooks();
			model.addAttribute("book",book);
//			model.addAttribute("books",books);
			
			return "index.jsp";
		}
}
