/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kylevirtualpet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kylefrancis
 */
public class AnimalTest {
    
    public AnimalTest() {
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
    
    /**
     * Test of isSad method, of class Animal.
     */
    @Test
    public void testIsSad() {
        System.out.println("isSad");
        Animal instance = new BlueJay();
        int expResult = 7;
        instance.isSad();
        int result = instance.getHappyMeter();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isHungry method, of class Animal.
     */
    @Test
    public void testIsHungry() {
        System.out.println("isHungry");
        Animal instance = new Shorthair();
        int expResult = 3;
        instance.isHungry();
        int result = instance.getFoodMeter();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isDirty method, of class Animal.
     */
    @Test
    public void testIsDirty() {
       System.out.println("isDirty");
        Animal instance = new Labrador();
        int expResult = 0;
        instance.isDirty();
        int result = instance.getCleanMeter();
        assertEquals(expResult, result);
    }
    
}
