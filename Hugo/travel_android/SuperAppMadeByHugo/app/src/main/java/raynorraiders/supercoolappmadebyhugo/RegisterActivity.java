package raynorraiders.supercoolappmadebyhugo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //création d'une liste de locations pour l'autocomplétion du champ Place, proposant plusieurs options
        String[] locations = {"aaaa", "bbbb", "cccc"};
        //création d'une variable actv de type AutoCompleteTextView associée à l'id reg_place_textbox
        //définie dans register.xml <AutocompleteTextViex/>
        AutoCompleteTextView actv=(AutoCompleteTextView)findViewById(R.id.reg_place_textbox);
        //création d'un adapter, qui fait le lien entre la liste, le layout et les différents composants.
        //Il est défini en appelant les objets qu'il va relier: le layout android.R.layout.simple_dropdown_item_1line
        //et la liste locations
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,locations);
        //association de l'adapter avec les composants du AutoCompleteTextViex
        actv.setAdapter(aa);
    }

    //"register" défini dans register.xml avec android:onClick="register" dans <button/>
    public void register(View v) {
        Log.i("Registration", "click!");
        EditText etName = (EditText) findViewById(R.id.reg_name_textbox);
        TextView tvInfo = (TextView) findViewById(R.id.reg_end);
        tvInfo.setText(etName.getText() + " registered");
    }
}
