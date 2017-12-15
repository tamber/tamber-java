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


public class UserTest {
    public static boolean create(Tamber tamber) {
        //Set id
        HashMap<String,Object> userParams = new HashMap<String,Object>();
        userParams.put("id", "user_fwu592pwmo");
        //Set metadata
        HashMap<String,Object> metadata = new HashMap<String,Object>();
        metadata.put("city", "San Francisco, CA");
        metadata.put("name", "Rob Pike");
        userParams.put("metadata", metadata);
        //Set events
        List<HashMap<String,Object>> events = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> event = new HashMap<String,Object>();
        event.put("behavior", "mention");
        event.put("item", "item_u9nlytt3w5");
        event.put("value", 1.0);
        event.put("created", 1446417346);
        events.add(event);
        userParams.put("events", events);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.user.create(userParams);
        } catch (TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp != null) {
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
    
    public static boolean update(Tamber tamber) {
        HashMap<String,Object> userParams = new HashMap<String,Object>();
        userParams.put("id", "user_fwu592pwmo");
        //Set metadata
        HashMap<String,Object> metadata = new HashMap<String,Object>();
        metadata.put("city", "Mountain View, CA");
        metadata.put("age", "55-65");
        metadata.put("name", "Rob Pike");
        userParams.put("metadata", metadata);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.user.update(userParams);
        } catch (TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp != null) {
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
        HashMap<String,Object> userParams = new HashMap<String,Object>();
        userParams.put("id", "user_fwu592pwmo");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.user.retrieve(userParams);
        } catch (TamberException e) {
            System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
            return false;
        }
        if (resp != null) {
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
