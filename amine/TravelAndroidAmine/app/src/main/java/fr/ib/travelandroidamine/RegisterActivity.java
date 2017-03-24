package fr.ib.travelandroidamine;

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

import fr.ib.travelandroidamine.R;

/**
 * Created by ib on 23/03/2017.
 */

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.register);
        //traitement de liste
        String[] locations={"Sidney","Suva","Jakarta","Wellington","Honolulu"};
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.form_lieu);
        // le Android est utilisé parce que ce n'est pas un standard
        //l'adaptateur gère l'affichage et affiche selon la recherche faite sur lui
        ArrayAdapter<String> a = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,locations);
        actv.setAdapter(a);
    }
    public void register(View v){
        Log.i("Register","Click!");
        EditText etName=(EditText)findViewById(R.id.form_name);
        EditText etPhone =(EditText)findViewById(R.id.form_tel);
        EditText etLocation=(EditText)findViewById(R.id.form_lieu);
        EditText etInfo=(EditText)findViewById(R.id.form_info);
        //reponse
        TextView tvInfo=(TextView)findViewById(R.id.register_response);
        //enregistré le formulaire
        SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
        if(!(etName.getText().toString()).equals("")) {
            if (p.getBoolean("register", false)) {
                //BD SQLite
                TravelHelper h = new TravelHelper(this);
                int nb = h.insertRequest(etName.getText().toString(),etPhone.getText().toString(),etLocation.getText().toString(),etInfo.getText().toString());
                //tvInfo.setText(etName.getText() + " enregistré");
                tvInfo.setText(etName.getText()+" enregistré "+nb+" fois");
            }
        }
        else
            tvInfo.setText("Merci de remplir le champ Nom");
        //connection à un serveur faire du parallélisme
        Thread t = new Thread(){
            public void run(){
                try{
                    URL url= new URL("https://fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&titles=Australie");
                    URLConnection conn = url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String l;
                    while ((l=br.readLine())!=null)
                        Log.i("Reg",l);
                    br.close();
                }catch (IOException ex){
                    Log.e("RegisterActivity",ex.getMessage());
                }
                Log.i("RegisterActivity","Fin recherche");
            }
        };
        t.start();
    }
}
