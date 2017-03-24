package fr.ib.travelandroidbelto;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ib on 23/03/2017.
 */

public class RegisterActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        // autocompletion
        String[] location={"Austalie", "Nouvelle Zélande","Taiti","Fidji","Salomon","Palaos","Samoa","Nauru","Tonga"};
        AutoCompleteTextView actv=(AutoCompleteTextView)findViewById(R.id.lieu);
        ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,location);
        actv.setAdapter(a);
    }
    // la methode register declarer comme attribut dans la balise button avec pour attribut onClick
    public void register(View v){
        // un log pour tester...
      Log.i("RegisterActivity","click!");
        // recuperer le nom et l'afficher dans la dernière text-view
        EditText name=(EditText)findViewById(R.id.name);
        EditText tel=(EditText)findViewById(R.id.tel);
        EditText lieu=(EditText)findViewById(R.id.lieu);
        EditText information=(EditText)findViewById(R.id.information);
        TextView tvnews=(TextView)findViewById(R.id.news);
        // getText() renvoie un editable qui contient une chaine. Donc pour travailler avec comme en java, on le transforme en chaine avec toString.
        // on met un .toString pour recuperer la chaine
        // toUpperCase() pour mettre en capitale
        SharedPreferences p=getSharedPreferences("main",MODE_PRIVATE);
        // afficher que quand la case correspondante est crochée dans le menu
        if(p.getBoolean("register",false)) {
        TravelHelper h=new TravelHelper(this);
            // nb pour compter le nombre de fois le nom d'une personne est enregistrée en allant lire dans la base
          int nb= h.insertRequest(name.getText().toString(),tel.getText().toString(),lieu.getText().toString(),information.getText().toString());
            tvnews.setText(name.getText().toString().toUpperCase() + " avec le numero " + tel.getText() + " en provenance de " + lieu.getText() + " est " + " enregistré"+ " "+ nb);
            Thread t= new Thread(){
            public void run(){
                try {
                    URL url=new URL ("https:/fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&titles=Australie");
                    URLConnection conn=url.openConnection();
                    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String l;
                    while((l=br.readLine())!=null)
                    Log.i("RegisterActivity",l);
                    Log.i("RegisterActivity", "Fin de recherche:");
                    br.close();
                }catch (IOException ex){}
            }
        };
        t.start();
        }
    }

}


