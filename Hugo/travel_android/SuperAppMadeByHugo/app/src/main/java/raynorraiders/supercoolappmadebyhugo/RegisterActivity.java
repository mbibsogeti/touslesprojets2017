package raynorraiders.supercoolappmadebyhugo;

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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        //création d'une liste de locations pour l'autocomplétion du champ Place, proposant plusieurs options
        String[] locations = {"aaaa", "bbbb", "cccc"};
        //création d'une variable actv de type AutoCompleteTextView associée à l'id reg_place_textbox
        //définie dans register.xml <AutocompleteTextViex/>
        AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.reg_place_textbox);
        //création d'un adapter, qui fait le lien entre la liste, le layout et les différents composants.
        //Il est défini en appelant les objets qu'il va relier: le layout android.R.layout.simple_dropdown_item_1line
        //et la liste locations
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, locations);
        //association de l'adapter avec les composants du AutoCompleteTextViex
        actv.setAdapter(aa);
    }

    //"register" défini dans register.xml avec android:onClick="register" dans <button/>
    public void register(View v) {
        Log.i("Registration", "click!");
        //association du texte entrée dans les champs du formulaire avec des variables locales de type EditText
        EditText etName = (EditText) findViewById(R.id.reg_name_textbox);
        EditText etPhone = (EditText) findViewById(R.id.reg_tel_textbox);
        EditText etLoc = (EditText) findViewById(R.id.reg_place_textbox);
        EditText etInfo = (EditText) findViewById(R.id.reg_info_textbox);
        TextView tvInfo = (TextView) findViewById(R.id.reg_end);
        SharedPreferences preferences = getSharedPreferences("main", MODE_PRIVATE);
        //actions si register est coché
        if (preferences.getBoolean("register", false)) {
            //définition d'une variable helper de type TravelHelper
            TravelHelper helper = new TravelHelper(this);
            // Insertion d'une requête pour la base de données db via la variable helper
            // et la méthode InsertRequest dont les paramètres ont été définis dans la classe TravelHelper
            int nb = helper.insertRequest(etName.getText().toString(), etPhone.getText().toString(), etLoc.getText().toString(), etInfo.getText().toString());
            // affichage d'un texte lors qu'on click sur le bouton Register
            tvInfo.setText(etName.getText() + " registered " + nb + " times.");
            // pour commencer le procès dans un nouveau thread
            Thread thread = new Thread() {
                public void run() {
                    try {
                        URL url = new URL("https://fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&titles=Australie");
                        URLConnection connection = url.openConnection();
                        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String l;
                        Log.i("reg","info");
                        while ((l = br.readLine()) != null) {
                            Log.i("Reg", l);
                        }
                        br.close();
                    } catch (MalformedURLException e) {
                        Log.e("reg",e.getMessage());
                    } catch (IOException e) {
                        Log.e("reg",e.getMessage());
                    }
                    Log.i("RegisterActivity", "Fin recherche:");
                }
            };
            thread.start();
        }
    }
}
