package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import obodrel.fr.android_travel_obodrel.R;

public class MapActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MapView(this));
        Log.i("MapActivity", "onCreate, end of fct");
        Toast.makeText(MapActivity.this,getString(R.string.welcome_txt),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mapMenuOption :
                Intent openMapIntent = new Intent(MapActivity.this,MapActivity.class);
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
        getMenuInflater().inflate(R.menu.home_menu,menu);
        SharedPreferences myPreferences = getSharedPreferences("optionsPreferences",MODE_PRIVATE);
        boolean isRegisterChecked = myPreferences.getBoolean("isRegisterChecked",false);
        menu.findItem(R.id.registerOptionMenuOption).setChecked(isRegisterChecked);
        return true;
    }


    private class MapView extends View {

        public MapView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent launchSubActivityIntent = new Intent(MapActivity.this,SubMapsActivity.class);
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                int zone = -1;
                if(event.getX() < getWidth()/2) {
                    zone = 1;
                } else {
                    zone = 2;
                }
                if(zone != -1) {
                    launchSubActivityIntent.putExtra("zone", zone);
                    startActivity(launchSubActivityIntent);
                }
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap imgBmp = BitmapFactory.decodeResource(getResources(),
                    R.drawable.obodrel_img_ocaenia_full_map);
            canvas.drawBitmap(imgBmp, new Rect(0,0,imgBmp.getWidth(),
                    imgBmp.getHeight()),new Rect(0,0,this.getWidth(),this.getHeight()),null);
        }
    }
}
