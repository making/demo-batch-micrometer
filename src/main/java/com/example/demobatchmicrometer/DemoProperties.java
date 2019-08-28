package com.example.demobatchmicrometer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "demo")
public class DemoProperties {

    private Resource csvSource;

    public Resource getCsvSource() {
        return csvSource;
    }

    public void setCsvSource(Resource csvSource) {
        this.csvSource = csvSource;
    }
}