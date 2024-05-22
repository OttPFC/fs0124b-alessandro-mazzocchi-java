package com.esercizio.M2S2G3.payloads;

import lombok.Getter;

@Getter
public class NewPostPayload {
    private int authorId;
    private String category;
    private String content;
    private double readingTime;
    private String title;
}
