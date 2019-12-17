package be.newz.newsy;

import android.os.Parcel;
import android.os.Parcelable;

public class Paragraph implements Parcelable {
    public final String text;

    public Paragraph(String name) {
        this.text = name;
    }

    protected Paragraph(Parcel in) {
        text = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
    }

    public static final Parcelable.Creator<Paragraph> CREATOR = new Parcelable.Creator<Paragraph>() {
        @Override
        public Paragraph createFromParcel(Parcel in) {
            return new Paragraph(in);
        }

        @Override
        public Paragraph[] newArray(int size) {
            return new Paragraph[size];
        }
    };
}
