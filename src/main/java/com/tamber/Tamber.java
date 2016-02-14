package com.tamber;

import com.tamber.net.Comms;
import com.tamber.net.Engine;

import com.tamber.object.Event;
import com.tamber.object.Discover;
import com.tamber.object.User;
import com.tamber.object.Item;
import com.tamber.object.Behavior;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Tamber{
	public static final String API_URL = "https://api.tamber.com/v1";
	public static String API_VERSION = "0.0.1";
	public static String CLIENT_VERSION = "0.0.1";
	private int httpSocketTimeoutMS = 30000;
    private int httpConnectTimeoutMS = 80000;

	private static Engine engine;

	public final Event event;
	public final Discover discover;
	public final User user;
	public final Item item;
	public final Behavior behavior;
	

	public Tamber(String apiKey) {
		HttpClient httpClient = HttpClientBuilder.create().disableAutomaticRetries().useSystemProperties().build();
		engine = new Engine(API_URL, apiKey, API_VERSION, CLIENT_VERSION, httpClient, httpSocketTimeoutMS, httpConnectTimeoutMS);
		event = new Event(engine);
		discover = new Discover(engine);
		user = new User(engine);
		item = new Item(engine);
		behavior = new Behavior(engine);
	}

	public void setTimeout(int connectTimeout, int readTimeout) {
		this.httpSocketTimeoutMS = readTimeout;
		this.httpConnectTimeoutMS = connectTimeout;
		if(engine != null){
			this.engine.httpSocketTimeoutMS = readTimeout;
        	this.engine.httpConnectTimeoutMS = connectTimeout;
		}
    }
}
