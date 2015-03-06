/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calcspeedtest;
import java.math.*;

/**
 *
 * @author Konaki
 */
public class CalcSpeedTest {

    /**
     * @param args the command line arguments
     */
    public double speed;
    public void calcSpeed(int RPM, int gear) {
            speed = RPM * gear * 0.0043021;
        }
    public static void main(String[] args) {
        CalcSpeedTest car = new CalcSpeedTest();
        car.calcSpeed(9100,1);
        String testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 1st gear: " + testspeed + " mph");  //Top speed of 1st gear
        
        car.calcSpeed(9100,2);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 2nd gear: " + testspeed + " mph");  //Top speed of 2nd gear
        
        car.calcSpeed(9100,3);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 3rd gear: " + testspeed + " mph"); //Top speed of 3rd gear
        
        car.calcSpeed(9100,4);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 4th gear: " + testspeed + " mph"); //Top speed of 4th gear
        
        car.calcSpeed(9100,5);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 5th gear: " + testspeed + " mph"); //Theoretical top speed of 5th gear
        
        car.calcSpeed(9100,6);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Max speed of 6th gear: " + testspeed + " mph"); //Theoretical top speed of 6th gear
        
        car.calcSpeed(2500,6);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("Highway cruising speed: " + testspeed + " mph"); //Test speed when not at redline, under the speed limit
    
        car.calcSpeed(2100,5);
        testspeed = String.valueOf((int) Math.round(car.speed));
        System.out.println("City cruising speed: " + testspeed + " mph"); //Test speed when not at redline, under the speed limit
    }
    
}
