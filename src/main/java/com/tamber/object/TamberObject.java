package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Client;
import com.tamber.exception.TamberException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.List;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.JSONValue;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class TamberObject {
	protected List<NameValuePair> _getBody(Map<String, Object> params) throws TamberException {
		List<NameValuePair> out = new ArrayList<NameValuePair>();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value == null) {
				continue;
			}
			if (value instanceof String) {
				out.add(new BasicNameValuePair(key, (String) value));
			} else {
				out.add(new BasicNameValuePair(key, JSONValue.toJSONString(value)));
			}
		}
		return out;
	}
}