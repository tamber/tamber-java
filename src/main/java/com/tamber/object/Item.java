package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.types.TamberItem;
import com.tamber.exception.TamberException;

import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Item extends TamberObject {
	private static final String object = "item";
	private Client client;

	public Item(Client c) {
		client = c;
	}

	public JSONObject create(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "create", _getBody(params));
	}
	public JSONObject create(TamberItem item) throws TamberException {
		return create(item.toMap());
	}
	public JSONObject update(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "update", _getBody(params));
	}
	public JSONObject retrieve(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}
	public JSONObject retrieve(String id) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return retrieve(params);
	}
	public JSONObject hide(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "hide", _getBody(params));
	}
	public JSONObject hide(String id) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return hide(params);
	}
	public JSONObject unhide(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "unhide", _getBody(params));
	}
	public JSONObject unhide(String id) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return unhide(params);
	}
	public JSONObject delete(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "delete", _getBody(params));
	}
	public JSONObject delete(String id) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		return delete(params);
	}
}