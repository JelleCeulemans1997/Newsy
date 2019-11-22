package be.newz.newsy.ui.preferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;

import be.newz.newsy.CountryAdapter;
import be.newz.newsy.CountryItem;
import be.newz.newsy.R;

public class PreferencensFragment extends Fragment {

    private ArrayList<CountryItem> countryList;
    private CountryAdapter countryAdapter;


    private PreferencesViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(PreferencesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_preferences, container, false);

        initList();

        Spinner spinnerCountries = root.findViewById((R.id.spinner_countries));

        countryAdapter = new CountryAdapter(getContext(), countryList);
        spinnerCountries.setAdapter(countryAdapter);

        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CountryItem selectedItem = (CountryItem) adapterView.getItemAtPosition(i);
                String selectedCountry = selectedItem.getCountry();
                Toast.makeText(getContext(), selectedCountry + " saved as setting", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return root;
    }

    private void initList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Belgium", "Dutch", R.drawable.flag_belgium));
        countryList.add(new CountryItem("Belgium", "French", R.drawable.flag_belgium));
        countryList.add(new CountryItem("The Netherlands", "Dutch", R.drawable.flag_netherlands));
        countryList.add(new CountryItem("France", "French", R.drawable.flag_france));
        countryList.add(new CountryItem("Germany", "German", R.drawable.flag_germany));
        countryList.add(new CountryItem("United Kingdom", "English", R.drawable.flag_uk));
        countryList.add(new CountryItem("United States of America", "English", R.drawable.flag_us));

    }
}