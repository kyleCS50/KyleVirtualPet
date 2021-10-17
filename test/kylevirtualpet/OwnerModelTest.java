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
public class OwnerModelTest {
    
    public OwnerModelTest() {
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
     * Test of play method, of class OwnerModel.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        OwnerModel instance = new OwnerModel("test", "test");
        Animal a = new Labrador();
        instance.setMyPet(a);
        int expResult = 6;
        instance.play();
        int result = a.getHappyMeter();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of feed method, of class OwnerModel.
     */
    @Test
    public void testFeed() {
        System.out.println("feed");
        OwnerModel instance = new OwnerModel("test", "test");
        Animal a = new BlueJay();
        instance.setMyPet(a);
        int expResult = 11;
        instance.feed();
        int result = a.getFoodMeter();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of clean method, of class OwnerModel.
     */
    @Test
    public void testClean() {
        System.out.println("clean");
        OwnerModel instance = new OwnerModel("test", "test");
        Animal a = new Shorthair();
        instance.setMyPet(a);
        int expResult = 8;
        instance.clean();
        int result = a.getCleanMeter();
        assertEquals(expResult, result);
    }
    
}
