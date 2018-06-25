package me.sheimi.android.utils;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class CodeGuesserTest {

    @org.junit.Test
    public void testGuessCodeType() {
        assertEquals("expect to recognise java files", "text/x-java", CodeGuesser.guessCodeType("test.java"));
    }
}
