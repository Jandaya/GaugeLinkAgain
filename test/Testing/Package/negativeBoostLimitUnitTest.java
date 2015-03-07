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
 * @author Jonathan
 */
public class negativeBoostLimitUnitTest {
    
   
   @Test
    public void testnegativeBoostLimit() {
        System.out.println("Testing boostLimitNeg function...");
        
        gaugeForm test = new gaugeForm();
        int x, expResult, result;
        
        //testing edge out of bounds case
        x = -27;
        expResult = -25;
        result = test.isBoostLimitNeg(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
        
        //testing edge boundary case
        x = -24;
        expResult = -24;
        result = test.isBoostLimitNeg(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
        
        //testing in bounds negative case
        x = -8;
        expResult = -8;
        result = test.isBoostLimitNeg(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
        
        //testing far out of bound case
        x = -80;
        expResult = -25;
        result = test.isBoostLimitNeg(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
   
    }
}
