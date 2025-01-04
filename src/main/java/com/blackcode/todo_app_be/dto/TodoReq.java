package com.blackcode.todo_app_be.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoReq {

    private String title;
    private String description;
    private String status;

}
