package be.newz.newsy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class PageViewHolder extends GroupViewHolder {
    private TextView textView;
    public PageViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewTest);
    }

    public void bind (Page page) {
        textView.setText(page.getTitle());
    }
}
