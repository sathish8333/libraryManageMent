package com.sr.colleges.lms.controller;

import com.sr.colleges.lms.model.Book;
import com.sr.colleges.lms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/loadAllBooks")
    public List<Book> getAvailableBooks() {
        return userService.getAvailableBooks();
    }

    @GetMapping("/loadBookDetails/{bookId}")
    public Book getBookDetails(@PathVariable int bookId) {
        return userService.getBookDetails(bookId);
    }

    @GetMapping("/loadAvailableBooksCount/{bookId}")
    public int getAvailableBooksCount(@PathVariable int bookId) {
        return userService.getAvailableBooksCount(bookId);
    }

    @GetMapping("/loadRemainingBooksCount/{bookId}")
    public int getRemainingBooksCountForUser(@PathVariable int bookId) {
        return userService.getRemainingBooksCountForUser(bookId);
    }
}
