package com.example.myownimplementationlibrary

import com.example.myownimplementationlibrary.annotation.Inject


/**
 * Initialising and providing objects with dependencies to the app.
 */
class DIImplementation(classCollection: Collection<Class<*>>) {
    private val references: MutableSet<Any> = HashSet()


    // Find out whether the class has any variables or not as dependencies.
    @Throws(Exception::class)
    private fun createInjectionRef(references: Collection<Class<*>>) {
        for (refClass in references) {
            val refConstructor = refClass.getConstructor()
            refConstructor.isAccessible = true
            this.references.add(refConstructor.newInstance())
        }
        for (refInstance in this.references) {
            for (variable in refInstance.javaClass.declaredFields) {
                if (!variable.isAnnotationPresent(Inject::class.java)) {
                    continue
                }
                val variableType = variable.type
                variable.isAccessible = true
                for (similarInstance in this.references) {
                    if (variableType.isInstance(similarInstance)) {
                        variable[refInstance] = similarInstance
                    }
                }
            }
        }
    }

    /**
     * Method which receives a class parameter and then returns
     * that as an object of that type
     * @param reference
     */
    fun <T> fetchInstance(reference: Class<T>): T? {
        for (dependency in references) {
            if (reference.isInstance(dependency)) {
                return dependency as T
            }
        }
        //Match doesn't exist
        return null
    }

    init {
        try {
            createInjectionRef(classCollection)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}