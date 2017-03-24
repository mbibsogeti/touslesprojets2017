package travel.jk.travelandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ib on 24/03/2017.
 */

public class RegisterActivity extends Activity {

    // ATTRIBUTS //
    EditText _nameText;
    EditText _telText;
    AutoCompleteTextView _locationText;
    EditText _infoText;
    CheckBox _hurry;
    TextView _outcomeTf;
    String[] _locations;
    ArrayAdapter<String> _autoCompleteAdapter;

    // MÉTHODES //
    // Version Reynald
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        _nameText = (EditText) findViewById(R.id.nameTf);
        _telText = (EditText) findViewById(R.id.telTf);
        _locationText = (AutoCompleteTextView) findViewById(R.id.locationTf);
        _infoText = (EditText) findViewById(R.id.infoTf);
        _hurry = (CheckBox) findViewById(R.id.hurryCheckBox);
        _outcomeTf = (TextView) findViewById(R.id.outcomeLabel);
        _locations = new String[]{"Toto", "Foo", "Bar", "Toti", "Tototo"};
        _autoCompleteAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, _locations);
        _locationText.setAdapter(_autoCompleteAdapter);
    } // end onCreate method

/*    // Version Hugo
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
    }*/

    // Version Reynald
    public void onClickRegister(View v) {
        String name = _nameText.getText().toString();
        String tel = _telText.getText().toString();
        String location = _locationText.getText().toString();
        String infos = _infoText.getText().toString();
        Boolean hurry = _hurry.isChecked();
        String out = "name = " + name + "\n"
                + "tel = " + tel + "\n"
                + "location = " + location + "\n"
                + "infos = " + infos + "\n"
                + "hurry = " + hurry;
        // Change la taille avec la somme des poids
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) _infoText.getLayoutParams();
        params.weight = 1;
        _infoText.setLayoutParams(params);
        params = (LinearLayout.LayoutParams) _outcomeTf.getLayoutParams();
        params.weight = 10;
        _outcomeTf.setLayoutParams(params);
        // Récupération des préférences
        SharedPreferences pref = getSharedPreferences("nomMain", MODE_PRIVATE);
        // Si la case est cochée
        if (pref.getBoolean("register", false)) {
            TravelHelper travelHelper = new TravelHelper(this);
            // Code effacé et remplacé par la ligne suivante
            // travelHelper.insertRequest(name, tel, location, infos);
            int nb = travelHelper.insertRequest(name, tel, location, infos);
            _outcomeTf.setText(out + "\n nb=" + nb);
            // Difficulté du au synchronisme : aucun autre thread que le principal ne peut accéder
            // directement aux éléments de l'interface, que ce soit en lecture ou en écriture
            Thread thread = new Thread() {
                public void run() {
                    try {
                        // Exemple semblable au Wikipédia du module REST
                        URL url = new URL("https://fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&titles=Australie");
                        URLConnection conn = url.openConnection();
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String ligne;
                        while ((ligne = br.readLine()) != null) {
                            Log.i("Reg", ligne);
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Log à voir dans l'Android Monitor lorsqu'on appuie sur le bouton Register
                    Log.i("RegisterActivity", "Fin recherche :");
                }
            };
            thread.start();
        }
    } // onClickRegister method

 /*   // Version Hugo en tentant de remplacer les Id par ceux que j'ai (de Reynald)
    //"register" défini dans register.xml avec android:onClick="register" dans <button/>
    public void register(View v) {
        Log.i("Registration", "click!");
        EditText etName = (EditText) findViewById(R.id.infoTf);
        TextView tvInfo = (TextView) findViewById(R.id.outcomeLabel);
        SharedPreferences pref = getSharedPreferences("nomMain", MODE_PRIVATE);
        // Si la case est cochée
        if(pref.getBoolean("register", false)) {
            tvInfo.setText(etName.getText() + " registered");
        }
    }*/
} // end RegisterActivity class