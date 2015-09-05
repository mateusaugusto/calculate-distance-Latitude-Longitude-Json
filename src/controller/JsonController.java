/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import model.JsonModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mateus
 */
public class JsonController {

    public ArrayList<JsonModel> ReadJsonCalc() throws FileNotFoundException, IOException, ParseException {

        FileInputStream fstream = new FileInputStream("gistfile1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        ArrayList<JsonModel> result = new ArrayList<>();      
        JsonModel model;

        double L1, G1, L2, G2;

        //Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            model = new JsonModel();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(strLine);
            JSONObject jsonObject = (JSONObject) obj;

            model.setLatitude((double) Double.parseDouble((String) jsonObject.get("latitude")));
            model.setLongitude((double) Double.parseDouble((String) jsonObject.get("longitude")));
            model.setUserIid((int) Integer.parseInt((String) jsonObject.get("user_id").toString()));
            model.setName(((String) jsonObject.get("name")));

            L1 = Math.toRadians(model.getLatitudeDefault());
            G1 = Math.toRadians(model.getLongitudeDefault());
            L2 = Math.toRadians(model.getLatitude());
            G2 = Math.toRadians(model.getLongitude());

            // do the spherical trig calculation
            double angle = Math.acos(Math.sin(L1) * Math.sin(L2)
                    + Math.cos(L1) * Math.cos(L2) * Math.cos(G1 - G2));
            // convert back to degrees
            angle = Math.toDegrees(angle);

            // each degree on a great circle of Earth is 69.1105 miles
            double distance = (69.1105 * angle) * 1.609344 ;
            
            if ( distance <= 100)
                 result.add(model);
        }
        Collections.sort(result);         
        
        return result;
    }

}
