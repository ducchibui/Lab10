/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.BookService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author CBui
 */
@Entity
@Data
public class Book {
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private long id;
    
    private String title;
    private String author;
    private String description;
}
