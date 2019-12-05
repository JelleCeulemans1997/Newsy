package be.newz.newsy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.fragment.app.FragmentActivity;

import java.util.List;
import androidx.fragment.app.FragmentManager;

import be.newz.newsy.ui.browser.BrowserFragment;

public class ArticleAdapter extends ArrayAdapter<Article> {

    private final Context context;
    private final List<Article> values;
    private DatabaseHelper db;

    public ArticleAdapter(Context context, List<Article> values) {
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
        //final TextView textViewSourceUrl = (TextView) rowView.findViewById(R.id.sourceUrl);

        final ImageButton imageButtonBrowser = rowView.findViewById(R.id.browser);
        final ImageButton imageButtonShare = rowView.findViewById(R.id.share);

        textViewTitel.setText(values.get(position).getTitle());
        textViewDatum.setText(values.get(position).getPublished().toString());
        buttonSource.setText(values.get(position).getSource());
        buttonSource.setTag(values.get(position).getSourceUrl());

        final Article article = new Article(values.get(position).getTitle(),values.get(position).getUrl(), values.get(position).getPublished(), values.get(position).getSource(),values.get(position).getSourceUrl());

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
                String textToSend = "<p>Lees hier het artikel: "  + article.getTitle() + "</p>";
                textToSend += "<a href=" + article.getUrl() + ">" +  article.getUrl()  + "</a>";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
                sendIntent.setType("text/html");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                getContext().startActivity(shareIntent);
            }
        });

        ImageButton imageButtonSaved = (ImageButton) rowView.findViewById(R.id.saved);
        imageButtonSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"saved", Toast.LENGTH_SHORT).show();

                db = new DatabaseHelper(getContext());
                db.insertArticle(article);
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
