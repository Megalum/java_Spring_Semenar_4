package ru.gb.springhwl3.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long genId;

    private final long id;
    private final long idReader;
    private final long idBook;
    private LocalDateTime receiving;
    private LocalDateTime refund;

    public Issue(long idReader, long idBook, LocalDateTime receiving){
        id = genId++;
        this.idBook = idBook;
        this.idReader = idReader;
        this.receiving = receiving;
    }

    public void refundBook(LocalDateTime refund){
        this.refund = refund;
    }
}
