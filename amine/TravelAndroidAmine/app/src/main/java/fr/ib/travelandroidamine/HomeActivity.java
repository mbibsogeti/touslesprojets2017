package fr.ib.travelandroidamine;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ib on 22/03/2017.
 */

public class HomeActivity extends Activity  implements OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        //va faire la liaison avec home.xml
        setContentView(R.layout.home);
        //je veux pouvoir travailler sur le TextView avec un id="news"
        //v est un View
        View v = findViewById(R.id.news);
        //transtypage tvNews est notre TextView
        TextView tvNews = (TextView)v;
        //tvNews.setText("Pas de news!");
        String st ="";
        try{
            InputStream is = getAssets().open("news.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String l="";
            while ((l=br.readLine())!=null)
                st+=l;
            is.close();
        }catch(Exception ex){
            ex.getMessage();
            Log.e("HomeActivity", String.valueOf(ex));
        }
        tvNews.setText(st);
        /*relier l'activité Home à l'activité Register*/
        //actionner un comportement sur un clique boutton
        Button btMap= (Button)findViewById(R.id.home_btn_map);
        //indique qui écoute les auditeurs
        btMap.setOnClickListener(this);
        //boutton pour aller à l'activité register
        Button btReg=(Button)findViewById(R.id.home_btn_register);
        btReg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (HomeActivity.this,RegisterActivity.class));
            }
        });
        /*fin de la méthode Home_Register*/
    }
    @Override
    public void onClick(View v) {
        startActivity(new Intent(HomeActivity.this,MapActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home,menu);
        //lire notre préférence
        SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
        //écrire la préférence dans le menu
        menu.findItem(R.id.menu_register).setChecked(p.getBoolean("register",false));
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_map:
                startActivity(new Intent(HomeActivity.this,MapActivity.class));
                return true;
            case R.id.menu_register:
                //item l'appui, checked coché ou pas(si c'est coché je ne coche pas si c'est pas coché je coche)
                item.setChecked(!item.isChecked());
                //stocker voir la partie préférences
                SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
                SharedPreferences.Editor ed = p.edit();
                ed.putBoolean("register",item.isChecked());
                ed.commit();
                return true;
            default:
                return false;
        }
    }
}
