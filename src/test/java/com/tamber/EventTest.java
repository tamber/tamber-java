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
    public static boolean track(Tamber tamber) {
        //Create Event
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("user", "user_jctzgisbru");
        eventParams.put("item", "item_i5gq90scc1");
        eventParams.put("behavior", "mention");
        eventParams.put("get_recs", new HashMap<String,Object>());

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.event.track(eventParams);
        } catch (TamberException e) {
            System.out.println(String.format("TamberException: %s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp!= null) {
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e) {
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }
    
    public static boolean retrieve(Tamber tamber) {
        HashMap<String,Object> eventParams = new HashMap<String,Object>();
        eventParams.put("created_before", 1454465400);
        eventParams.put("created_since", 708652800);
        eventParams.put("number", 300);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.event.retrieve(eventParams);
        } catch (TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp!= null) {
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e) {
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }

    public static boolean batch(Tamber tamber) {
        HashMap<String,Object> eventParams = new HashMap<String,Object>();

        List<HashMap<String,Object>> events = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> e1 = new HashMap<String,Object>();
        e1.put("user", "user_jctzgisbru");
        e1.put("behavior", "mention");
        e1.put("item", "item_u9nlytt3w5");
        e1.put("value", 1.0);
        e1.put("created", 1454465800);
        events.add(e1);
        HashMap<String,Object> e2 = new HashMap<String,Object>();
        e2.put("user", "user_y7u9sv6we0");
        e2.put("behavior", "mention");
        e2.put("item", "item_u9nlytt3w5");
        e2.put("value", 1.0);
        e2.put("created", 1454465400);
        events.add(e2);
        HashMap<String,Object> e3 = new HashMap<String,Object>();
        e3.put("user", "user_jctzgisbru");
        e3.put("behavior", "mention");
        e3.put("item", "item_d1zevdf6hl");
        e3.put("value", 1.0);
        e3.put("created", 1408652800);
        events.add(e3);

        eventParams.put("events", events);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.event.batch(eventParams);
        } catch (TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp!= null) {
            try {
                System.out.println(resp.toString(4));
                return true;
            } catch (JSONException e) {
                System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
                return false;
            }
        } else {
            System.out.println("resp did not return");
            return false;
        }
    }
}
