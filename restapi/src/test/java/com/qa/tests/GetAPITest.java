package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class GetAPITest extends TestBase {

    TestBase testBase;
    String serviceUrl;
    String apiUrl;
    String url;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setUp() throws IOException {
        testBase = new TestBase();
        serviceUrl = prop.getProperty("URL");
        apiUrl = prop.getProperty("serviceURL");
        url = serviceUrl + apiUrl;
    }

    @Test(priority=1)
    public void getAPITest() throws IOException {
        RestClient restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);
        //Status Code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code ---> " + statusCode);

        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        //JSOn string
        JSONObject responseJsonObject = new JSONObject(responseString);
        System.out.println("Response JSON from API ----> " + responseJsonObject);


        //single value assertion
        //per_page:
        String perPageValue = TestUtil.getValueByJPath(responseJsonObject, "per_page");
        System.out.println("value of per page is -->" + perPageValue);
        Assert.assertEquals(Integer.parseInt(perPageValue), 6);

        String dataArray = TestUtil.getValueByJPath(responseJsonObject, "data");
        System.out.println("data array  -->" + dataArray);
       // Assert.assertEquals(Integer.parseInt(perPageValue), 6);

        //All Headers
        Header[] headerArray = closeableHttpResponse.getAllHeaders();
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array --> " + allHeaders);

    }

    @Test(priority=2)
    public void getAPITestWithHeaders() throws IOException {
        RestClient restClient = new RestClient();
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        closeableHttpResponse = restClient.get(url, headerMap);
        //Status Code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status code ---> " + statusCode);

        Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");

        //JSOn string
        JSONObject responseJsonObject = new JSONObject(responseString);
        System.out.println("Response JSON from API ----> " + responseJsonObject);
        Header[] headerArray = closeableHttpResponse.getAllHeaders();

        //All Headers
        HashMap<String, String> allHeaders = new HashMap<String, String>();
        for (Header header : headerArray) {
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Header Array --> " + allHeaders);

    }


}
