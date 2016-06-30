package com.dataart.enums;

public enum RoomView {
    GARBAGE("Garbage"),
    POOL("Pool"),
    SEA("Sea");

    private String value;

    RoomView(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RoomView getEnum(String value) {
        for (RoomView v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }
}
