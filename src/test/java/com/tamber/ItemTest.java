package com.tamber;

import com.tamber.Tamber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.tamber.types.TamberItem;
import com.tamber.exception.TamberException;
import org.json.JSONObject;
import org.json.JSONException;

public class ItemTest {
	public static boolean create(Tamber tamber) {
		TamberItem item = new TamberItem();
		item.id = "item_faa666arma";

		item.properties = new HashMap<String,Object>();
		item.properties.put("clothing_type","pants");
		item.properties.put("stock", 90);
		item.properties.put("available_medium",true);
		item.properties.put("available_large",true);

		item.tags = new ArrayList<String>();
		item.tags.add("casual");
		item.tags.add("feminine");

		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.create(item);
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}

	public static boolean update(Tamber tamber) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("id", "item_faa666arma");

		HashMap<String,Object> updates = new HashMap<String,Object>();

		HashMap<String,Object> add = new HashMap<String,Object>();
		HashMap<String,Object> addProperties = new HashMap<String,Object>();
		addProperties.put("available_large",false);
		addProperties.put("stock",89);
		add.put("properties", addProperties);
		updates.put("add", add);

		HashMap<String,Object> remove = new HashMap<String,Object>();
		List<String> removeTags = new ArrayList<String>();
		removeTags.add("casual");
		remove.put("tags", removeTags);
		updates.put("remove", remove);

		params.put("updates", updates);

		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.update(params);
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}

	public static boolean retrieve(Tamber tamber) {
		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.retrieve("item_faa666arma");
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}

	public static boolean hide(Tamber tamber) {
		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.hide("item_faa666arma");
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}

	public static boolean unhide(Tamber tamber) {
		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.unhide("item_faa666arma");
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}

	public static boolean delete(Tamber tamber) {
		HashMap<String,Object> params = new HashMap<String,Object>();

		JSONObject resp = new JSONObject();
		try {
			resp = tamber.item.delete("item_faa666arma");
		} catch (TamberException e) {
			System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
			return false;
		}
		if (resp != null) {
			try {
				System.out.println(resp.toString(4));
				return true;
			} catch (JSONException e) {
				System.out.println(String.format("%s=%s", e.getClass().getName(), e.getMessage()));
				return false;
			}
		} else {
			System.out.println("resp did not return");
			return false;
		}
	}
}
