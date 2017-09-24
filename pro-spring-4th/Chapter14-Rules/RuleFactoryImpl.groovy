package com.sandbox.chapter14.ruleengine

import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * Created by andrii on 24.09.17.
 */
@Component
class RuleFactoryImpl implements RuleFactory {

    Closure age =
            { birthDate -> return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) }

    @Override
    Rule getAgeCategoryRule() {
        Rule rule = new Rule()
        rule.singlehit = true

        rule.conditions = [{ object, param -> age(object.birthDate) >= param },
                           { object, param -> age(object.birthDate) <= param }]

        rule.actions = [{ object, param -> object.ageCategory = param }]

        rule.parameters = [
                [0, 10, 'Kid'],
                [11, 20, 'Youth'],
                [21, 40, 'Adult'],
                [41, 60, 'Middle-aged'],
                [61, 120, 'Old']
        ]
        return rule
    }
}
