package fr.ib.travelandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
        String [] locations ={"Australie","Nouvelle zélande","PaPouasie-Nouvelle Guinée","Fidji","Samoa"};
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.lieu);
        ArrayAdapter<String> a = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, locations);
        actv.setAdapter(a);

    }

    public void register(View V) {
        Log.i("Register", "Click");
        EditText etName = (EditText) findViewById(R.id.name);
        EditText etPhone = (EditText) findViewById(R.id.phone);
        EditText etLocation = (EditText) findViewById(R.id.lieu);
        EditText etInfo = (EditText) findViewById(R.id.tvinfo);
        TextView tvInfo = (TextView) findViewById(R.id.info);

        //Prend en compte l'option de checkBox dans HomeActivity -  Si cocher, on peut s'enregistrer. Sinon, on ne coche pas, on ne peut pas s'enregistrer...
        SharedPreferences p = getSharedPreferences("main", MODE_PRIVATE);
        if (!etName.getText().toString().equals("") && p.getBoolean("register", false)) {
            TravelHelper th = new TravelHelper(this);
            int nb = th.insertRequest(etName.getText().toString(), etPhone.getText().toString(), etLocation.getText().toString(), etInfo.getText().toString());

            tvInfo.setText(getText(R.string.register_response) + " - " + etName.getText() + " Nombre de fois: " + nb);
        } else tvInfo.setText(getText(R.string.register_errorname));

        Thread t = new Thread() {
            public void run() {
                try{
                    URL url = new URL("https://fr.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles=australie");
                    URLConnection conn = url.openConnection();

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String l;

                    while((l=br.readLine())!=null) Log.i("Reg",l);

                    br.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
                Log.i("Fin de recherche", "!!");
            }
        };
        t.start();
    }
}
