package com.aj.rules.engine;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RulesEngine {

    public List<String> evaluate(List<Rule> rules, List<Fact> facts) {
        List<String> firedRules = facts.stream()
                .flatMap(fact -> rules.stream()
                        .map(rule -> evaluateRule(rule, fact))
                        .filter(Optional::isPresent)
                        .map(Optional::get))
                .collect(Collectors.toList());

        return firedRules;
    }

    private Optional<String> evaluateRule(Rule rule, Fact fact) {
        if (rule.isApplicable(fact)) {
            return rule.evaluate(fact);
        }
        return Optional.empty();
    }
}
