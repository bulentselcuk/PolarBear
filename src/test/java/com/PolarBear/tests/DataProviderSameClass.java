package com.PolarBear.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSameClass
{
    @Test(dataProvider="data-provider")
    public void testMethod(String veli) {
        System.out.println (veli);
        System.out.println (" Buraya yazilan calisir");
    }

    @DataProvider(name="data-provider")
    public Object [][] dataProviderMethod() {
        return new Object [][]
        {
                {"first working"},
                {"second second working"},
                {"third working"}
        };
    }
}
