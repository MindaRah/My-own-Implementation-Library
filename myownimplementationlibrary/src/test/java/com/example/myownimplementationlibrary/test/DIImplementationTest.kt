package com.example.myownimplementationlibrary.test

import com.example.myownimplementationlibrary.*
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class DIImplementationTest {
    private var diImplementation: DIImplementation? = null

    @Before
    fun config() {
        val setOfClasses: MutableSet<Class<*>> = HashSet()
        setOfClasses.add(FirstClassExc::class.java)
        setOfClasses.add(SecondClassExc::class.java)
        diImplementation = DIImplementation(setOfClasses)
    }

    @Test
    fun fetchInstanceNotExisting() {
        val thirdClass: ThirdClass? = diImplementation?.fetchInstance(ThirdClass::class.java)
        assertNull(thirdClass)
    }

    @Test
    fun fetchFirstClassInstance() {
        val firstClass: FirstClass? = diImplementation?.fetchInstance<FirstClass>(FirstClass::class.java)
        assertNotNull(firstClass)
    }

    @Test
    fun fetchSecondClassInstance() {
        val secondClass: SecondClass? = diImplementation?.fetchInstance<SecondClass>(SecondClass::class.java)
        assertNotNull(secondClass)
    }
}