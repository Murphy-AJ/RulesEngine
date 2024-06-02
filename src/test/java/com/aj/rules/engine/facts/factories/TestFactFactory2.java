package com.aj.rules.engine.facts.factories;

import com.aj.rules.engine.Data;
import com.aj.rules.engine.Fact;
import com.aj.rules.engine.facts.TestFact2;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestFactFactory2 implements FactFactory {

    @Override
    public Optional<Fact> build(Data data) {
        return Optional.of(
                TestFact2.builder()
                        .flag(data.isFlag2())
                        .build()
        );
    }

}
