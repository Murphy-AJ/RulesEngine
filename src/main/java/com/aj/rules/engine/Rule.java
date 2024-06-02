package com.aj.rules.engine;

import java.util.Optional;

public abstract class Rule<T extends Fact> {

    private final Class<T> type;

    public Rule(Class<T> type) {
        this.type = type;
    }

    public abstract Optional<String> evaluate(T fact);

    public boolean isApplicable(Fact fact) {
        return type.isInstance(fact);
    }

}
