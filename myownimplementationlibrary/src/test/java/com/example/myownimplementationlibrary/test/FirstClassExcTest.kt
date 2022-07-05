package com.example.myownimplementationlibrary.test


import com.example.myownimplementationlibrary.DIImplementation
import com.example.myownimplementationlibrary.FirstClass
import com.example.myownimplementationlibrary.FirstClassExc
import com.example.myownimplementationlibrary.SecondClass
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class FirstClassExcTest {
    private var diImplementation: DIImplementation? = null
    private var secondClass: SecondClass? = null
    private var firstClass: FirstClass? = null

    @Before
    fun config() {
        val setOfClasses: MutableSet<Class<*>> = HashSet()
        setOfClasses.add(FirstClassExc::class.java)
        setOfClasses.add(FirstClassExc::class.java)
        diImplementation = DIImplementation(setOfClasses)
        firstClass = diImplementation!!.fetchInstance<FirstClass>(FirstClass::class.java)
        secondClass = mock(SecondClass::class.java)
    //secondClass = mock(SecondClass::class.java)
    }

    @Test
    fun whenDisplayingSecondClassNameThenSecondClassInvoked() {
        doNothing().`when`<SecondClass?>(secondClass).displaySecondClassName()
        firstClass?.displayFirstClassName()
        verify(secondClass, times(1))?.javaClass?.name
    }

}

