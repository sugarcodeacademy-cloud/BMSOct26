package com.sugarcode.bookmyshowoct26.models;

import com.sugarcode.bookmyshowoct26.models.enums.PaymentStatus;
import com.sugarcode.bookmyshowoct26.models.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String referenceNumber;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    private double amount;
}
