package com.aj.rules.engine.rules;

import com.aj.rules.engine.Rule;
import com.aj.rules.engine.facts.TestFact2;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestRule2 extends Rule<TestFact2> {

    public TestRule2() {
        super(TestFact2.class);
    }

    @Override
    public Optional<String> evaluate(TestFact2 fact) {
        return fact.isFlag() ? Optional.empty() : Optional.of("0002");
    }

}
