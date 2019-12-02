package be.newz.newsy.ui.favorites;

import android.database.sqlite.SQLiteDatabase;
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
import java.util.List;

import be.newz.newsy.Article;
import be.newz.newsy.ArticleAdapter;
import be.newz.newsy.DatabaseHelper;
import be.newz.newsy.MainActivity;
import be.newz.newsy.R;

public class FavoritesFragment extends Fragment {

    private FavoritesViewModel shareViewModel;
    private DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        shareViewModel =
                ViewModelProviders.of(this).get(FavoritesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_favorites, container, false);


        db = new DatabaseHelper(getContext());
        readarticlesSQL(root);

        return root;
    }

    private void readarticlesSQL (final View root) {
        final List<Article> articles = db.getArticles();

        final ListView listViewArtikels = (ListView) root.findViewById(R.id.listViewArticles);
        ArticleAdapter artikelAdapter = new ArticleAdapter(getContext(), articles);
        listViewArtikels.setAdapter(artikelAdapter);
    }
}