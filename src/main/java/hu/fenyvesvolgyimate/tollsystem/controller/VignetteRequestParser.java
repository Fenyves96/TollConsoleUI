package hu.fenyvesvolgyimate.tollsystem.controller;

import hu.fenyvesvolgyimate.tollsystem.parser.JsonParser;
import org.json.JSONException;
import org.json.JSONObject;

public class VignetteRequestParser {
    JsonParser jsonParser = new JsonParser();
    public String parseRegistrationNumberIntoJson(String registrationNumber){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("registrationNumber", registrationNumber);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return jsonObject.toString();
    }
}
