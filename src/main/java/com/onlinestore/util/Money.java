package com.onlinestore.util;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA. User: Administrator Date: 3/18/16 Time: 11:00 AM To change this template use File | Settings | File
 * Templates.
 */
public class Money {

    private BigDecimal amount;

    private int        SCALE = 2;

    public Money(float amount) {
        this(new BigDecimal(amount));
    }

    public Money(BigDecimal amount) {
        if (amount.scale() > SCALE) {
            throw new IllegalArgumentException("Fractional part of a Money cannot be more than " + SCALE + " digit long!");
        }
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Money add(Money other) {
        return null;
    }

    public Money multiply(int other) {
        return new Money(amount.multiply(BigDecimal.valueOf(other)));
    }
}
