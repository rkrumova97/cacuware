package com.cacuware.warehouse.mapper;

import org.springframework.data.convert.Jsr310Converters.LocalDateToDateConverter;
import org.springframework.data.convert.Jsr310Converters.DateToLocalDateConverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;
import java.util.Date;

@Converter(autoApply = true)
public class DateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        return LocalDateToDateConverter.INSTANCE.convert(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return DateToLocalDateConverter.INSTANCE.convert(date);
    }
}
