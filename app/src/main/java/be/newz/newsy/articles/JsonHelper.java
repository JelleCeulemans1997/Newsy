package be.newz.newsy.articles;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import java.util.Calendar;

import java.text.SimpleDateFormat;

import be.newz.newsy.articles.Article;

public class JsonHelper {

    public List<Article> getArticles(String jsonTekst) {
        List<Article> articles = new ArrayList<Article>();

        try {
            JSONObject jsonObject = new JSONObject(jsonTekst);
            JSONArray jsonArrayArticles = jsonObject.getJSONArray("articles");
            //FIXME
            //Error when the device's internet connection is turned off!
            //Show popup when the app is booting and the internet connectivity is turned off (not before this part, but before executing newsy code)
            for (int i = 0; i < jsonArrayArticles.length(); i++) {
                JSONObject jsonObjectArticle = jsonArrayArticles.getJSONObject(i);
                Article article = new Article();
                article.setTitle(jsonObjectArticle.getString("title"));
                article.setUrl(jsonObjectArticle.getString("url"));

                String datum = jsonObjectArticle.getString("publishedAt");
                int year = Integer.parseInt(datum.substring(0,4));
                int month = Integer.parseInt(datum.substring(5,7));
                int day = Integer.parseInt(datum.substring(8,10));
                int hours = Integer.parseInt(datum.substring(11,13));
                int minutes = Integer.parseInt(datum.substring(14,16));
                int seconds = Integer.parseInt(datum.substring(17, 19));

                Calendar c = Calendar.getInstance();
                c.set(year, month -1, day, hours, minutes, seconds);
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");


                article.setPublished(sdf.format(c.getTime()));

                JSONObject jsonObjectSource = jsonObjectArticle.getJSONObject("source");
                article.setSource(jsonObjectSource.getString("name"));
                article.setSourceUrl(jsonObjectSource.getString("url"));

                articles.add(article);
            }
        } catch (JSONException e) {
            Log.e("JSON parser", "Error parsing data " + e.toString());
        }

        return articles;
    }
}
