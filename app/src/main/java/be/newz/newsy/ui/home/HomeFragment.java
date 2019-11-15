package be.newz.newsy.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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
import be.newz.newsy.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private List<Article> articles;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        articles = homeViewModel.getArticles();

        final ListView listViewArtikels = (ListView) root.findViewById(R.id.listViewArticles);
        ArticleAdapter artikelAdapter = new ArticleAdapter(this.getContext(), articles);
        listViewArtikels.setAdapter(artikelAdapter);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                //textView.setText(s);
//            }
//        });
        return root;
    }


}