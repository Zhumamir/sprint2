package com.bitlab.sprint2.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "APPLICATION_REQUEST")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "HANDLED", columnDefinition = "boolean default false")
    private boolean handled;
}