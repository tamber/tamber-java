package com.tamber;

import com.tamber.Tamber;

import com.tamber.ActorTest;
import com.tamber.ItemTest;
import com.tamber.BehaviorTest;
import com.tamber.PropertyTest;
import com.tamber.DiscoverTest;

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
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    private static Tamber tamber;

    public void testApp()
    {
        initTamber();
        runActorTests();
        runPropertyTests();
        runItemTests();
        runBehaviorTests();
        runDiscoverTests();        
    }


    public static void initTamber(){
        tamber = new Tamber("H4y13AJ1QMlgzOqZ0sib");
    }

    public void runActorTests(){
        assertTrue( ActorTest.create(tamber) );
        assertTrue( ActorTest.addBehaviors(tamber) );
        assertTrue( ActorTest.retrieve(tamber) );
        assertTrue( ActorTest.remove(tamber) );
    }

    public void runPropertyTests(){
        assertTrue( PropertyTest.create(tamber) );
        assertTrue( PropertyTest.retrieve(tamber) );
        assertTrue( PropertyTest.remove(tamber) );
        assertTrue( PropertyTest.create(tamber) );
    }

    public void runItemTests(){
        assertTrue( ItemTest.create(tamber) );
        assertTrue( ItemTest.addProperties(tamber) );
        assertTrue( ItemTest.removeProperties(tamber) );
        assertTrue( ItemTest.addTags(tamber) );
        assertTrue( ItemTest.removeTags(tamber) );
        assertTrue( ItemTest.retrieve(tamber) );
        assertTrue( ItemTest.remove(tamber) );
    }

    public void runBehaviorTests(){
        assertTrue( BehaviorTest.create(tamber) );
        assertTrue( BehaviorTest.retrieve(tamber) );
        assertTrue( BehaviorTest.remove(tamber) );
    }

    public void runDiscoverTests(){
        assertTrue( DiscoverTest.recommended(tamber) );
        assertTrue( DiscoverTest.similar(tamber) );
        assertTrue( DiscoverTest.recommendedSimilar(tamber) );
        assertTrue( DiscoverTest.popular(tamber) );
        assertTrue( DiscoverTest.hot(tamber) );
    }



}
