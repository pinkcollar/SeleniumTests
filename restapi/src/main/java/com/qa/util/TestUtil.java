package com.qa.util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;

public class TestUtil {
    public static String getValueByJPath(JSONObject responsejson, String jPath) {
        Object obj = responsejson;
        JSONObject jo = (JSONObject) obj;

        if (!(jPath.contains("[") || jPath.contains("]"))) {
            obj = jo.get(jPath);
        } else if (jPath.contains("[") || jPath.contains("]")) {
            JSONArray ja = (JSONArray) jo.get(jPath);
            obj = ja;

        }
        return  obj.toString();
    }


}
