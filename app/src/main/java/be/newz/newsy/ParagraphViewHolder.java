package be.newz.newsy;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ParagraphViewHolder extends ChildViewHolder {
    private TextView textViewContent;

    public ParagraphViewHolder(View itemView) {
        super(itemView);
        textViewContent = itemView.findViewById(R.id.content);
    }

    public void bind (Paragraph paragraph) {
        textViewContent.setText(paragraph.text);
    }
}
