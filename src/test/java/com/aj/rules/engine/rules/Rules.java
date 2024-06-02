package com.aj.rules.engine.rules;

import com.aj.rules.engine.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Rules {
    private final TestRule testRule;
    private final TestRule2 testRule2;

    public List<Rule> getRules() {
        return Arrays.asList(testRule, testRule2);
    }
}
