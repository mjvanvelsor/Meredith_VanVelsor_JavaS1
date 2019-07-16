package com.company.MeredithVanVelsorU1M5Summative.dao;

import com.company.MeredithVanVelsorU1M5Summative.dto.Publisher;

import java.util.List;

public interface PublisherDao {
    // Create
    Publisher addPublisher(Publisher publisher);
    // Read
    Publisher getPublisher(int id);
    // Read All
    List<Publisher> getAllPublishers();
    // Update
    void updatePublisher(Publisher publisher);
    // Delete
    void deletePublisher(int id);

}
