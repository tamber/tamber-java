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

public class Item extends TamberObject {
	private static final String object = "item";
	private Client client;

	public Item(Client c) {
		client = c;
	}

	public JSONObject create(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "create", this._getBody(params));
	}
	public JSONObject update(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "update", this._getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", this._getBody(params));
	}
	public JSONObject remove(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "remove", this._getBody(params));
	}

}