package com.tamber.object;

import com.tamber.net.Comms;
import com.tamber.net.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Actor{
	public Actor() {
	}
	private static final String object = "actor";
	private Engine engine;

	private class ActorBehavior{
		public String behavior; //required
		public String item; //required
		public double value; //required
		public int created; //optional

		public ActorBehavior(String behavior, String item, double value){
			this(behavior, item, value, 0);
		}

		public ActorBehavior(String b, String i, double v, int c){
			behavior = b;
			item = i;
			value = v;
			created = c;
		}
	}

	public Actor(Engine e) {
		engine = e;
	}

	public JSONObject Create(Map<String,Object> params){
		for (String key : params.keySet()) {
		    switch(key){
		    	case "behaviors":
		    	case "getRecs":
		    		params.put(key, JSONValue.toJSONString(params.get(key)));
		    		break;
		    }
		}
		return Comms.Post(engine, object, "create", params);
	}

	public AddBehaviors(Map<String,Object> params){

	}
	public RemoveBehaviors(Map<String,Object> params){
		
	}
	public Retrieve(Map<String,Object> params){
		
	}
	public Remove(Map<String,Object> params){
		
	}
}