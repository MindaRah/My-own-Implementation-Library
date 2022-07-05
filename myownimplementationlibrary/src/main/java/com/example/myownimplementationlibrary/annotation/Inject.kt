package com.example.myownimplementationlibrary.annotation

// Interface for identifying and annotating variables to be included in the dependency injection implementation.
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Inject
