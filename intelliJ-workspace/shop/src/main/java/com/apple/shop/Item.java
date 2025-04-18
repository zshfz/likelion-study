package com.apple.shop;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String title;
    public Integer price;
}

@Entity
class 어쩌구 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String date;
}
