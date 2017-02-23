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

public class Discover{

	private static final String object = "discover";
	private Client client;

	public Discover(Client c) {
		client = c;
	}
	
	private List<NameValuePair> _getBody(HashMap<String,Object> params) throws TamberException{
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			if (key == "user" || key == "item"){
				out.add(new BasicNameValuePair(key, (String)params.get(key)));
			} else if (key=="number" || key=="page"){
				if(params.get(key).getClass().equals(Integer.class)){
					out.add(new BasicNameValuePair(key, Integer.toString((Integer)params.get(key))));
				} else {
					throw new TamberException(String.format("%s field in Discover params must be an Integer. %s provided.", key, params.get(key).getClass()));
				}
			} else if (key=="filter" || key =="test_events"){
				out.add(new BasicNameValuePair(key, JSONValue.toJSONString(params.get(key))));
			}
		}
		return out;
	}

	public JSONObject recommended(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "recommended", _getBody(params));
	}
	public JSONObject similar(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "similar", _getBody(params));
	}
	public JSONObject recommendedSimilar(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "recommended_similar", _getBody(params));
	}
	public JSONObject popular(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "popular", _getBody(params));
	}
	public JSONObject hot(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "hot", _getBody(params));
	}

}