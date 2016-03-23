package com.onlinestore.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Util class to wrap Money functionality
 */
public class Money implements Serializable {

    private BigDecimal amount;

    private int SCALE = 2;

    public Money() {
    }

    public Money(Float amount) {
        this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public Money(BigDecimal amount) {
        if (amount.scale() > SCALE) {
            amount = amount.setScale(SCALE, RoundingMode.CEILING);
        }
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
        this.amount = this.amount.setScale(2, RoundingMode.CEILING);
    }

    public Money add(Money other) {
        return new Money(amount.add(other.amount));
    }

    public Money multiply(int other) {
        return new Money(amount.multiply(BigDecimal.valueOf(other)));
    }

    public Money multiply(float other) {
        return new Money(amount.multiply(BigDecimal.valueOf(other)));
    }

    @Override
    public String toString() {
        return amount + "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        Money money = (Money) o;

        if (SCALE != money.SCALE) return false;
        if (!amount.equals(money.amount)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + SCALE;
        return result;
    }
}
