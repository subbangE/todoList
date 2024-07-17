package com.mysite.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 설정
    private Long id;

    private String content;

    private boolean completed;

}
