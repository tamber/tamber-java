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

public class Event extends TamberObject {
	private static final String object = "event";
	private Client client;

	public Event(Client c) {
		client = c;
	}

	public JSONObject track(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "track", this._getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", this._getBody(params));
	}
	public JSONObject batch(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "batch", this._getBody(params));
	}
}