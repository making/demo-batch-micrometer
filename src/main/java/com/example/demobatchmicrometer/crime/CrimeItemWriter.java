package com.example.demobatchmicrometer.crime;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class CrimeItemWriter implements ItemWriter<Crime> {
    private static final Logger log = LoggerFactory.getLogger(CrimeItemWriter.class);

    @Override
    public void write(List<? extends Crime> items) throws Exception {
        log.info("<=====");
        items.forEach(i -> log.info(">> {}:{}", i.getItemCount(), i));
        log.info("=====>");
        Thread.sleep(300);
    }
}