package be.newz.newsy.ui.help;

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

import be.newz.newsy.Page;
import be.newz.newsy.R;
import be.newz.newsy.RecyclerAdapter;

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

        pages.add(new Page("Homepage", R.layout.help_home));
        pages.add(new Page("Searchpage", R.layout.help_search));

        adapter.setItems(pages);
        recyclerView.setAdapter(adapter);
        return root;

    }
}