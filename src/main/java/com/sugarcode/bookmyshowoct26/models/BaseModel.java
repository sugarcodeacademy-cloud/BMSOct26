package com.sugarcode.bookmyshowoct26.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass //create all the attributes present in BaeModel in all the child class tables
public class BaseModel {
    @Id //PK for all the child classes of the BaseModel
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long id;
    private Date createdAt;
    private Date LastModifiedAt;
}
