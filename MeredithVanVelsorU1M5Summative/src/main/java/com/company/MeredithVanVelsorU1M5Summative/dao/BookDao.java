package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Book;

import java.util.List;

public interface BookDao {
    // Create
    Book addBook(Book book);
    // Read
    Book getBook(int id);
    // Read All
    List<Book> getAllBooks();
    // Update
    void updateBook(Book book);
    // Delete
    void deleteBook(int id);
    // Get Books by Author
    List<Book> getBooksByAuthor(int authorId);

}
