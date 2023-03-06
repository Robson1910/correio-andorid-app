package io.github.robson.correioandroid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.res.Resources;

import androidx.test.core.app.ApplicationProvider;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {

    public static final String STRING_INITIAL= "Hello Word";

    @Test
    public void addition_isCorrectTitle() {

        assertEquals(STRING_INITIAL, "Hello Word");
    }
}