package fr.ib.travelandroid;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HomeActivity extends Activity implements OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);

        View v =findViewById(R.id.news);
        TextView tv=(TextView) v;
        String s="";
        try{
            InputStream is = getAssets().open("news.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String l="";
            while ((l=br.readLine())!=null) s+=l;

            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        tv.setText(s);


        Button btMap = (Button)findViewById(R.id.oceanie);
        btMap.setOnClickListener(this);

        Button b = (Button)findViewById(R.id.register);
        b.setOnClickListener(new OnClickListener() {
            @Override
            //Classe anonyme
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RegisterActivity.class));
            }
        });
    }

    public void onClick(View v){
        startActivity(new Intent(this, MapActivity.class));
    }
}
