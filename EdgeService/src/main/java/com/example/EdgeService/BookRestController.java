/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EdgeService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CBui
 */
@RestController
public class BookRestController {
    
    @Autowired
    IBookClient client;
    
    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:8080")
    @HystrixCommand(fallbackMethod = "fallbackBooks")
    public Collection<Book> getBooks() 
    {
       return client.readBooks().getContent()
                .stream().collect(Collectors.toList());
    }
    
    public Collection<Book> fallbackBooks() 
    {
        List<Book> books = new ArrayList<>();
        
        Book book = new Book();
        book.setId(1);
        book.setTitle("Fall back book title");
        book.setAuthor("Fall back book author");
        book.setDescription("Book fall back description");
        books.add(book);
        
        return books;
    }
}
