package com.BookStore.Bookstop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.Bookstop.entity.Book;
@Repository
public interface Bookrepository extends JpaRepository<Book,Integer>{

}
