package com.aj.rules.engine.facts.factories;

import com.aj.rules.engine.Data;
import com.aj.rules.engine.Fact;
import com.aj.rules.engine.facts.TestFact;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestFactFactory implements FactFactory {

    @Override
    public Optional<Fact> build(Data data) {
        return Optional.of(
                TestFact.builder()
                        .flag(data.isFlag1())
                        .build()
        );
    }
}
