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


public class BehaviorTest{

    public static boolean create(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("name", "share");
        params.put("desirability",0.3);
        params.put("type", "exponential");
        
        HashMap<String,Object> typeParams = new HashMap<String,Object>();
        typeParams.put("lambda", 2.0);

        params.put("params", typeParams);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.behavior.create(params);
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
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("name", "share");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.behavior.retrieve(params);
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
