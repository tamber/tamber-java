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


public class PropertyTest{

    public static boolean create(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("name", "video_duration");
        params.put("type", "float");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.property.create(params);
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
        params.put("name", "video_duration");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.property.retrieve(params);
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
