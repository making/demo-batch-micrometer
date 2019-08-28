package com.example.demobatchmicrometer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.batch.job.enabled=false")
class DemoBatchMicrometerApplicationTests {

    @Test
    void contextLoads() {
    }

}
