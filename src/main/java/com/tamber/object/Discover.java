package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.exception.TamberException;

import java.util.Map;

import org.json.JSONObject;

public class Discover extends TamberObject {
	private static final String object = "discover";
	private Client client;

	public Discover(Client c) {
		client = c;
	}

	public JSONObject recommended(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "recommended", _getBody(params));
	}
	public JSONObject similar(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "similar", _getBody(params));
	}
	public JSONObject recommendedSimilar(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "recommended_similar", _getBody(params));
	}
	public JSONObject next(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "next", _getBody(params));
	}
	public JSONObject popular(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "popular", _getBody(params));
	}
	public JSONObject hot(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "hot", _getBody(params));
	}
}