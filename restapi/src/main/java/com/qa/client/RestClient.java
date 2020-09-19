package com.qa.client;

import org.apache.http.Header;
import org.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    //1. GET Method without Headers

    public CloseableHttpResponse get(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);//http get request
       CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpget);

       return closeableHttpResponse;
    }

    //2. GET Method with Headers

    public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);//http get request

        for(Map.Entry<String, String> entry: headerMap.entrySet() ){
            httpget.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpget);

        return closeableHttpResponse;
    }

}
