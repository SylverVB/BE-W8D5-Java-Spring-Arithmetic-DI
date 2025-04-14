package com.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArithmeticPresentationLayerTest {
    static ArithmeticPresentationLayer app;
    static ApplicationContext context;

    @BeforeAll
    public static void setup() {
        // Create the Spring container
        context = new AnnotationConfigApplicationContext(ArithmeticPresentationLayer.class);

        // Retrieve the RoryApplication bean from the container
        app = context.getBean(ArithmeticPresentationLayer.class);
    }

    @AfterAll
    public static void tearDown() {
        // Close the Spring context to avoid resource leaks
        if (context != null) {
            ((AnnotationConfigApplicationContext) context).close();
        }
    }

    @Test
    public void testAddConvertToStringPositives() {
        String actual = app.addConvertToString(3, 4);
        Assertions.assertEquals("The result of 3.0 + 4.0 is 7.0", actual);
    }

    @Test
    public void testAddConvertToStringNegatives() {
        String actual = app.addConvertToString(-3, -4);
        Assertions.assertEquals("The result of -3.0 + -4.0 is -7.0", actual);
    }

    @Test
    public void testAddConvertToStringPositiveNegative() {
        String actual = app.addConvertToString(3, -4);
        Assertions.assertEquals("The result of 3.0 + -4.0 is -1.0", actual);
    }

    @Test
    public void testMultiplyConvertToStringPositives() {
        String actual = app.multiplyConvertToString(5, 7);
        Assertions.assertEquals("The result of 5.0 * 7.0 is 35.0", actual);
    }

    @Test
    public void testMultiplyConvertToStringNegatives() {
        String actual = app.multiplyConvertToString(-5, -7);
        Assertions.assertEquals("The result of -5.0 * -7.0 is 35.0", actual);
    }

    @Test
    public void testMultiplyConvertToStringPositiveNegative() {
        String actual = app.multiplyConvertToString(5, -7);
        Assertions.assertEquals("The result of 5.0 * -7.0 is -35.0", actual);
    }

    @Test
    public void testSquareConvertToStringPositive() {
        String actual = app.squareConvertToString(6);
        Assertions.assertEquals("The result of 6.0 squared is 36.0", actual);
    }

    @Test
    public void testSquareConvertToStringNegative() {
        String actual = app.squareConvertToString(-6);
        Assertions.assertEquals("The result of -6.0 squared is 36.0", actual);
    }
}