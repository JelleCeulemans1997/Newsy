package be.newz.newsy;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {
    private TextView textView;


    public ProductViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewTest);
    }

    public void bind (Product product) {
        textView.setText(product.name);
    }
}
