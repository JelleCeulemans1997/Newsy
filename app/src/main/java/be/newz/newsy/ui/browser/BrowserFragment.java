package be.newz.newsy.ui.browser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import android.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.textfield.TextInputEditText;

import be.newz.newsy.R;
import be.newz.newsy.ui.filtered.FilteredFragment;

public class BrowserFragment extends Fragment {

    private BrowserViewModel browserViewModel;
    private WebView webView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_browser, container, false);

        if (container != null) {
            container.removeAllViews();
        }

        Bundle bundle = getArguments();
        String url = bundle.getString("url");

        webView = (WebView) root.findViewById(R.id.webViewBrowser);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });



        return root;
    }

}