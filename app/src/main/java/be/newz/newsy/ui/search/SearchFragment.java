package be.newz.newsy.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;

import be.newz.newsy.R;
import be.newz.newsy.ui.filtered.FilteredFragment;

public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private SearchViewModel galleryViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //galleryViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        final TextInputEditText keywordTextInputEditText = root.findViewById(R.id.keywordTextInputEditText);
        final Button searchKeywordButton = (Button) root.findViewById(R.id.searchKeywordButton);
        final Spinner topicSpinner = root.findViewById(R.id.topicsSpinner);
        ArrayAdapter<CharSequence> topicsAdapter = ArrayAdapter.createFromResource(getContext(), R.array.topics, android.R.layout.simple_spinner_item);
        topicsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        topicSpinner.setAdapter(topicsAdapter);
        topicSpinner.setOnItemSelectedListener(this);

        searchKeywordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFilteredGragment(keywordTextInputEditText.getText().toString(), 0);
            }
        });
        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //redirect or no redirect
        String topic = adapterView.getItemAtPosition(i).toString().toLowerCase();
        if (!topic.equals("choose")) {
            startFilteredGragment(topic, 1);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void startFilteredGragment(String keyword, int search) {
        FilteredFragment filteredFragment = new FilteredFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("search", search);
        bundle.putString("keyword", keyword);
        filteredFragment.setArguments(bundle);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, filteredFragment).commit();
    }
}