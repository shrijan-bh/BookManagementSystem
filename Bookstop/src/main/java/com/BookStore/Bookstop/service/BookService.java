package com.BookStore.Bookstop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.Bookstop.entity.Book;
import com.BookStore.Bookstop.repository.Bookrepository;

@Service
public class BookService {
	@Autowired
	private Bookrepository bRepo;

	public void save(Book b) {
		bRepo.save(b);

	}

	public List<Book> getAllBook() {
		return bRepo.findAll();
	}

	public Book getBookById(int id) {
		return bRepo.findById(id).get();
	}
	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
