package com.blackcode.todo_app_be.dto;

import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder

public class TodoRes {

    private Long id;
    private String title;
    private String description;
    private String status;
}
