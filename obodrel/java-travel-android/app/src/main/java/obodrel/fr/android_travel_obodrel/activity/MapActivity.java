package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
    }
    private class MapView extends View {

        public MapView(Context context) {
            super(context);
        }
    }
}
