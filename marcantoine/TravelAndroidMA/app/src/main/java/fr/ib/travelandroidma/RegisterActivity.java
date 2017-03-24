package fr.ib.travelandroidma;

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

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        // Création d'un 'spinner = zone d'autocomplétion' : création d'un tableau de valeurs
        String[] locations= {"Sydney","Dubo","Grafton","Lithgow","Orange","Newcastle"};
        // On appelle notre View où l'on veut créer notre spinner.
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.actvPlace);
        // On crée le spinner
        ArrayAdapter<String> a = new ArrayAdapter<String>(
                this, android.R.layout.simple_dropdown_item_1line,locations
        );
        actv.setAdapter(a);
    }

    // On modifie notre fonction register pour enregistrer des préférences.
    public void register (View v) {
        Log.i("Register activated","click!!");
        EditText etName = (EditText) findViewById(R.id.etName);
        EditText etTel = (EditText) findViewById(R.id.etTel);
        EditText actvPlace = (EditText) findViewById(R.id.actvPlace);
        EditText etinfo = (EditText) findViewById(R.id.etInfo);
        TextView tvFormSent = (TextView) findViewById(R.id.tvFormSent);

        // On permettra au user d'envoyer un form uniquement si checkbox
        // 'registration' du menu est cochée.
        SharedPreferences p = getSharedPreferences("main",MODE_PRIVATE);
        if (p.getBoolean("register",false)) {
            TravelHelper h = new TravelHelper(this);
            int nb = h.insertRequest(
                    etName.getText().toString(),
                    etTel.getText().toString(),
                    actvPlace.getText().toString(),
                    etinfo.getText().toString());
            //tvFormSent.setText(etName.getText()+" "+getString(R.string.form_sent));
            tvFormSent.setText(etName.getText()+" "+getString(R.string.form_sent)+" "+nb+" times.");
        }

        // On crée un nouveau thread, une classe anonyme héritant de
        Thread t = new Thread() {
            @Override
            public void run() {
                // (on pourra retrouver cela dans nos exemples REST)
                try {
                    URL url = new URL ("https://fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&titles=Australie");
                    URLConnection conn = url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String l;
                    while ((l = br.readLine())!=null)
                        Log.i("Reg",l);
                    br.close();
                } catch (IOException ex) {}
                // On affiche le résultat :
                Log.i ("RegisterActivity","Fin recherche");
            }
        };
        t.start();

    }
}
