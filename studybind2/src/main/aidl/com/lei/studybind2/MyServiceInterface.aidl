// MyServiceInterface.aidl
package com.lei.studybind2;

// Declare any non-default types here with import statements

interface MyServiceInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
    int sum(int a, int b);
}