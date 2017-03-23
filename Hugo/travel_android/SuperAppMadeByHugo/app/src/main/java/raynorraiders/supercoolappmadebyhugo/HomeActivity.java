package raynorraiders.supercoolappmadebyhugo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
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

}


