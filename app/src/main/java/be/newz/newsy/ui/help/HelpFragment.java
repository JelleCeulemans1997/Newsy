package be.newz.newsy.ui.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import be.newz.newsy.Company;
import be.newz.newsy.Product;
import be.newz.newsy.ProductAdapter;
import be.newz.newsy.R;

public class HelpFragment extends Fragment {

    private HelpViewModel savedViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        if (container != null) {
            container.removeAllViews();
        }


        View root = inflater.inflate(R.layout.fragment_help, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<Company> companies = new ArrayList<>();

        ArrayList<Product> googleProduct = new ArrayList<>();
        googleProduct.add(new Product("Google AdSense"));
        googleProduct.add(new Product("Google Drive"));
        googleProduct.add(new Product("Google Mail"));
        googleProduct.add(new Product("Google Doc"));


        Company google = new Company("Google", googleProduct);
        companies.add(google);

        Company home = new Company("Home", googleProduct);
        companies.add(home);

        Company search = new Company("Search", googleProduct);
        companies.add(search);

        Company favorites = new Company("Favorites", googleProduct);
        companies.add(favorites);

        Company settings = new Company("Settings", googleProduct);
        companies.add(settings);



        ProductAdapter adapter = new ProductAdapter(companies);
        recyclerView.setAdapter(adapter);




        return root;

    }
}