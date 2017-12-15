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

public class ItemTest {
    public static boolean create(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "item_faa666arma");

        HashMap<String,Object> properties = new HashMap<String,Object>();
        properties.put("clothing_type","pants");
        properties.put("stock", 90);
        properties.put("available_medium",true);
        properties.put("available_large",true);
        params.put("properties", properties);

        List<String> tags = new ArrayList<String>();
        tags.add("casual");
        tags.add("feminine");
        params.put("tags", tags);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.item.create(params);
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
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "item_faa666arma");

        HashMap<String,Object> updates = new HashMap<String,Object>();

        HashMap<String,Object> add = new HashMap<String,Object>();
        HashMap<String,Object> addProperties = new HashMap<String,Object>();
        addProperties.put("available_large",false);
        addProperties.put("stock",89);
        add.put("properties", addProperties);
        updates.put("add", add);

        HashMap<String,Object> remove = new HashMap<String,Object>();
        List<String> removeTags = new ArrayList<String>();
        removeTags.add("casual");
        remove.put("tags", removeTags);
        updates.put("remove", remove);

        params.put("updates", updates);

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.item.update(params);
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
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "item_faa666arma");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.item.retrieve(params);
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

    public static boolean remove(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("id", "item_faa666arma");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.item.remove(params);
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
