package com.aj.rules.engine;

import com.aj.rules.engine.facts.factories.Factories;
import com.aj.rules.engine.rules.Rules;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
@RequiredArgsConstructor
class RulesEngineApplicationTest {

	@Autowired
	private RulesEngine rulesEngine;

	@Autowired
	private Factories factories;

	@Autowired
	private Rules rules;

	@ParameterizedTest
	@CsvSource({"false, false, '0001,0002'",
				"true, false, '0002'",
				"false, true, '0001'",
				"true, true,''"})
	void test(boolean flag1, boolean flag2, String expectedFiredRules) {
		Data data = Data.builder().flag1(flag1).flag2(flag2).build();
		List<Fact> facts = createFacts(data);

		List<String> firedRules = rulesEngine.evaluate(rules.getRules(), facts);
		Assertions.assertArrayEquals(splitExpectedRules(expectedFiredRules).toArray(), firedRules.toArray());
	}

	private List<Fact> createFacts(Data data) {
		return factories.getFactories().stream()
				.map(factory -> factory.build(data))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());
	}

	private List<String> splitExpectedRules(String expectedRules) {
		return Arrays.stream(expectedRules.split(","))
				.filter(rule -> !rule.isEmpty())
				.map(rule -> (String) rule)
				.collect(Collectors.toList());
	}
}