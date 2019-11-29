package be.newz.newsy.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.newz.newsy.Article;
import be.newz.newsy.ArticleAdapter;
import be.newz.newsy.DatabaseHelper;
import be.newz.newsy.HttpReader;
import be.newz.newsy.JsonHelper;
import be.newz.newsy.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Article> articles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //articles = homeViewModel.getArticles();
        getArticles(root);

//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                //textView.setText(s);
//            }
//        });
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
        httpReader.execute("https://gnews.io/api/v3/top-news?country=be&lang=nl&token=f8437c31cb1a27be78ccbd616bc732ec");
    }
}