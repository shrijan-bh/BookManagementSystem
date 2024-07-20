package com.BookStore.Bookstop.controller;

import java.util.*;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.BookStore.Bookstop.entity.Book;
import com.BookStore.Bookstop.entity.MyBookList;
import com.BookStore.Bookstop.service.BookService;
import com.BookStore.Bookstop.service.MyBookListService;


@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;

	@GetMapping("/")
	public String home() {
		return "Home";
	}

	@GetMapping("/bookRegister")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/availableBook")
	public ModelAndView availableBook() {
		List<Book> list = service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("availableBook");
//		m.addObject("book",list);
		return new ModelAndView("availableBook", "book", list);

	}

	@GetMapping("/myBook")
	public String myBook(Model model) {
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBook";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/availableBook";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice(),b.getType());
		myBookService.saveMyBooks(mb);
		return "redirect:/myBook";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book", b);
		return"bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/availableBook";
	}

}
