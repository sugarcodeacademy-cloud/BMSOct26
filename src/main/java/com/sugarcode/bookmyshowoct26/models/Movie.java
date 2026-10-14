package com.sugarcode.bookmyshowoct26.models;

import com.sugarcode.bookmyshowoct26.models.enums.Feature;
import com.sugarcode.bookmyshowoct26.models.enums.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String name;
    private Date realeaseDate;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;
    private String rating;

}

/*
arr = [1,2,3,4,5,67, 876547]

arr = ["hello", "Hi","HelloWorled","HelloWorld"]

arr[helloWorld]

a= 67
b =67
a == b

a = "Hello"
b= "Hello"

a == b


 */
