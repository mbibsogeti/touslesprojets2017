package fr.ib.travelandroidamine;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

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
        //reponse
        TextView tvInfo=(TextView)findViewById(R.id.register_response);
        if(!(etName.getText().toString()).equals(""))
            tvInfo.setText(etName.getText()+" enregistré");
        else
            tvInfo.setText("Merci de remplir le champ Nom");
    }
}
