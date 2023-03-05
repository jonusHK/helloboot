package tobyspring.config

import org.springframework.context.annotation.Import

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Import(MyAutoConfigImportSelector::class)
annotation class EnableMyAutoConfiguration