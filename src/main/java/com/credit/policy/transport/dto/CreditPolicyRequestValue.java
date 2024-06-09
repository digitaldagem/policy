package com.credit.policy.transport.dto;

import lombok.Value;

@Value
public class CreditPolicyRequestValue {
    int customerAge;
    int customerDebt;
    int customerIncome;
    int paymentRemarks;
    int paymentRemarks12m;
    public boolean validate() {
        if (this.customerAge == 0)
            return false;
        if (this.customerDebt == 0)
            return false;
        if (this.customerIncome == 0)
            return false;
        if (this.paymentRemarks == 0)
            return false;
        return this.paymentRemarks12m >= 0;
    }
}
