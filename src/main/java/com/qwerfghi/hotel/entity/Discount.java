package com.qwerfghi.hotel.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Discount {
    ZERO("0%"), FIVE("5%"), TEN("10%"), TWENTY("20%");

    private final String discount;

    Discount(String discount) {
        this.discount = discount;
    }

    @JsonValue
    public String getDiscount() {
        return discount;
    }

    public static Discount fromCode(String value) {
        switch (value) {
            case "0%":
                return ZERO;
            case "5%":
                return FIVE;
            case "10%":
                return TEN;
            case "20%":
                return TWENTY;
            default:
                return null;
        }
    }
}