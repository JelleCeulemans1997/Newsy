package be.newz.newsy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import java.util.List;

import be.newz.newsy.ui.browser.BrowserFragment;

public class FavoritesAdapter extends ArrayAdapter<Article> {
    private final Context context;
    private final List<Article> values;
    private DatabaseHelper db;

    public FavoritesAdapter(Context context, List<Article> values) {
        super(context, R.layout.articlelistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.articlelistviewitem, parent, false);

        final TextView textViewTitel = (TextView) rowView.findViewById(R.id.title);
        final TextView textViewDatum = (TextView) rowView.findViewById(R.id.date);
        final Button buttonSource = (Button) rowView.findViewById(R.id.source);

        final ImageButton imageButtonBrowser = rowView.findViewById(R.id.browser);
        final ImageButton imageButtonSaved = (ImageButton) rowView.findViewById(R.id.saved);
        final ImageButton imageButtonShare = rowView.findViewById(R.id.share);

        textViewTitel.setText(values.get(position).getTitle());
        textViewDatum.setText(values.get(position).getPublished().toString());
        buttonSource.setText(values.get(position).getSource());
        buttonSource.setTag(values.get(position).getSourceUrl());

        imageButtonBrowser.setImageResource(R.drawable.earth);
        imageButtonSaved.setImageResource(R.drawable.delete);
        imageButtonShare.setImageResource(R.drawable.share);

        final Article article = new Article(values.get(position).getTitle(), values.get(position).getUrl(), values.get(position).getPublished(), values.get(position).getSource(), values.get(position).getSourceUrl());

        buttonSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser(view.getTag().toString());
            }
        });
        imageButtonBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser(values.get(position).getUrl());
            }
        });
        imageButtonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSend = "Lees hier het artikel: " + article.getTitle() + "  " + article.getUrl();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                getContext().startActivity(shareIntent);
            }
        });

        imageButtonSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = new DatabaseHelper(getContext());
                //db.deleteArticle(article);
            }
        });

        return rowView;
    }

    private void openBrowser(String url) {
        BrowserFragment browserFragment = new BrowserFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        browserFragment.setArguments(bundle);
        ((FragmentActivity) getContext()).getFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment, browserFragment)
                .commit();
    }
}
