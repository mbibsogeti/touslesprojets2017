package fr.ib.travelandroidma;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class HomeActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        // ***Accéder au views par id dans le java :
        // ***Note : chaque ressource correspond à un numéro dans R.
        // ***R.id.desc est donc un numéro, correspondant à une ressource
        View v = findViewById(R.id.news);
        // ***Caster en TextView pour pouvoir récupérer/modifier le texte contenu
        TextView tvNews = (TextView) v;
        // ***Récupération d'un texte avec Java puis écriture directement dans la view
        String s="";
        try {
            InputStream is = getAssets().open("news.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String l ="";
            while ((l = br.readLine())!=null) {
                s += l;
            }
            is.close();
        } catch(IOException ex) {}
        // ***NB : on aurait pu avoir un getText pour récupérer la valeur de tvNews
        tvNews.setText(s);

        // ***Configuration d'un bouton pour aller vers 'MapActivity':
        // ***On trouve le bouton dans home.xml :
        Button btMap = (Button) findViewById(R.id.home_btn_map);
        // ***On dit que 'this' (cette classe) écoute le bouton ainsi :
        btMap.setOnClickListener(this);

        // ***Nouveau bouton pour aller vers 'RegisterActivity'
        Button btReg = (Button) findViewById(R.id.home_btn_register);
        // ***OnClickListener est une interface : on ne peut pas l'instancier.
        // ***On utilisera ici une classe anonyme en implémentant les méthodes de
        // de l'interface dans des accolades.
        btReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ***Une intention se définit avec (class, class). On veut ici appeler
                // la classe 'HomeActivity' et pas 'View.OnClickListener'.
                // On ne peut donc pas écrire 'this', on doit préciser : 'HomeActivity.this'
                startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MapActivity.class);
        startActivity(i);
        // ***On peut le faire en une ligne :
        // startActivity(new Intent(HomeActivity.this, MapActivity.class))
    }

    // Création d'un menu (voir menu 'home.xml' dans res/menu) :
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        // On affiche la valeur de 'préférence' stockée. 'false' est la
        // valeur que l'on stockera par défaut.
        SharedPreferences p =getSharedPreferences("main",MODE_PRIVATE);
        menu.findItem(R.id.menuReg).setChecked(p.getBoolean("register",false));
        return true;
    }

    // Création d'intentions / checkbox à partir de l'activité
    public boolean onMenuItemSelected (int e,MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMap:
                // ***lien sur l'une des options du menu
                startActivity(new Intent(this, MapActivity.class));
                return true;
            case R.id.menuReg:
                // ***checkbox :
                item.setChecked(!item.isChecked());
                // ***Stockage d'une préférence :
                // Attention : chaque activité aura SES préférences.
                // On utilisera 'getSharedPreferences' qui permet
                // de faire des préférences communes à ttes les activités
                SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
                SharedPreferences.Editor ed = p.edit();
                    ed.putBoolean("register", item.isChecked());
                    ed.commit();
                return true;
            default:
                return false;
        }
    }
}
