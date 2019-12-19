package be.newz.newsy.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import be.newz.newsy.articles.Article;
import be.newz.newsy.articles.ArticleAdapter;
import be.newz.newsy.articles.DatabaseHelper;
import be.newz.newsy.articles.HttpReader;
import be.newz.newsy.articles.JsonHelper;
import be.newz.newsy.preferences.Preference;
import be.newz.newsy.R;

public class HomeFragment extends Fragment {

    private List<Article> articles;

    private DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Home");

        db = new DatabaseHelper(getContext());

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        getArticles(root);
        return root;
    }

    public void getArticles(final View root) {
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                articles = jsonHelper.getArticles(result);

                final ListView listViewArtikels = (ListView) root.findViewById(R.id.listViewArticles);
                ArticleAdapter artikelAdapter = new ArticleAdapter(getContext(), articles);
                listViewArtikels.setAdapter(artikelAdapter);
            }
        });

        Preference preference = db.getPreference();
        String country = preference.getCountry();
        String language = preference.getLanguage();

        httpReader.execute("https://gnews.io/api/v3/top-news?country="+country+"&lang="+language+"&token=f8437c31cb1a27be78ccbd616bc732ec");
    }
}