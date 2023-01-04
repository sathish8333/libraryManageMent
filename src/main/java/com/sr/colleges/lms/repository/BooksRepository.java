package com.sr.colleges.lms.repository;

import com.sr.colleges.lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

    /*@Query("SELECT u FROM Student u WHERE u.studentRollNumber = :rollNumber")
    Book findStudentByRollNumber(@Param("rollNumber") String rollNumber);

    @Query("SELECT Max(u.studentSerialNumber) FROM Student u WHERE u.studentDepartment = :department")
    String getNewSerialNumber(@Param("department") String department);*/
}
