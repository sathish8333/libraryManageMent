package com.sr.colleges.lms.service;

import com.sr.colleges.lms.model.Book;
import com.sr.colleges.lms.model.User;
import com.sr.colleges.lms.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{

    @Autowired
    public BooksRepository booksRepository;

    @Override
    public List<Book> getAvailableBooks() {
        return booksRepository.findAll();
    }

    @Override
    public Book getBookDetails(int bookId) {
        return booksRepository.getById(bookId);
    }

    @Override
    public int getAvailableBooksCount(int bookId) {
        return 0;
    }

    @Override
    public int getRemainingBooksCountForUser(int bookId) {
        return 0;
    }
}
