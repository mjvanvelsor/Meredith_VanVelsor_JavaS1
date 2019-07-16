package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Author;

import java.util.List;

public interface AuthorDao {
    // Create
    Author addAuthor(Author author);
    // Read
    Author getAuthor(int id);
    // Read All
    List<Author> getAllAuthors();
    // Update
    void updateAuthor(Author author);
    // Delete
    void deleteAuthor(int id);
}
