package com.credit.policy.service;

import com.credit.policy.storage.model.CreditPolicy;
import lombok.Getter;

public class PolicyCheck {
    @Getter
    public enum Result {
        ACCEPT("ACCEPT"),
        LOW_INCOME("LOW_INCOME"),
        HIGH_DEBT_FOR_INCOME("HIGH_DEBT_FOR_INCOME"),
        PAYMENT_REMARKS_12M("PAYMENT_REMARKS_12M"),
        PAYMENT_REMARKS("PAYMENT_REMARKS"),
        UNDERAGE("UNDERAGE");

        private final String value;

        Result(String value) {
            this.value = value;
        }

    }

    public static String checkPolicy(CreditPolicy creditPolicy) {
        if (creditPolicy.getCustomerIncome() < 500) {
            return Result.LOW_INCOME.getValue();
        } else if (creditPolicy.getCustomerDebt() > (creditPolicy.getCustomerIncome() / 2)) {
            return Result.HIGH_DEBT_FOR_INCOME.getValue();
        } else if (creditPolicy.getPaymentRemarks12m() > 0) {
            return Result.PAYMENT_REMARKS_12M.getValue();
        } else if (creditPolicy.getPaymentRemarks() > 1) {
            return Result.PAYMENT_REMARKS.getValue();
        } else if (creditPolicy.getCustomerAge() < 18) {
            return Result.UNDERAGE.getValue();
        } else {
            return Result.ACCEPT.getValue();
        }
    }
}
