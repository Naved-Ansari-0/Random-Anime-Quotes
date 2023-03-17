package com.example.animequotes;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnimeQuotesService {

    public Context context;
    public interface VolleyResponseListener{
        void OnError(String message);
        void OnResponse(List<Quote> quotes);
    }

    public AnimeQuotesService(Context context){
        this.context = context;
    }

    public void getQuotes(VolleyResponseListener volleyResponseListener){
        String url = "https://animechan.vercel.app/api/quotes";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
//                System.out.println(response);
                List <Quote> quotes = new ArrayList<Quote>();
                try{
                    for(int i=0; i<response.length(); i++){
                        JSONObject j = (JSONObject) response.get(i);
                        String anime = j.getString("anime");
                        String character = j.getString("character");
                        String quote = j.getString("quote");
                        quotes.add(new Quote(anime, character, quote));
                    }
                    volleyResponseListener.OnResponse(quotes);
                }catch (JSONException e){
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.OnError("Something went wrong");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
    }
}
