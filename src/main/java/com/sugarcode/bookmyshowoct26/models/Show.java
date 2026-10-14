package com.sugarcode.bookmyshowoct26.models;

import com.sugarcode.bookmyshowoct26.models.enums.Feature;
import com.sugarcode.bookmyshowoct26.models.enums.Language;
import com.sugarcode.bookmyshowoct26.models.enums.ShowStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel {
    private String name;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Theatre theatre;
    private Language language;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

    @Enumerated(EnumType.ORDINAL)
    private ShowStatus showStatus;


    /*

        1         1
       Show --- Movie--> M:1
       M            1

         1        1
       Show -- Theatre --> M: 1
       M        1

        1       1
       Show -- Screen --> M:1
       M        1


     */
}
