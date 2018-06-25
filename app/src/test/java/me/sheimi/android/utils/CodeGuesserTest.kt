package me.sheimi.android.utils

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 *
 */
class CodeGuesserTest {

    @Test
    fun testGuessCodeType() {
        assertEquals("expect to recognise java files", "text/x-java", CodeGuesser.guessCodeType("test.java"))
    }
}
