package com.sr.colleges.lms.service;

import com.sr.colleges.lms.model.Book;
import com.sr.colleges.lms.model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdminService {

    void registerUser(User user);

    Book registerBook(Book book);
    Optional<Book> findBook(int id);
    Book updateBook(int bookid, Map<String,Object> fields);
}
