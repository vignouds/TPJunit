package dev.utils;
import static org.junit.Assert.*;

import org.junit.Test;

import dev.utils.StringUtils;


/**
 * Unit test for simple App.
 */
public class StringUtilsTest
{

    @Test
    public void testLevenshteinDistance()
    {
    	try {
			 assertTrue(StringUtils.levenshteinDistance("toto", "toto") == 0);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @Test
    public void testNullLevenshteinDistance()
    {
    	assertNull(StringUtils.levenshteinDistance("toto", null));
    }
    
}
