package com.dataart.enums;

public enum HotelType {
    ANY("Any"),
    CHECK_IN("Check in"),
    DAILY("Daily");

    private String value;

    HotelType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static HotelType getEnum(String value) {
        for (HotelType v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }
}
