package com.eecs1021;

import java.time.Instant;

public class WaterLevel {
    private final Instant instant;
    private final double value;

    public WaterLevel(Instant instant, double value) {
        this.instant = instant;
        this.value = value;
    }

    public Instant getInstant() {
        return instant;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("WaterLevel{instant=%s, value=%s}", instant, value);
    }
}
