package com.example.adidas;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    public void read(String urlPath, IResponse response) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            Log.v("rezultat", result.toString());

            reader.close();
            inputStreamReader.close();
            inputStream.close();

            List<Model> list = parsare(result.toString());
            response.onSucces(list);

        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }

    }

    private List<Model> parsare(String jsonString) {
        List<Model> lista = new ArrayList<>();

        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("workouts");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                int time = currentObject.getInt("time");
                String difficulty = currentObject.getString("difficulty");
                String title = currentObject.getString("title");
                int image_number = currentObject.getInt("image");
                Integer image;
                switch (image_number) {
                    case 5:
                        image = R.drawable.workout5_json_img;
                        break;
                    case 6:
                        image = R.drawable.workout6_json_img;
                        break;
                    default:
                        image = R.drawable.no_image_img;
                }
                JSONArray JSONtags = currentObject.getJSONArray("tags");
                String[] tags = new String[JSONtags.length()];
                for (int j = 0; j < JSONtags.length(); j++) {
                    tags[j] = JSONtags.getString(j);
                }

                Model workout = new Model(time, difficulty, title, image, tags);
                lista.add(workout);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
