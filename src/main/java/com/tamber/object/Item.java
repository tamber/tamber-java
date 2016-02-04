package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Engine;
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

public class Item{

	private static final String object = "item";
	private Engine engine;

	public Item(Engine e) {
		engine = e;
	}

	private List<NameValuePair> _getBody(HashMap<String,Object> params) throws TamberException{
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			if (key == "id"){
				out.add(new BasicNameValuePair(key, (String)params.get(key)));
			} else if (key == "updates" || key == "properties" || key == "tags"){
				out.add(new BasicNameValuePair(key, JSONValue.toJSONString(params.get(key))));
			} else if (key=="created"){
				if(params.get(key).getClass().equals(Integer.class)){
					out.add(new BasicNameValuePair(key, Integer.toString((Integer)params.get(key))));
				} else {
					throw new TamberException(String.format("Created field in Item params must be an Integer. %s provided.", params.get(key).getClass()));
				}
			}
		}
		return out;
	}

	public JSONObject create(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(engine, object, "create", _getBody(params));
	}
	public JSONObject update(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(engine, object, "update", _getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(engine, object, "retrieve", _getBody(params));
	}
	public JSONObject remove(HashMap<String,Object> params) throws TamberException{
		return Comms.Post(engine, object, "remove", _getBody(params));
	}

}