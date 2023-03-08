package com.bhkpo.springboot.config

import org.springframework.context.annotation.Condition
import org.springframework.context.annotation.ConditionContext
import org.springframework.core.type.AnnotatedTypeMetadata
import org.springframework.util.ClassUtils

class MyOnClassCondition: Condition {
    override fun matches(context: ConditionContext, metadata: AnnotatedTypeMetadata): Boolean {
        val attrs: Map<String, Any>? = metadata.getAnnotationAttributes(ConditionalMyOnClass::class.java.name)
        val value: String? = attrs?.get("value") as String?
        return value?.let { ClassUtils.isPresent(it, context.classLoader) } ?: false
    }
}
