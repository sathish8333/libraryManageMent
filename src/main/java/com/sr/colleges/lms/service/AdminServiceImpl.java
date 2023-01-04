package com.sr.colleges.lms.service;

import com.sr.colleges.lms.model.Book;
import com.sr.colleges.lms.model.User;
import com.sr.colleges.lms.repository.BooksRepository;
import com.sr.colleges.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AdminServiceImpl implements AdminService{

    @Autowired
    public BooksRepository booksRepository;

    @Autowired
    public UserRepository usersRepository;

    @Override
    public void registerUser(User user) {
        usersRepository.save(user);
    }

    @Override
    public Book registerBook(Book book) {
       return booksRepository.save(book);
    }
    @Override
    public Optional<Book> findBook(int id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book updateBook(int bookid, Map<String, Object> fields) {
        Optional<Book> existingBook = findBook(bookid);

        if (existingBook.isPresent()){
            fields.forEach((key,value)-> {
                Field field  = ReflectionUtils.findField(Book.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,existingBook.get(),value);

            });
            return registerBook(existingBook.get());
        }
        return null;
    }
}
