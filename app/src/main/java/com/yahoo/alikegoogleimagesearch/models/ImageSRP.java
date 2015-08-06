package com.yahoo.alikegoogleimagesearch.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by aliku on 2015/8/6.
 */
public class ImageSRP implements Serializable {
    public String fullUrl;
    public String thumbUrl;
    public String title;

    public ImageSRP(JSONObject json) {
        try {
            this.fullUrl = json.getString("url");
            this.thumbUrl = json.getString("tbUrl");
            this.title = json.getString("title");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ImageSRP> fromJSONArray(JSONArray array) {
        ArrayList<ImageSRP> results = new ArrayList<ImageSRP>();
        for (int i = 0; i < array.length(); i++) {
            try {
                results.add(new ImageSRP(array.getJSONObject(i)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }
}
