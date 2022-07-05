package com.example.myownimplementationlibrary

import com.example.myownimplementationlibrary.annotation.Inject


class FirstClassExc: FirstClass {
   @Inject
   private val secondClass: SecondClass? = null

   override fun displaySecondClassName() {
      secondClass!!.displaySecondClassName()
   }

   override fun displayFirstClassName() {
      println(javaClass.simpleName)
   }
}