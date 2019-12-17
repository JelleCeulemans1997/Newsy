package be.newz.newsy;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Page extends ExpandableGroup<Paragraph> {
    public Page(String title, List<Paragraph> paragraphs) {
        super(title, paragraphs);
    }
}
