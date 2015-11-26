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


public class ItemTest{

    public static boolean create(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "JJJJ");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.create(params);
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

     public static boolean addProperties(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "HZNP");

        HashMap<String,Object> properties = new HashMap<String,Object>();
        properties.put("length", 5.0);
        params.put("properties", properties);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.addProperties(params);
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
     public static boolean removeProperties(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "HZNP");

        HashMap<String,Object> properties = new HashMap<String,Object>();
        properties.put("length", "");
        params.put("properties", properties);


        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.removeProperties(params);
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
     public static boolean addTags(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "HZNP");

        List<String> tags = new ArrayList<String>();
        tags.add("sweet");
        tags.add("amazing");
        params.put("tags", tags);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.addTags(params);
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
     public static boolean removeTags(Tamber tamber){
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "HZNP");

        List<String> tags = new ArrayList<String>();
        tags.add("sweet");
        tags.add("amazing");
        params.put("tags", tags);

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.removeTags(params);
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
        params.put("id", "JJJJ");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.retrieve(params);
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
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "JJJJ");

        JSONObject resp = new JSONObject();
        try{
            resp = tamber.item.remove(params);
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
