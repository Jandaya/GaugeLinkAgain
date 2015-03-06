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
 * @author Joseph
 */
public class isVtecTest {
    @Test
    public void testisVtec() {
        System.out.println("Testing isVtec function...");
        
        gaugeForm gTest = new gaugeForm();
        int x, expResult, result;
        //testing vtec function is active
        x = 6000;
        expResult = 6100;
        result = gTest.isVtec(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
        
        //testing vtec function on edge case
        x = 5000;
        expResult = 5000;
        result = gTest.isVtec(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
        
        //testing vtec function is non-active
        x = 4000;
        expResult = 4000;
        result = gTest.isVtec(x);
        assertEquals(expResult, result);
        System.out.println("Input was sent as: " + x + " and expected value is: " + expResult);
    }
}
