package be.newz.newsy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ParagraphAdapter extends ExpandableRecyclerViewAdapter<PageViewHolder, ParagraphViewHolder> {
    public ParagraphAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public PageViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expendable_recycleview_page, parent, false);
        return new PageViewHolder(v);
    }

    @Override
    public ParagraphViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.expendable_recycleview_paragraph, parent, false);
        return new ParagraphViewHolder(v);
    }

    @Override
    public void onBindChildViewHolder(ParagraphViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Paragraph product = (Paragraph) group.getItems().get(childIndex);
        holder.bind(product);
    }

    @Override
    public void onBindGroupViewHolder(PageViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Page company = (Page) group;
        holder.bind(company);
    }
}
