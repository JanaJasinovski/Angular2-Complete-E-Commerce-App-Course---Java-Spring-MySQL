package com.bookstore.service;

import com.bookstore.domain.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
	
	List<Book> findAll();
	
	Book findOne(Long id);
	
	Book save(Book book);

	MultipartFile getBookImageById(Long id);
	List<Book> blurrySearch(String title);
	
	void removeOne(Long id);
}
