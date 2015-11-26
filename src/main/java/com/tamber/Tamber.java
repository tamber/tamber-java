package com.tamber;

import com.tamber.net.Comms;
import com.tamber.net.Engine;

import com.tamber.object.Actor;
import com.tamber.object.Item;
import com.tamber.object.Property;
import com.tamber.object.Behavior;
import com.tamber.object.Discover;

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
	public static final String API_URL = "https://dev.tamber.com/v1";
	public static String API_VERSION = "0.0.1";
	public static String CLIENT_VERSION = "0.0.1";
	private int httpSocketTimeoutMS = 30000;
    private int httpConnectTimeoutMS = 80000;

	private static Engine engine;

	public final Actor actor;
	public final Item item;
	public final Property property;
	public final Behavior behavior;
	public final Discover discover;

	public Tamber(String apiKey) {
		HttpClient httpClient = HttpClientBuilder.create().disableAutomaticRetries().useSystemProperties().build();
		engine = new Engine(API_URL, apiKey, API_VERSION, CLIENT_VERSION, httpClient, httpSocketTimeoutMS, httpConnectTimeoutMS);
		actor = new Actor(engine);
		item = new Item(engine);
		property = new Property(engine);
		behavior = new Behavior(engine);
		discover = new Discover(engine);
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
