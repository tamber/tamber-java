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

public class DiscoverTest {
    public static boolean recommended(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("user", "user_jctzgisbru");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.discover.recommended(params);
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

    public static boolean similar(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("item", "item_i5gq90scc1");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.discover.similar(params);
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

    public static boolean recommendedSimilar(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("user", "user_jctzgisbru");
        params.put("item", "item_i5gq90scc1");

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.discover.recommendedSimilar(params);
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

    public static boolean popular(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.discover.popular(params);
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

    public static boolean hot(Tamber tamber) {
        HashMap<String,Object> params = new HashMap<String,Object>();

        JSONObject resp = new JSONObject();
        try {
            resp = tamber.discover.hot(params);
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
