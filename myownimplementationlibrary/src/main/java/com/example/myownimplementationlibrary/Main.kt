package com.example.myownimplementationlibrary

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val diImplementation = createDependencyImplementation()
        executeTask(diImplementation)
    }

    /**
     * Method invokes dependencies
     * @param implementation
     */
    private fun executeTask(implementation: DIImplementation) {
        val firstClass = implementation.fetchInstance(FirstClass::class.java)
        val secondClass = implementation.fetchInstance(SecondClass::class.java)
        secondClass!!.displayFirstClassName()
        firstClass!!.displaySecondClassName()
    }

    private fun createDependencyImplementation(): DIImplementation {
        val setOfClasses: MutableSet<Class<*>> = HashSet()
        setOfClasses.add(FirstClassExc::class.java)
        setOfClasses.add(SecondClassExc::class.java)
        return DIImplementation(setOfClasses)
    }
}