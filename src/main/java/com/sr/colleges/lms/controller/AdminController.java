package com.sr.colleges.lms.controller;

import com.sr.colleges.lms.constants.LmsConstants;
import com.sr.colleges.lms.model.Book;
import com.sr.colleges.lms.model.User;
import com.sr.colleges.lms.service.AdminService;
import com.sr.colleges.lms.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/registeruser")
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        logger.info("request body is " + user);
        adminService.registerUser(user);
        return new ResponseEntity<>(LmsConstants.USER_SUCCESS, HttpStatus.CREATED);
    }

    @PostMapping("/addnewbook")
    @ResponseBody
    public ResponseEntity<String> registerBook(@RequestBody Book book) {
        adminService.registerBook(book);
        return new ResponseEntity<>(LmsConstants.BOOK_ADDED_SUCCESSFULLY, HttpStatus.CREATED);
    }

    @PostMapping("/addnewbookWithImage")
    @ResponseBody
    public ResponseEntity<String> registerBookWithImage(@RequestParam(name = "image", required = false) MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("author") String author, @RequestParam("count") String count) throws IOException {

        Book book = adminService.registerBook(Book.builder().image(ImageUtils.compressImage(file.getBytes()))
                .bookName(name).bookDescription(description).bookAuthor(author)
                .noOfBooksAvailable(Integer.parseInt(count)).build());
        if (book != null) {
            return new ResponseEntity<>("Book " + file.getOriginalFilename() + " was added successfully", HttpStatus.CREATED);
        }
        return null;
    }

    @PatchMapping("/addnewbookWithImage/{bookid}")
    @ResponseBody
    public ResponseEntity<String> updateBookDetails(int bookid, Map<String,Object> fields) {
        if (adminService.updateBook(bookid, fields)!=null){
            return new ResponseEntity<>("Book was added successfully", HttpStatus.CREATED);
        }
        return null;
    }
}
