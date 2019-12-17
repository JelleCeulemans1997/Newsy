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

import com.github.florent37.expansionpanel.ExpansionLayout;
import com.github.florent37.expansionpanel.viewgroup.ExpansionLayoutCollection;

import java.util.ArrayList;
import java.util.List;

import be.newz.newsy.Page;
import be.newz.newsy.Paragraph;
import be.newz.newsy.ParagraphAdapter;
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

        ArrayList<Paragraph> paragraphs = new ArrayList<>();
        paragraphs.add(new Paragraph("First paragraph"));
        paragraphs.add(new Paragraph("Second adapter"));

        Page home = new Page("First page", paragraphs);

        pages.add(home);

        adapter.setItems(pages);
        recyclerView.setAdapter(adapter);
        return root;

    }
}