package fr.ib.travelandroidma;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

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

    public void register (View v) {
        Log.i("Register activated","click!!");
        EditText etName = (EditText) findViewById(R.id.etName);
        TextView tvFormSent = (TextView) findViewById(R.id.tvFormSent);
        tvFormSent.setText(etName.getText()+" "+getString(R.string.form_sent));
    }
}
