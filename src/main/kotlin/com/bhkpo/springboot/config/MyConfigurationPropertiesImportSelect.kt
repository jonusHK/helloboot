package com.bhkpo.springboot.config

import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata
import org.springframework.util.MultiValueMap

class MyConfigurationPropertiesImportSelect: DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val attr: MultiValueMap<String, Any>? = importingClassMetadata.getAllAnnotationAttributes(EnableMyConfigurationProperties::class.qualifiedName!!)
        val propertyClass: Class<*>? = attr?.getFirst("value") as Class<*>?
        return arrayOf(propertyClass?.name ?: "")
    }
}

