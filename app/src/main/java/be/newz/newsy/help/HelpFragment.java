package be.newz.newsy.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.newz.newsy.R;

public class HelpFragment extends Fragment {

    //private HelpViewModel savedViewModel;
    private  RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Help");
        View root = inflater.inflate(R.layout.fragment_help, container, false);

        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        List<Page> pages = new ArrayList<>();

        pages.add(new Page(getResources().getString(R.string.help_home_title), R.layout.help_home));
        pages.add(new Page(getResources().getString(R.string.help_search_title), R.layout.help_search));
        pages.add(new Page(getResources().getString(R.string.help_favorites_title), R.layout.help_favorites));
        pages.add(new Page(getResources().getString(R.string.help_settings_title), R.layout.help_settings));
        pages.add(new Page(getResources().getString(R.string.help_authors_title), R.layout.help_authors));


//        Button homeButton = root.findViewById(R.id.homeButton);
//
//        homeButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        adapter.setItems(pages);
        recyclerView.setAdapter(adapter);
        return root;

    }
}