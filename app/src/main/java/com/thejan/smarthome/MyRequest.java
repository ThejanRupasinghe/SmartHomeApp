package com.thejan.smarthome;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by thejan on 7/8/17.
 */

public class MyRequest {
    public static String myResponse;

    public String HttpRequest(RequestQueue queue,String url){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        myResponse=response;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        myResponse=null;
                    }
                }
        );

        queue.add(stringRequest);
        return myResponse;
    }
}
