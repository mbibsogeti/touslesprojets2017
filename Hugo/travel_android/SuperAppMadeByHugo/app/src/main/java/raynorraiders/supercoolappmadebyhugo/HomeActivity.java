package raynorraiders.supercoolappmadebyhugo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HomeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //appeler une view par son id
        View v = findViewById(R.id.news);
        //définir une la view appelée précédemment comme une nouvell TextView
        TextView tvNews = (TextView) v;
        //créer une chaîne de caractères pour l'afficher dans la TextView
        String s = "";
        try {
            //ouverture d'un flux de données pour des Assets
            InputStream is = getAssets().open("news.txt");
            //lecture continue des données dans le fichier news.txt
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //remplisage progressif de la chaîne de caractères, au fur et à mesure que les données sont lues depuis le fichier news.txt
            String l;
            while ((l = br.readLine()) != null) {
                s += l;
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvNews.setText(s);

        //1ère partie création du button qui dirige vers le reste de l'app
        Button btMap = (Button) findViewById(R.id.home_button_map);
        btMap.setOnClickListener(this);

        //une 2ème syntaxe pour les définir des actions sur les bouttons, plus rapide mais moins lisible
        Button btReg = (Button) findViewById(R.id.reg_button_home);
        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
            }
        });
    }

    //2ème partie pour la première méthode des bouttons
    public void onClick(View v) {
        Intent i = new Intent(HomeActivity.this, MapActivity.class);
        startActivity(i);
    }

    //pour créer un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.home,menu);
        //Partie 1 pour stocker les valeurs rentrées lorsqu'on redemarre l'app.
        //dans ce l'état de la checkbox
        SharedPreferences preferences=getSharedPreferences("main",MODE_PRIVATE);
        menu.findItem(R.id.menu_reg).setChecked(preferences.getBoolean("register",false));
        return true;
    }

    //actions lorsqu'on tape sur un menu
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu_map:
                startActivity(new Intent(HomeActivity.this,MapActivity.class));
                return true;
            case R.id.menu_reg:
                menuItem.setChecked(! menuItem.isChecked());
                //Patie 2 pour stocker les valeurs rentrées lorsqu'on redemarre l'app.
                SharedPreferences preferences=getSharedPreferences("main",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putBoolean("register",menuItem.isChecked());
                //le commit sauvegarde les préférences dans le disque local
                editor.commit();
                return true;
            default:
                return false;
        }
    }

//    ...=ENviroment.getExternalStorageState()
//    if(...==true)
//    ...=getExternalFileDir();
//    ...=Enviroment.getExternalStoragePublicDirectory("nom_constante",Music);

}


