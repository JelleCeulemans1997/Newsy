package be.thomasmore.newsy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Artikel> artikels = new ArrayList<Artikel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vulArtikels();
        toonArtikels();
    }

    private void toonArtikels() {
        ArtikelAdapter artikelAdapter = new ArtikelAdapter(getApplicationContext(),artikels);
        final ListView listViewArtikels = (ListView) findViewById(R.id.listViewArtikels);
        listViewArtikels.setAdapter(artikelAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void vulArtikels() {
        artikels.add(new Artikel("Animal Resistance reageert op kritiek na actie bij foie gras-producent : “De mortaliteit ligt sowieso hoog”",
                "https://news.google.com/__i/rss/rd/articles/CBMiMmh0dHBzOi8vd3d3Lm5pZXV3c2JsYWQuYmUvY250L2RtZjIwMTkxMTEyXzA0NzExNjc50gEA?oc=5",
                new Date(2019, 11, 12),
                "Het Nieuwsblad",
                "https://www.nieuwsblad.be"));
        artikels.add(new Artikel("Vlaamse regering wil beter overzicht van subsidies: \"Meer transparantie en makkelijker bijsturen\"","https://news.google.com/__i/rss/rd/articles/CBMiZ2h0dHBzOi8vd3d3LnZydC5iZS92cnRud3MvbmwvMjAxOS8xMS8xMi92bGFhbXNlLXJlZ2VyaW5nLXdpbC1iZXRlci1vdmVyemljaHQtdmFuLXN1YnNpZGllcy1tZWVyLXRyYW5zcC_SAQA?oc=5",
                new Date(2019,11,12),
                "VRT NWS",
                "https://www.vrt.be"
                ));
    }
}
