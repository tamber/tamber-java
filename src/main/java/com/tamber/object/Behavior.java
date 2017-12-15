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

public class Behavior extends TamberObject {
	private static final String object = "behavior";
	private Client client;

	public Behavior(Client c) {
		client = c;
	}

	public JSONObject create(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "create", _getBody(params));
	}
	public JSONObject retrieve(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}

}