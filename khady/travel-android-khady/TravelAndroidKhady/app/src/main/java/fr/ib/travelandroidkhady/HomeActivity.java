package fr.ib.travelandroidkhady;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
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
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.home);
        String n = "";
        View v = findViewById(R.id.home_news);//v est un élément de type View et on veut un élément de type TextView
        TextView tvNews = (TextView) v;//donc on transtype(caste) le type View en type TextView et du coup vient écraser notre stub(donnée tempo) et la remplace par la nvelle donnée texte.

        try {
            InputStream is = getAssets().open("news");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String l = "";
            while ((l = br.readLine()) != null)
                n += l;
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        tvNews.setText(n);

        Button btMap = (Button) findViewById(R.id.home_btn_map);// transtypage de l'élément de type View en type Button
        btMap.setOnClickListener(this);//setOnClickListener écoute le bouton "btMap" pour constater l'événement du "Click"

        Button btReg = (Button) findViewById(R.id.register);
        btReg.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
            }
        });
    }

    public void onClick(View v) {
        Intent i = new Intent(HomeActivity.this, MapActivity.class);
        startActivity(i);
    }

}
