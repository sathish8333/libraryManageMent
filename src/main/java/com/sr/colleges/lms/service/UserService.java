package com.sr.colleges.lms.service;

import com.sr.colleges.lms.model.Book;

import java.util.List;

public interface UserService {
    List<Book> getAvailableBooks();

    Book getBookDetails(int bookId);

    int getAvailableBooksCount(int bookId);

    int getRemainingBooksCountForUser(int bookId);
}
