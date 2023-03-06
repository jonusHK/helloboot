package com.bhkpo.springboot.study

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.context.runner.ApplicationContextRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.core.type.AnnotatedTypeMetadata

class ConditionalTest: AnnotationSpec() {
    @Test
    fun conditional() {
        // true
        ApplicationContextRunner().withUserConfiguration(Config1::class.java).run { context ->
            assertThat(context).hasSingleBean(MyBean::class.java)
            assertThat(context).hasSingleBean(Config1::class.java)
        }

        // false
        ApplicationContextRunner().withUserConfiguration(Config2::class.java).run { context ->
            assertThat(context).doesNotHaveBean(MyBean::class.java)
            assertThat(context).doesNotHaveBean(Config2::class.java)
        }
    }

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
    @Conditional(BooleanCondition::class)
    annotation class BooleanConditional(val value: Boolean)


    @Configuration
    @BooleanConditional(true)
    class Config1 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    @Configuration
    @BooleanConditional(false)
    class Config2 {
        @Bean
        fun myBean(): MyBean {
            return MyBean()
        }
    }

    class MyBean {}

    class BooleanCondition: Condition {
        override fun matches(conditionContext: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
            val annotationAttributes: MutableMap<String, Any>? =
                metadata.getAnnotationAttributes(BooleanConditional::class.java.name)
            return annotationAttributes?.get("value") as Boolean
        }
    }

}