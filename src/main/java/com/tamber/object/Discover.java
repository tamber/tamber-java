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

public class Discover extends TamberObject {
	private static final String object = "discover";
	private Client client;

	public Discover(Client c) {
		client = c;
	}

	public JSONObject recommended(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "recommended", this._getBody(params));
	}
	public JSONObject similar(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "similar", this._getBody(params));
	}
	public JSONObject recommendedSimilar(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "recommended_similar", this._getBody(params));
	}
	public JSONObject next(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "next", this._getBody(params));
	}
	public JSONObject popular(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "popular", this._getBody(params));
	}
	public JSONObject hot(HashMap<String,Object> params) throws TamberException {
		return Comms.Post(client, object, "hot", this._getBody(params));
	}

}