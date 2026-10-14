package com.sugarcode.bookmyshowoct26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;

    @OneToMany
    private List<Screen> screens;

    @ManyToOne
    private Region region;

    /*
        1        1
    Theatre -- Region --> M:1
    M               1

    Theatre -- Screen --> 1: M
     */
}
