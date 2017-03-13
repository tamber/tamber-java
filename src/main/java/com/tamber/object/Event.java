package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.exception.TamberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Event{
	private static final String object = "event";
	private Client client;

	public Event(Client c) {
		client = c;
	}

	private List<NameValuePair> _getBody(HashMap<String,Object> params) throws TamberException{
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			 System.out.println(String.format("_getBody params key: %s", key));
			if (key == "events" || key == "get_recs"){
				out.add(new BasicNameValuePair(key, JSONValue.toJSONString(params.get(key))));
			} else if (key=="created" || key=="created_before"|| key=="created_since" || key == "number"){
				if(params.get(key).getClass().equals(Integer.class)){
					out.add(new BasicNameValuePair(key, Integer.toString((Integer)params.get(key))));
				} else {
					throw new TamberException(String.format("'Created' field in user params must be an Integer. %s provided.", params.get(key).getClass()));
				}
			} else if (key == "user" || key == "item" || key == "behavior"){
				if(params.get(key).getClass().equals(String.class)){
					out.add(new BasicNameValuePair(key, (String)params.get(key)));
				} else {
					throw new TamberException(String.format("%s field in Evebt params must be a String. %s provided.", key, params.get(key).getClass()));
				}
			}
		}
		return out;
	}

	public JSONObject track(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "track", _getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}
	public JSONObject batch(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "batch", _getBody(params));
	}
}