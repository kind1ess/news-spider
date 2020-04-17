package com.kind1ess.newsspider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "time")
    private String time;

    @Column(name = "source")
    private String source;

    @Column(name = "key_word")
    private String keyWord;

    @Column(name = "content")
    private String content;

    @Column(name = "author")
    private String author;

    @Column(name = "url")
    private String url;
}
