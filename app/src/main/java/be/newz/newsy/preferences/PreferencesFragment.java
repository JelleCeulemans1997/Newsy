package be.newz.newsy.preferences;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import android.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import be.newz.newsy.articles.DatabaseHelper;
import be.newz.newsy.R;

public class PreferencesFragment extends Fragment {

    private ArrayList<CountryItem> countryList;
    private CountryAdapter countryAdapter;

    private DatabaseHelper db;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Preferences");

        db = new DatabaseHelper(getContext());

        View root = inflater.inflate(R.layout.fragment_preferences, container, false);

        initList();

        Spinner spinnerCountries = root.findViewById((R.id.spinner_countries));

        countryAdapter = new CountryAdapter(getContext(), countryList);
        spinnerCountries.setAdapter(countryAdapter);

        spinnerCountries.setSelection(db.getPreference().getPosition());
        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                CountryItem selectedItem = (CountryItem) adapterView.getItemAtPosition(i);

                Preference preference = new Preference();
                preference.setCountry(selectedItem.getCountryValue());
                preference.setLanguage(selectedItem.getLanguageValue());
                preference.setPosition(i);

                db.clearPreferences();
                db.insertPreference(preference);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        return root;
    }

    private void initList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Belgium", "Dutch", R.drawable.flag_belgium, "be", "nl"));
        countryList.add(new CountryItem("Belgium", "French", R.drawable.flag_belgium, "be", "fr"));
        countryList.add(new CountryItem("The Netherlands", "Dutch", R.drawable.flag_netherlands, "nl", "nl"));
        countryList.add(new CountryItem("France", "French", R.drawable.flag_france, "fr", "fr"));
        countryList.add(new CountryItem("Germany", "German", R.drawable.flag_germany, "de", "de"));
        countryList.add(new CountryItem("United Kingdom", "English", R.drawable.flag_uk, "uk", "en"));
        countryList.add(new CountryItem("United States of America", "English", R.drawable.flag_us, "us", "en"));

    }
}