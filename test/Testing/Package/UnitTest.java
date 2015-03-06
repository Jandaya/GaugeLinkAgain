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
 * @author user
 */
public class UnitTest {
    public UnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testisBoostLimit() {
        System.out.println("isBoostLimit");
        int x = 30;
        gaugeForm instance = new gaugeForm();
        int expResult = 20;
        int result = instance.isBoostLimit(x);
        assertEquals(expResult, result);
    }
}
