package be.thomasmore.newsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.List;

public class ArtikelAdapter extends ArrayAdapter<Artikel> {

    private final Context context;
    private final List<Artikel> values;

    public ArtikelAdapter(Context context, List<Artikel> values) {
        super(context, R.layout.artikellistviewitem, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.artikellistviewitem, parent, false);

        final TextView textViewTitel = (TextView) rowView.findViewById(R.id.titel);
        final TextView textViewDatum = (TextView) rowView.findViewById(R.id.datum);
        final TextView textViewSource = (TextView) rowView.findViewById(R.id.source);
        final TextView textViewSourceUrl = (TextView) rowView.findViewById(R.id.sourceUrl);

        textViewTitel.setText(values.get(position).getTitel());
        textViewDatum.setText(values.get(position).getPublished().toString());
        textViewSource.setText(values.get(position).getSource());
        textViewSourceUrl.setText(values.get(position).getSourceUrl());

        return rowView;
    }
}
