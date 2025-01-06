package org.example.mayjavaspring2024.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

//@Data
@Component
@ConfigurationProperties(prefix = "reference-data")
public class ReferenceDataProperties {
    private List<String> engineTypes;
    private List<Fuel> fuels;

    public List<String> getEngineTypes() {
        return engineTypes;
    }

    public void setEngineTypes(List<String> engineTypes) {
        this.engineTypes = engineTypes;
    }

    public List<Fuel> getFuels() {
        return fuels;
    }

    public void setFuels(List<Fuel> fuels) {
        this.fuels = fuels;
    }
}
