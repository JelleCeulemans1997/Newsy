package be.newz.newsy;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonHelper {

    public List<Article> getArticles(String jsonTekst) {
        List<Article> articles = new ArrayList<Article>();

        try {
            JSONObject jsonObject = new JSONObject(jsonTekst);
            JSONArray jsonArrayArticles = jsonObject.getJSONArray("articles");
            for (int i = 0; i < jsonArrayArticles.length(); i++) {
                JSONObject jsonObjectArticle = jsonArrayArticles.getJSONObject(i);
                Article article = new Article();
                article.setTitle(jsonObjectArticle.getString("title"));
                article.setUrl(jsonObjectArticle.getString("url"));

                String datum = jsonObjectArticle.getString("publishedAt");
                int year = Integer.parseInt(datum.substring(0,4));
                int month = Integer.parseInt(datum.substring(5,7));
                int day = Integer.parseInt(datum.substring(8,10));
                article.setPublished(new Date(year, month, day));

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
