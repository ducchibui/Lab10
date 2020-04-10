/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.EdgeService;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author CBui
 */
@Data
public class Book {

    @GeneratedValue
    @Id
    private long id;

    private String title;
    private String author;
    private String description;
}
