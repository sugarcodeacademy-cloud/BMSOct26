package com.sugarcode.bookmyshowoct26.models;

import com.sugarcode.bookmyshowoct26.models.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    private Double price;


    /*
        1              1
    ShowSeatType --- Show ---> M :1
        M             1

    Show --> X , Y , Z
    SeatType --> GOLD, SILVER

    XGOLD --> X
    XSILVER

     */
}
