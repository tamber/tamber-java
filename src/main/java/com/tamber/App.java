package com.tamber;

import com.tamber.Tamber;
import java.util.HashMap;
import java.util.Map;
import com.tamber.exception.TamberException;
import org.json.JSONObject;
import org.json.JSONException;

public class App 
{
	private static Tamber tamber;

    public static boolean testActorCall(){
    	tamber = new Tamber("H4y13AJ1QMlgzOqZ0sib");
    	HashMap<String,Object> actorParams = new HashMap<String,Object>();
    	actorParams.put("id", "3894");

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
}