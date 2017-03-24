package fr.ib.travelandroidkhady;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;


/**
 * Created by ib on 23/03/2017.
 */

public class RegisterActivity extends Activity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
setContentView(R.layout.register);

        String []locations = {"Sidney","Brisbane","Cairns","Townsville","Hobart"};
        AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.lieu);
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,locations);
        actv.setAdapter(a);
        /*ces lignes de code permett. quand on commence à taper le nom d'un lieu, nous propose le nom complet du lieu sans qu'on ait besoin de tout saisir
        et pour cela, il fallu mettre la balise  AutoCompleteTextView à la place de celle de EditText le register.xml pour l'élément lieu*/
    }

    public void register(View v){
        Log.i("Registered", "click !");
        EditText text = (EditText)findViewById(R.id.name);
        TextView tvInfo = (TextView)findViewById(R.id.info);
        tvInfo.setText(text.getText().toString()+" registered !");

    }
}
