package com.example.myownimplementationlibrary.test

import com.example.myownimplementationlibrary.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*


class SecondClassExcTest {
    private var diImplementation: DIImplementation? = null
    private var firstClass: FirstClass? = null
    private var secondClass: SecondClass? = null

    @Before
    fun config() {
        val setOfClasses: MutableSet<Class<*>> = HashSet()
        setOfClasses.add(FirstClassExc::class.java)
        setOfClasses.add(SecondClassExc::class.java)
        diImplementation = DIImplementation(setOfClasses)
        secondClass = diImplementation!!.fetchInstance<SecondClass>(SecondClass::class.java)
        firstClass = mock(FirstClass::class.java)
    }

    @Test
    fun whenDisplayingFirstClassNameThenFirstClassInvoked() {
        doNothing().`when`<FirstClass?>(firstClass).displayFirstClassName()
        secondClass?.displayFirstClassName()
        verify(firstClass, times(1))?.javaClass?.name
    }
}