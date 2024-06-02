package com.aj.rules.engine.rules;

import com.aj.rules.engine.Rule;
import com.aj.rules.engine.facts.TestFact;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TestRule extends Rule<TestFact> {

    public TestRule() {
        super(TestFact.class);
    }

    @Override
    public Optional<String> evaluate(TestFact fact) {
        return fact.isFlag() ? Optional.empty() : Optional.of("0001");
    }

}
