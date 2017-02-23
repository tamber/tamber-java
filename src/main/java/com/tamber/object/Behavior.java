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

public class Behavior{

	private static final String object = "behavior";
	private Client client;

	public Behavior(Client c) {
		client = c;
	}

	private List<NameValuePair> _getBody(HashMap<String,Object> params) throws TamberException{
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			if (key == "name" || key=="type"){
				out.add(new BasicNameValuePair(key, (String)params.get(key)));
			} else if (key == "params"){
				out.add(new BasicNameValuePair(key, JSONValue.toJSONString(params.get(key))));
			} else if (key=="desirability"){
				if(params.get(key).getClass().equals(Double.class)){
					out.add(new BasicNameValuePair(key, Double.toString((Double)params.get(key))));
				} else {
					throw new TamberException(String.format("Desirability field in Behavior params must be a Float. %s provided.", params.get(key).getClass()));
				}
			}
		}
		return out;
	}

	public JSONObject create(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "create", _getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}

}