package com.example.demobatchmicrometer;

import com.example.demobatchmicrometer.crime.Crime;
import com.example.demobatchmicrometer.crime.CrimeFieldSetMapper;
import com.example.demobatchmicrometer.crime.CrimeItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.support.PassThroughItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    private final DemoProperties props;

    private final CrimeItemWriter crimeItemWriter;

    public BatchJobConfig(JobBuilderFactory jobBuilderFactory,
                          StepBuilderFactory stepBuilderFactory, DemoProperties props,
                          CrimeItemWriter crimeItemWriter) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.props = props;
        this.crimeItemWriter = crimeItemWriter;
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("step") //
            .<Crime, Crime>chunk(3) //
            .reader(crimeItemReader()) //
            .processor(new PassThroughItemProcessor<>()) //
            .writer(this.crimeItemWriter) //
            .build();
    }

    @Bean
    public FlatFileItemReader<Crime> crimeItemReader() {
        return new FlatFileItemReaderBuilder<Crime>() //
            .name("crimeItemReader") //
            .delimited()
            .names(new String[]{"cdatetime", "address", "district", "beat", "grid",
                "crimedescr", "ucr_ncic_code", "latitude", "longitude"}) //
            .linesToSkip(1) //
            .fieldSetMapper(new CrimeFieldSetMapper()) //
            .resource(this.props.getCsvSource()) //
            .build();
    }

    @Bean
    public Job job() {
        return this.jobBuilderFactory.get("job") //
            .incrementer(new RunIdIncrementer()) //
            .start(step()) //
            .build();
    }
}
