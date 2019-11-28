package be.newz.newsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.List;

import be.newz.newsy.ui.home.HomeFragment;

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
        final TextView textViewSource = (TextView) rowView.findViewById(R.id.source);
        final TextView textViewSourceUrl = (TextView) rowView.findViewById(R.id.sourceUrl);

        textViewTitel.setText(values.get(position).getTitle());
        textViewDatum.setText(values.get(position).getPublished().toString());
        textViewSource.setText(values.get(position).getSource());
        textViewSourceUrl.setText(values.get(position).getSourceUrl());


        Button buttonSaved = (Button) rowView.findViewById(R.id.saved);
        buttonSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Article article = new Article(values.get(position).getTitle(),values.get(position).getUrl(), values.get(position).getPublished(), values.get(position).getSource(),values.get(position).getSourceUrl());
                Toast.makeText(getContext(),"saved", Toast.LENGTH_SHORT).show();

                db = new DatabaseHelper(getContext());
                db.insertArticle(article);
            }
        });

        return rowView;
    }
}
