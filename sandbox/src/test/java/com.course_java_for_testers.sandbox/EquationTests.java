package com.course_java_for_testers.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {

    @Test
    public void testNumber0(){
        Equation e = new Equation(1,1,1);
        Assert.assertEquals(e.getNumder(),0);
    }

    @Test
    public void testNumber1(){
        Equation e = new Equation(1,2,1);
        Assert.assertEquals(e.getNumder(),1);
    }

    @Test
    public void testNumber2(){
        Equation e = new Equation(1,5,6);
        Assert.assertEquals(e.getNumder(),2);
    }
}
