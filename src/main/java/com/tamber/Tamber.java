package com.tamber;

import com.tamber.net.Comms;
import com.tamber.net.Client;

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

public class Tamber {
	public static final String API_URL = "https://api.tamber.com/v1";
	public static String CLIENT_VERSION = "0.1.2";
	private int httpSocketTimeoutMS = 30000;
    private int httpConnectTimeoutMS = 80000;

	private static Client client;

	public final Event event;
	public final Discover discover;
	public final User user;
	public final Item item;
	public final Behavior behavior;
	

	public Tamber(String projectKey, String engineKey) {
		HttpClient httpClient = HttpClientBuilder.create().disableAutomaticRetries().useSystemProperties().build();
		client = new Client(API_URL, projectKey, engineKey, "", CLIENT_VERSION, httpClient, httpSocketTimeoutMS, httpConnectTimeoutMS);
		event = new Event(client);
		discover = new Discover(client);
		user = new User(client);
		item = new Item(client);
		behavior = new Behavior(client);
	}

	public void setApiVersion(String apiVersion) {
		this.client.setApiVersion(apiVersion);
	}

	public void setTimeout(int connectTimeout, int readTimeout) {
		this.httpSocketTimeoutMS = readTimeout;
		this.httpConnectTimeoutMS = connectTimeout;
		if (client != null) {
			this.client.httpSocketTimeoutMS = readTimeout;
        	this.client.httpConnectTimeoutMS = connectTimeout;
		}
    }
}
