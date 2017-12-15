package com.tamber;

import com.tamber.Tamber;

import com.tamber.EventTest;
import com.tamber.DiscoverTest;
import com.tamber.UserTest;
import com.tamber.ItemTest;
import com.tamber.BehaviorTest;

import java.util.HashMap;
import java.util.Map;
import com.tamber.exception.TamberException;
import org.json.JSONObject;
import org.json.JSONException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TamberTest extends TestCase {
    private static Tamber tamber;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TamberTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TamberTest.class);
    }

    public void testApp() {
        initTamber();
        runEventTests();
        runUserTests();
        runItemTests();
        runBehaviorTests();
        runDiscoverTests();        
    }

    public static void initTamber() {
        tamber = new Tamber("Mu6DUPXdDYe98cv5JIfX", "SbWYPBNdARfIDa0IIO9L");
    }

    public void runEventTests() {
        assertTrue(EventTest.track(tamber));
        assertTrue(EventTest.retrieve(tamber));
        assertTrue(EventTest.batch(tamber));
    }

    public void runUserTests() {
        assertTrue(UserTest.create(tamber));
        assertTrue(UserTest.update(tamber));
        assertTrue(UserTest.retrieve(tamber));
    }

    public void runItemTests() {
        assertTrue(ItemTest.create(tamber));
        assertTrue(ItemTest.update(tamber));
        assertTrue(ItemTest.retrieve(tamber));
        assertTrue(ItemTest.remove(tamber));
    }

    public void runBehaviorTests() {
        assertTrue(BehaviorTest.create(tamber));
        assertTrue(BehaviorTest.retrieve(tamber));
    }

    public void runDiscoverTests() {
        assertTrue(DiscoverTest.recommended(tamber));
        assertTrue(DiscoverTest.similar(tamber));
        assertTrue(DiscoverTest.recommendedSimilar(tamber));
        assertTrue(DiscoverTest.popular(tamber));
        assertTrue(DiscoverTest.hot(tamber));
    }



}
