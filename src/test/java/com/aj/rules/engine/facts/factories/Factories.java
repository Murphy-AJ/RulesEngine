package com.aj.rules.engine.facts.factories;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Factories {
    private final TestFactFactory testFactFactory;
    private final TestFactFactory2 testFactFactory2;

    public List<FactFactory> getFactories() {
        return Arrays.asList(testFactFactory, testFactFactory2);
    }
}