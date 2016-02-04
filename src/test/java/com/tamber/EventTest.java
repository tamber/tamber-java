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


public class EventTest{

    public static boolean track(Tamber tamber){
        //Create Event
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("user", "user_rlox8k927z7p");
        eventParams.put("item", "item_wmt4fn6o4zlk");
        eventParams.put("behavior", "like");
        eventParams.put("getRecs", new HashMap<String,Object>());

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.event.track(eventParams);
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
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("created_before", 1454465400);
        eventParams.put("created_since", 708652800);
        eventParams.put("number", 300);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.event.retrieve(eventParams);
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

    public static boolean batch(Tamber tamber){
        HashMap<String,Object> eventParams = new HashMap<String,Object>();

        List<HashMap<String,Object>> events = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> e1 = new HashMap<String,Object>();
        e1.put("user", "user_rlox8k927z7p");
        e1.put("behavior", "like");
        e1.put("item", "item_83jx4c57r2ru");
        e1.put("value", 1.0);
        e1.put("created", 1454465800);
        events.add(e1);
        HashMap<String,Object> e2 = new HashMap<String,Object>();
        e2.put("user", "user_ujkksokcwr1k");
        e2.put("behavior", "like");
        e2.put("item", "item_wmt4fn6o4zlk");
        e2.put("value", 1.0);
        e2.put("created", 1454465400);
        events.add(e2);
        HashMap<String,Object> e3 = new HashMap<String,Object>();
        e3.put("user", "user_rlox8k927z7p");
        e3.put("behavior", "like");
        e3.put("item", "item_83jx4c57r2ru");
        e3.put("value", 1.0);
        e3.put("created", 1408652800);
        events.add(e3);

        eventParams.put("events", events);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.event.batch(eventParams);
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
