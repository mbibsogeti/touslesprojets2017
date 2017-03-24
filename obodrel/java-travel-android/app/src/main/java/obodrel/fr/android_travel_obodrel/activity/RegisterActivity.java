package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;

import obodrel.fr.android_travel_obodrel.R;
import obodrel.fr.android_travel_obodrel.sql.RegisterDBHelper;

public class RegisterActivity extends Activity{
    private EditText _nameText;
    private EditText _telText;
    private AutoCompleteTextView _locationText;
    private EditText _infoText;
    private CheckBox _hurry;
    private TextView _outcomeTf;
    private String [] _locations;
    private ArrayAdapter<String> _autoCompleteAdapter;
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS register(" +
            "request_id INTEGER PRIMARY KEY, request_name TEXT);";

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


        SharedPreferences myPreferences = getSharedPreferences("optionsPreferences",MODE_PRIVATE);
        boolean isRegisterChecked = myPreferences.getBoolean("isRegisterChecked",false);

        if(isRegisterChecked) {
            out += "\nRegistered in DB!";
            //readDatabase();
            out += " nbSame = "+registerInDatabase();
            //readDatabase();

            Thread wikiThread = new Thread() {
                public void run() {
                    try {
                        URL wikiURL = new URL("https://fr.wikipedia.org/w/api.php?action=query&" +
                                "format=json&prop=extracts&titles=Australie");
                        URLConnection connToURL = wikiURL.openConnection();
                        BufferedReader wikiBufferedReader = new BufferedReader(
                                new InputStreamReader(connToURL.getInputStream())
                        );
                        String line = "";

                        while((line=wikiBufferedReader.readLine()) != null) {
                            Log.i("RegisterActivity",line);
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    Log.i("RegisterActivity","End of search");
                }
            };
            wikiThread.start();
        }

        _outcomeTf.setText(out);
    }

    private void readDatabase() {
        RegisterDBHelper currDBHelper = new RegisterDBHelper(getApplicationContext());
        SQLiteDatabase myDB = currDBHelper.getReadableDatabase();

        String[] projection = {
                RegisterDBHelper.RegisterEntry._ID,
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_NAME,
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_TELEPHONE,
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_LOCATION,
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_INFORMATIONS
        };

        String sortOrder =
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_NAME + " DESC";

        Cursor myCursor = myDB.query(
                RegisterDBHelper.RegisterEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
        // We can also use execSQL to make our own SQL query
        while(myCursor.moveToNext()) {
            long itemId = myCursor.getLong(
                    myCursor.getColumnIndexOrThrow(RegisterDBHelper.RegisterEntry._ID));
            String name = myCursor.getString(
                    myCursor.getColumnIndexOrThrow(RegisterDBHelper.RegisterEntry.COLUMN_NAME_NAME));
            String tel = myCursor.getString(
                    myCursor.getColumnIndexOrThrow(RegisterDBHelper.RegisterEntry.COLUMN_NAME_TELEPHONE));
            String location = myCursor.getString(
                    myCursor.getColumnIndexOrThrow(RegisterDBHelper.RegisterEntry.COLUMN_NAME_LOCATION));
            String infos = myCursor.getString(
                    myCursor.getColumnIndexOrThrow(RegisterDBHelper.RegisterEntry.COLUMN_NAME_INFORMATIONS));

            Log.i("RegisterActivity", "readDB : itemID = "+itemId);
            Log.i("RegisterActivity", "readDB : name = "+name);
            Log.i("RegisterActivity", "readDB : tel = "+tel);
            Log.i("RegisterActivity", "readDB : location = "+location);
            Log.i("RegisterActivity", "readDB : infos = "+infos);
        }
        myCursor.close();

        myDB.close();
    }

    private int registerInDatabase() {
        String name = _nameText.getText().toString();
        String tel = _telText.getText().toString();
        String location = _locationText.getText().toString();
        String infos = _infoText.getText().toString();

        RegisterDBHelper currDBHelper = new RegisterDBHelper(getApplicationContext());
        SQLiteDatabase myDB = currDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(RegisterDBHelper.RegisterEntry.COLUMN_NAME_NAME, name);
        values.put(RegisterDBHelper.RegisterEntry.COLUMN_NAME_TELEPHONE, tel);
        values.put(RegisterDBHelper.RegisterEntry.COLUMN_NAME_LOCATION, location);
        values.put(RegisterDBHelper.RegisterEntry.COLUMN_NAME_INFORMATIONS, infos);

        myDB.insert(RegisterDBHelper.RegisterEntry.TABLE_NAME, null, values);

        Cursor myCursor = myDB.rawQuery("SELECT count(*) FROM " +
                RegisterDBHelper.RegisterEntry.TABLE_NAME + " WHERE " +
                RegisterDBHelper.RegisterEntry.COLUMN_NAME_NAME + "=?",new String[]{name});

        myCursor.moveToFirst();

        int countOfSameName = myCursor.getInt(0);

        myCursor.close();

        myDB.close();

        return countOfSameName;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mapMenuOption :
                Intent openMapIntent = new Intent(RegisterActivity.this,MapActivity.class);
                openMapIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(openMapIntent);
                return true;
            case R.id.registerOptionMenuOption :
                item.setChecked(!item.isChecked());
                SharedPreferences myPreferences = getSharedPreferences("optionsPreferences",MODE_PRIVATE);
                SharedPreferences.Editor preferencesEditor = myPreferences.edit();
                preferencesEditor.putBoolean("isRegisterChecked",item.isChecked());
                preferencesEditor.commit();
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SharedPreferences myPreferences = getSharedPreferences("optionsPreferences",MODE_PRIVATE);
        boolean isRegisterChecked = myPreferences.getBoolean("isRegisterChecked",false);
        getMenuInflater().inflate(R.menu.home_menu,menu);
        if(isRegisterChecked){
            Toast.makeText(RegisterActivity.this,getString(R.string.welcome_txt),Toast.LENGTH_SHORT).show();
        }
        menu.findItem(R.id.registerOptionMenuOption).setChecked(isRegisterChecked);
        return true;
    }
}