package com.aj.rules.engine.facts;

import com.aj.rules.engine.Fact;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestFact implements Fact {
    private boolean flag;
}
