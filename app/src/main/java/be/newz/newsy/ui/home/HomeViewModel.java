package be.newz.newsy.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.newz.newsy.Article;
import be.newz.newsy.HttpReader;
import be.newz.newsy.JsonHelper;

public class HomeViewModel extends ViewModel {

//    private MutableLiveData<String> mText;
    private List<Article> articles;

    public HomeViewModel() {
        /*articles = new ArrayList<>();
        articles.add(new Article("Animal Resistance reageert op kritiek na actie bij foie gras-producent : “De mortaliteit ligt sowieso hoog”",
                "https://news.google.com/__i/rss/rd/articles/CBMiMmh0dHBzOi8vd3d3Lm5pZXV3c2JsYWQuYmUvY250L2RtZjIwMTkxMTEyXzA0NzExNjc50gEA?oc=5",
                new Date(2019, 11, 12),
                "Het Nieuwsblad",
                "https://www.nieuwsblad.be"));
        articles.add(new Article("Vlaamse regering wil beter overzicht van subsidies: \"Meer transparantie en makkelijker bijsturen\"", "https://news.google.com/__i/rss/rd/articles/CBMiZ2h0dHBzOi8vd3d3LnZydC5iZS92cnRud3MvbmwvMjAxOS8xMS8xMi92bGFhbXNlLXJlZ2VyaW5nLXdpbC1iZXRlci1vdmVyemljaHQtdmFuLXN1YnNpZGllcy1tZWVyLXRyYW5zcC_SAQA?oc=5",
                new Date(2019, 11, 12),
                "VRT NWS",
                "https://www.vrt.be"
        ));*/
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }

    public List<Article> getArticles() {
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                articles = jsonHelper.getArticles(result);
            }
        });
       // httpReader.execute("https://gnews.io/api/v3/top-news?country=be&lang=nl&token=f8437c31cb1a27be78ccbd616bc732ec");
        httpReader.execute("https://gnews.io/api/v3/top-news?country=be&lang=nl&token=8cff0cc27c01431cb92b8d8f7e7fcaa2");

        return articles;
    }

//    public LiveData<String> getText() {
//        return mText;
//    }
}