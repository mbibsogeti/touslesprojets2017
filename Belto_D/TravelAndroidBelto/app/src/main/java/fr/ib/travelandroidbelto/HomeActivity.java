package fr.ib.travelandroidbelto;

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

public class HomeActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // on lui dit d'aller lire le layout Home
        setContentView(R.layout.home);
        //on lui dit d'utiliser la classe mère view pour aller chercher la textView avec l'id info.txt
        View v=findViewById(R.id.info);
        // on le castre dans une variable de TextView,On utilise la methode Textview qui est specifique au textView
        TextView tvNews=(TextView)v;
        // du coup on écrase ce qui est declaré dans le stub
        String s="";
        // recuperer des erreurs
        try{
            //on va chercher le fichier(info.txt dans assets), on le lit
            InputStream is=getAssets().open("info.txt");
                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
            //on le lit, ligne par ligne et on l'ajoute dans s
            String l;
            while ((l=br.readLine())!=null)
                    s+=l;
            is.close();
        }catch (IOException ex){}
        // on affiche s
        tvNews.setText(s);
        Button btnMap=(Button)findViewById(R.id.home_btn_map);
        btnMap.setOnClickListener(this);
        // nouvelle façon de gerer un bouton (pas besoin de implements view.OnclickListenner
        Button btnRegister=(Button)findViewById(R.id.register_btn_map);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // HomeActivity.this car
                startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,MapActivity.class);
        startActivity(i);

    }
    // fonction pour afficher le menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.home,menu);
        //stockage préferences
        SharedPreferences p=getSharedPreferences("main",MODE_PRIVATE);
        menu.findItem(R.id.Enregistrer).setChecked(p.getBoolean("register",false));
        return true;
    }
    // une fonction pour relier la carte affichée dans le menu à la carte quand on click dessus
    @Override
    public boolean onMenuItemSelected(int f, MenuItem item){
        switch(item.getItemId()){
        case R.id.Carte:startActivity(new Intent(HomeActivity.this,MapActivity.class));
            return true;
        // permet de pouvoir crocher une case dans option et restera crocher après!
        case R.id.Enregistrer:item.setChecked(!item.isChecked());
            SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
            SharedPreferences.Editor ed= p.edit();
            ed.putBoolean("register",item.isChecked());
            ed.commit();
            return true;
        default:
            return false;
        }

    }

}
