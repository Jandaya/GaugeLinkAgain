/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;
import gl.*;
import org.junit.*;
import static org.junit.Assert.*;
/**
 *
 * @author Jared Weiler
 */
public class isRevLimitTest {
    @Test
    public void testRevLimit() {
        //test function has begun
        System.out.println("Testing the isRevLimit function...");
        
        //create a new gaugeform that we will test on
        gaugeForm testgf = new gaugeForm();
        
        //we will use these variable for testing
        //our input
        int x;
        //our expected result
        int expectedResult;
        //the result we recieved from the input
        int actualResult;
        
        
        //testing a typical middle value
        x = 1294;
        expectedResult = 1294;
        actualResult = testgf.isRevLimit(x);
        assertEquals(expectedResult, actualResult);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expectedResult);
        
        //testing an edge case
        x = 9100;
        expectedResult = 9100;
        actualResult = testgf.isRevLimit(x);
        assertEquals(expectedResult, actualResult);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expectedResult);
        
        //testing another edge case
        x = 0;
        expectedResult = 0;
        actualResult = testgf.isRevLimit(x);
        assertEquals(expectedResult, actualResult);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expectedResult);
        
        //testing unexpected data
        x = -8276;
        expectedResult = -8276;
        actualResult = testgf.isRevLimit(x);
        assertEquals(expectedResult, actualResult);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expectedResult);
        
        //testing more unexpected data
        x = 82944829;
        expectedResult = 9100;
        actualResult = testgf.isRevLimit(x);
        assertEquals(expectedResult, actualResult);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expectedResult);
    }
}
