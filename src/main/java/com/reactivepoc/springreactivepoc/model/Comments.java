package com.reactivepoc.springreactivepoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    private String id;
    @Column("postId")
    private String postId;
    private String name;
    private String email;
    private String body;
}
