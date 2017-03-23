package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import obodrel.fr.android_travel_obodrel.R;

public class RegisterActivity extends Activity{
    EditText _nameText;
    EditText _telText;
    AutoCompleteTextView _locationText;
    EditText _infoText;
    CheckBox _hurry;
    TextView _outcomeTf;
    String [] _locations;
    ArrayAdapter<String> _autoCompleteAdapter;


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
        _locations =  new String[]{"Toto", "Foo", "Bar","Toti","Tototo"};
        _autoCompleteAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,_locations);
        _locationText.setAdapter(_autoCompleteAdapter);
    }

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

        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) _infoText.getLayoutParams();
        params.weight = 1;
        _infoText.setLayoutParams(params);

        params = (LinearLayout.LayoutParams) _outcomeTf.getLayoutParams();
        params.weight = 10;
        _outcomeTf.setLayoutParams(params);

        _outcomeTf.setText(out);

    }
}