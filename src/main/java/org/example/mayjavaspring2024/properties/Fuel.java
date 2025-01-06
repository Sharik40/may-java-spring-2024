package org.example.mayjavaspring2024.properties;

import lombok.Data;

import java.util.List;

//@Data
public class Fuel {
    private String name;
    private List<String> types;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
