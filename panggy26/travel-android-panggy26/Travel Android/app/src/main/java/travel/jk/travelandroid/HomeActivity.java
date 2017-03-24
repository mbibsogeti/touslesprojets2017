package travel.jk.travelandroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ib on 22/03/2017.
 */

public class HomeActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Cette ligne est à mettre forcément AVANT l'utilisation des ID de strings.xml
        // L'instanciation de l'objet de type View est faite ici
        // Lit le layout et fait le lien entre Java et
        setContentView(R.layout.home);
        // R.id.news est un entier, toutes les ressources de R sont des numéros
        View vue = findViewById(R.id.news);
        // Transtypage de View à TextView (TextView hérite de View)
        TextView vueNews = (TextView) vue;
        String s = "";
        try {
            InputStream inputStream = getAssets().open("news.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            // Warning : pas besoin de l'initialiser car on passe forcément dans la boucle
            String ligne;
            // Lecture du fichier ligne à ligne jusqu'à la fin
            while ((ligne = bufferedReader.readLine()) != null) {
                s += ligne;
            } // end while
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } // end catch
        // Écrasement de la valeur du stub avec le texte de news.txt
        vueNews.setText(s);
        // Lien du bouton d'Home Activity vers MapActivity (voir home.xml)
        // Solution 1 :
        Button boutonMap = (Button) findViewById(R.id.home_btn_map);
        // l'activité elle-même écoute l'événement
        boutonMap.setOnClickListener(this);
        Button openMap = (Button) findViewById(R.id.enregistrement);
        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMapIntent = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(openMapIntent);
            } // end onClick method
        });
    } // end onCreate method

    public void onClick(View v) {
        Intent intention = new Intent(HomeActivity.this, MapActivity.class);
        startActivity(intention);
    } // end onClick method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        // MODE_PRIVATE : cette application et pas les autres
        SharedPreferences preferences = getSharedPreferences("nomMain", MODE_PRIVATE);
        menu.findItem(R.id.enregistrerMenu).setChecked(preferences.getBoolean("register", false));
        return true;
    } // end onCreateOptionsMenu method

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.carteMenu:
                Intent intention = new Intent(HomeActivity.this, MapActivity.class);
                startActivity(intention);
                return true;
            case R.id.enregistrerMenu:
                // Inversion de la valeur du booléen
                item.setChecked(!item.isChecked());
                // MODE_PRIVATE : cette application et pas les autres
                // getSharedPreferences() : pour pouvoir lire en plus ces préférences d'ailleurs
                SharedPreferences pref = getSharedPreferences("nomMain", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("register", item.isChecked());
                editor.commit();
                return true;
            default:
                return false;
        } // end switch
    } // end onMenuItemSelected method
} // end HomeActivity class