package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import obodrel.fr.android_travel_obodrel.R;

public class HomeActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        TextView newsTextView = (TextView) findViewById(R.id.botNewsTextView);
        newsTextView.setText("Pas de news");

        Button openMap = (Button) findViewById(R.id.openMapBtn);

        /*openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openMapIntent = new Intent(HomeActivity.this,MapActivity.class);
                startActivity(openMapIntent);
            }
        });*/
        //openMap.setOnClickListener(this);
        //Third method in use, directly defined in the layout
        String newsTxt = "";

        try {
            InputStream newsIS = (getAssets().open("news.txt"));
            BufferedReader newsBF = new BufferedReader(new InputStreamReader(newsIS));
            String line = "";
            while ((line = newsBF.readLine()) != null) {
                newsTxt += line;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        newsTextView.setText(newsTxt);
    }

    @Override
    public void onClick(View v) {
        Intent openMapIntent = new Intent(HomeActivity.this,MapActivity.class);
        startActivity(openMapIntent);
    }
    public void goToRegister(View v) {
        Intent openRegisterIntent = new Intent(HomeActivity.this,RegisterActivity.class);
        startActivity(openRegisterIntent);
    }
}