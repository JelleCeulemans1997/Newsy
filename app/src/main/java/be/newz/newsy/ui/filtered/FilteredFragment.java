package be.newz.newsy.ui.filtered;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import be.newz.newsy.Article;
import be.newz.newsy.ArticleAdapter;
import be.newz.newsy.HttpReader;
import be.newz.newsy.JsonHelper;
import be.newz.newsy.R;

public class FilteredFragment extends Fragment {

    private FilteredViewModel filteredViewModel;
    private List<Article> articles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }


        filteredViewModel = ViewModelProviders.of(this).get(FilteredViewModel.class);
        View root = inflater.inflate(R.layout.fragment_filtered, container, false);



        Bundle bundle = getArguments();

        if (bundle != null) {
            int search = bundle.getInt("search");
            String keyword = bundle.getString("keyword");

            if (search == 0) {
                String url = "https://gnews.io/api/v3/search?q="+ keyword +"&country=be&lang=nl&token=f8437c31cb1a27be78ccbd616bc732ec";
                getArticles(root, url);
            }
            else if (search == 1) {
                String url = "https://gnews.io/api/v3/topics/"+ keyword +"?country=be&lang=nl&token=f8437c31cb1a27be78ccbd616bc732ec";
                getArticles(root, url);
            } else {
                Toast.makeText(getContext(), "ERROR ERROR ERROR", Toast.LENGTH_LONG).show();
            }
        }


        return root;
    }

    public void searhWithKeyword(String keyword) {
        Toast.makeText(getContext(), keyword, Toast.LENGTH_LONG).show();
    }

    public void searchOnTopic(String topic) {
        Toast.makeText(getContext(), topic, Toast.LENGTH_LONG).show();
    }

    public void getArticles(final View root, String url) {
        HttpReader httpReader = new HttpReader();
        httpReader.setOnResultReadyListener(new HttpReader.OnResultReadyListener() {
            @Override
            public void resultReady(String result) {
                JsonHelper jsonHelper = new JsonHelper();
                articles = jsonHelper.getArticles(result);

                final ListView listViewArticles = (ListView) root.findViewById(R.id.listViewArticles);
                ArticleAdapter artikelAdapter = new ArticleAdapter(getContext(), articles);
                listViewArticles.setAdapter(artikelAdapter);
            }
        });
        httpReader.execute(url);
    }
}