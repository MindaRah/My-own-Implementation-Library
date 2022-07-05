package com.example.myownimplementationlibrary

import com.example.myownimplementationlibrary.annotation.Inject

class SecondClassExc: SecondClass {
    @Inject
    private val firstClass: FirstClass? = null

    override fun displayFirstClassName() {
        firstClass!!.displayFirstClassName()
    }

    override fun displaySecondClassName() {
        println(javaClass.simpleName)
    }
}