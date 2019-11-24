package be.newz.newsy.ui.help;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpViewModel() {
        //mText = new MutableLiveData<>();
        //mText.setValue("This is slideshow fragment");
    }

    /*public LiveData<String> getText() {
        return mText;
    }*/
}