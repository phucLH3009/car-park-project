package com.phuclh.carparkproject.entity.converter;

import javax.persistence.AttributeConverter;

public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean aBoolean) {
        return (aBoolean != null && aBoolean) ? "M" : "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String s) {
        return "F".equalsIgnoreCase(s);
    }
}
