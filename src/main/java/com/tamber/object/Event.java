package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.types.TamberEvent;
import com.tamber.types.TamberGetRecs;
import com.tamber.exception.TamberException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Event extends TamberObject {
	private static final String object = "event";
	private Client client;

	public Event(Client c) {
		client = c;
	}

	public JSONObject track(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "track", _getBody(params));
	}
	public JSONObject track(TamberEvent event, TamberGetRecs get_recs) throws TamberException {
		Map<String, Object> params = event.toMap();
		params.put("get_recs", get_recs);
		return track(params);
	}
	public JSONObject retrieve(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "retrieve", _getBody(params));
	}
	public JSONObject batch(Map<String, Object> params) throws TamberException {
		return Comms.Post(client, object, "batch", _getBody(params));
	}
	public JSONObject batch(List<TamberEvent> events) throws TamberException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("events", events);
		return batch(params);
	}
}