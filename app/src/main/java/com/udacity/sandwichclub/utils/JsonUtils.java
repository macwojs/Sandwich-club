package com.udacity.sandwichclub.utils;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        String mainName=null;
        JSONArray nameArray;
        List<String> alsoKnownAs=new ArrayList<String>();
        String placeOfOrigin=null;
        String description=null;
        String image=null;
        JSONArray ingArray;
        List<String> ingredients=new ArrayList<String>();
        try{
            JSONObject reader = new JSONObject(json);

            JSONObject name = reader.getJSONObject("name");
            mainName = name.getString("mainName");

            nameArray = name.getJSONArray("alsoKnownAs");
            for (int i=0; i<nameArray.length(); i++)
            {
                alsoKnownAs.add(nameArray.getString(i));
            }
            placeOfOrigin = reader.getString("placeOfOrigin");
            description = reader.getString("description");
            image = reader.getString("image");

            ingArray = reader.getJSONArray("ingredients");

            for (int i=0; i<ingArray.length(); i++)
            {
                ingredients.add(ingArray.getString(i));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        Sandwich sandwitch = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwitch;
    }
}
