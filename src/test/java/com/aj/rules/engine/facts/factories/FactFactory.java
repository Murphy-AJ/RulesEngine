package com.aj.rules.engine.facts.factories;

import com.aj.rules.engine.Data;
import com.aj.rules.engine.Fact;

import java.util.Optional;

public interface FactFactory {

    public Optional<Fact> build(Data data);

}
