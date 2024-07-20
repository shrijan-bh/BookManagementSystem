package com.BookStore.Bookstop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.Bookstop.entity.MyBookList;
@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
