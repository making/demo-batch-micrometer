package com.example.demobatchmicrometer.crime;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class CrimeFieldSetMapper implements FieldSetMapper<Crime> {

    @Override
    public Crime mapFieldSet(FieldSet fieldSet) throws BindException {
        Crime crime = new Crime();
        crime.setCdatetime(fieldSet.readString("cdatetime"));
        crime.setAddress(fieldSet.readString("address"));
        crime.setDistrict(fieldSet.readInt("district"));
        crime.setBeat(fieldSet.readString("beat"));
        crime.setGrid(fieldSet.readInt("grid"));
        crime.setCrimedescr(fieldSet.readString("crimedescr"));
        crime.setUcrNcicCode(fieldSet.readInt("ucr_ncic_code"));
        crime.setLatitude(fieldSet.readDouble("latitude"));
        crime.setLongitude(fieldSet.readDouble("longitude"));
        return crime;
    }
}
