package fr.ib.travelandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;

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

    public void register(View V){
        Log.i("Register","Click");
        EditText etName = (EditText)findViewById(R.id.name);
        TextView tvInfo = (TextView)findViewById(R.id.info);
        if (!etName.getText().toString().equals("")) tvInfo.setText(getText(R.string.register_response) +" - " + etName.getText());
        else tvInfo.setText(getText(R.string.register_errorname));
    }
}
