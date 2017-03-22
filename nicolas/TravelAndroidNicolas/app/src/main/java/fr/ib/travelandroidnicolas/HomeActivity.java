package fr.ib.travelandroidnicolas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ib on 22/03/2017.
 */

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle S) {
        super.onCreate(S);
        Log.i("MapActivity","onCreate");



        setContentView(R.layout.home);
    }




}
