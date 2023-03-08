package com.bhkpo.springboot.config

import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata
import java.util.*

class MyAutoConfigImportSelector(val classLoader: ClassLoader): DeferredImportSelector {
    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val autoConfigs: ArrayList<String> = ArrayList()
        ImportCandidates.load(MyAutoConfiguration::class.java, classLoader).forEach(autoConfigs::add)
        return autoConfigs.toTypedArray()
    }
}
