package com.dataart.enums;

public enum RoomType {
    SINGLE("Single"),
    DOUBLE("Double"),
    TWIN("Twin");

    private String value;

    RoomType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RoomType getEnum(String value) {
        for (RoomType v : values())
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }

        throw new IllegalArgumentException(String.format("Cannot convert '%s' value to enum", value));
    }
}
