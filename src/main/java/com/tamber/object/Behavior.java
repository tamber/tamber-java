package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.exception.TamberException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.json.JSONObject;

public class Behavior extends TamberObject {
	private static final String object = "behavior";
	private Client client;

	public Behavior(Client c) {
		client = c;
	}

	public JSONObject create(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "create", _getBody(params));
	}
	public JSONObject retrieve(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}
	public JSONObject retrieve(String name) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return retrieve(params);
	}
}