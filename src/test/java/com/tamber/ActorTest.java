package com.tamber;

import com.tamber.Tamber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.tamber.exception.TamberException;
import org.json.JSONObject;
import org.json.JSONException;


public class ActorTest{

    public static boolean create(Tamber tamber){
        HashMap<String,Object> actorParams = new HashMap<String,Object>();
        actorParams.put("id", "2197054087");

        List<HashMap<String,Object>> behaviors = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> b1 = new HashMap<String,Object>();
        b1.put("behavior", "like");
        b1.put("item", "HZNP");
        b1.put("value", 1.0);
        b1.put("created", 1446417346);
        behaviors.add(b1);
        actorParams.put("behaviors", behaviors);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.actor.create(actorParams);
        } catch(TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if(resp!= null){
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e){
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }
    public static boolean addBehaviors(Tamber tamber){
        HashMap<String,Object> actorParams = new HashMap<String,Object>();
        actorParams.put("id", "2197054087");

        List<HashMap<String,Object>> behaviors = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> b1 = new HashMap<String,Object>();
        b1.put("behavior", "like");
        b1.put("item", "HZNP");
        b1.put("value", 1.0);
        b1.put("created", 1446417366);
        behaviors.add(b1);
        actorParams.put("behaviors", behaviors);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.actor.addBehaviors(actorParams);
        } catch(TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if(resp!= null){
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e){
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }

    public static boolean retrieve(Tamber tamber){
        HashMap<String,Object> actorParams = new HashMap<String,Object>();
        actorParams.put("id", "2197054087");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.actor.retrieve(actorParams);
        } catch(TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if(resp!= null){
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e){
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }
    public static boolean remove(Tamber tamber){
        
        HashMap<String,Object> actorParams = new HashMap<String,Object>();
        actorParams.put("id", "2197054087");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.actor.remove(actorParams);
        } catch(TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if(resp!= null){
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e){
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }
}
