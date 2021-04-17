package com.dazzilove.app.worddrill.domain;

public enum LangCodeEnum {
    ENGLISH("01", "English"),
    JAPANESE("02", "Japanese");

    private String code;
    private String name;

    LangCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name();
    }
}

