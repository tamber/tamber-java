package com.tamber.net;

import com.tamber.exception.TamberException;

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

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.json.simple.JSONValue;

public class Comms{

    private enum Method {
        GET, POST, PUT, DELETE
    }

	public static JSONObject Get(Client client, String object, String method, List<NameValuePair> params) throws TamberException {
        return _request(client, Method.GET, object +"/"+method, params);
    }

    public static JSONObject Post(Client client, String object, String method, List<NameValuePair> params) throws TamberException {
        return _request(client, Method.POST, object +"/"+method, params);
    }

    private static JSONObject _request(Client client, Method method, String url, List<NameValuePair> params) throws TamberException {
        HttpRequestBase req;
        switch (method) {
            case GET:
                req = new HttpGet();
                break;
            case POST:
                req = new HttpPost();
                break;
            default:
                throw new IllegalArgumentException("Method " + method + " is not supported");
        }
        if(client.apiVersion.length() > 0){
            req.setHeader("Tamber-Version", client.apiVersion);
        }
		req.setHeader("User-Agent", "Tamber/v1 JavaBindings/"+client.clientVersion);
		req.setHeader("Content-Type", "application/x-www-form-urlencoded");
        String auth = new String(Base64.encodeBase64((client.projectKey+":"+client.engineKey).getBytes()));  
		req.addHeader("Authorization", "Basic " +auth);


        if (method == Method.GET){
            url = url + "?";
            String body = URLEncodedUtils.format(params, "UTF-8");
            url += body;
        } else {
            try{
                ((HttpPost)req).setEntity(new UrlEncodedFormEntity(params));
            } catch(UnsupportedEncodingException e){
                throw new IllegalStateException(e);
            }
            
        }

        try {
            req.setURI(new URI(client.apiUrl + "/" + url));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }

        req.setConfig(client.reqConfig);

        HttpResponse response;

        try {
            response = client.httpClient.execute(req);
        } catch (IOException e) {
            throw new TamberException(String.format("%s=%s - cause: %s", e.getClass().getName(), e.getMessage(), e.getCause().toString()));
        }
        try {
            if (response.getEntity().getContentLength() == 0){
                throw new TamberException("Empty server response received.");
            }
            StringBuilder jsonRaw = new StringBuilder();
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()), 65728);
                String line = null;

                while ((line = reader.readLine()) != null) {
                    jsonRaw.append(line);
                }
            } catch (IOException e) {
                new TamberException("Response read error: " + e.getCause()); 
            }
            JSONObject jsonResp = new JSONObject(jsonRaw.toString());
            if (!jsonResp.getBoolean("success")){
                 throw new TamberException("Tamber API error:" + jsonResp.getString("error"));
            }
            return new JSONObject(jsonRaw.toString());
        } catch (JSONException e) {
            throw new TamberException("JSON decode error:" + e.getMessage());
        } finally{
            req.releaseConnection();
        }
    } 
}