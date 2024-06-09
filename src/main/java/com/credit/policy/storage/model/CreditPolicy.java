package com.credit.policy.storage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CreditPolicy {
    @Id
    private UUID id;
    private int customerAge;
    private int customerDebt;
    private int customerIncome;
    private int paymentRemarks;
    private int paymentRemarks12m;
}
