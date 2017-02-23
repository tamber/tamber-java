package com.tamber.net;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.config.RequestConfig;

public class Client{
	public String projectKey;
	public String engineKey;
	public String apiVersion;
	public String clientVersion;
	public String apiUrl;
	public HttpClient httpClient;
	public RequestConfig reqConfig;
	public int httpSocketTimeoutMS = 30000;
    public int httpConnectTimeoutMS = 80000;

	public Client(String url, String pkey, String ekey, String apiv, String clientv, HttpClient client, int socketTimeout, int connectTimeout){
		apiUrl = url;
		projectKey = pkey;
		engineKey = ekey;
		apiVersion = apiv;
		clientVersion = clientv;
		httpClient = client;
		httpSocketTimeoutMS = socketTimeout;
		httpConnectTimeoutMS = connectTimeout;
		reqConfig = RequestConfig.custom()
                .setSocketTimeout(httpSocketTimeoutMS)
                .setConnectTimeout(httpConnectTimeoutMS)
                .setConnectionRequestTimeout(httpConnectTimeoutMS)
                .build();
	}
}