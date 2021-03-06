package ru.hh.plugins.geminio.model.mapping.modifiers

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import ru.hh.plugins.geminio.model.enums.GeminioRecipeExpressionModifier
import ru.hh.plugins.geminio.tests_helpers.GeminioExpressionUtils


class CamelCaseToUnderlinesModifierSpec : FreeSpec({

    fun getEvaluatedValue(fragmentName: String): String? {
        return GeminioExpressionUtils.getEvaluatedValue(
            className = fragmentName,
            modifier = GeminioRecipeExpressionModifier.CAMEL_CASE_TO_UNDERLINES
        )
    }


    "Should be split to several words and joined with '_'" {
        getEvaluatedValue("superCase") shouldBe "super_case"
    }

    "One word will be converted into lower case" {
        getEvaluatedValue("Single") shouldBe "single"
        getEvaluatedValue("one") shouldBe "one"
    }

    "Every letter in upper case should be recognized as separate word" {
        getEvaluatedValue("FAQActivity") shouldBe "f_a_q_activity"
        getEvaluatedValue("BlankFragment") shouldBe "blank_fragment"
    }

})