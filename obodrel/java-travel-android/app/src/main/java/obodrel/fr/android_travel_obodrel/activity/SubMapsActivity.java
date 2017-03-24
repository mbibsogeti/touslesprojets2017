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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import obodrel.fr.android_travel_obodrel.R;

public class SubMapsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SubMapsActivity.SubMapsView(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == resultCode) {
            long timeElapsed = data.getLongExtra("timeElapsed", -1);
            if(timeElapsed != -1 && timeElapsed > 500) {
                float timeSec = timeElapsed / 1000f;
                String second = getResources().getQuantityString(R.plurals.second, (int) timeSec);
                String textToDisplay =  getString(R.string.time_elapsed_plane,timeSec,second);
                if(timeSec < 10) {
                    String [] numberInLetters = getResources().getStringArray(R.array.number);
                    textToDisplay =  getString(
                            R.string.time_elapsed_plane_letter,numberInLetters[(int)timeSec],second);
                }
                Toast.makeText(SubMapsActivity.this,textToDisplay,Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch(item.getItemId()) {
            case R.id.mapMenuOption :
                Intent openMapIntent = new Intent(SubMapsActivity.this,MapActivity.class);
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

    private class SubMapsView extends View {

        public SubMapsView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent launchSubActivityIntent = new Intent(SubMapsActivity.this,PlaneActivity.class);
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                startActivityForResult(launchSubActivityIntent,0);
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap imgBmp;
            int zone = -1;
            zone = getIntent().getIntExtra("zone",-1);
            if(zone != -1) {
                if (zone == 1) {
                    imgBmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.obodrel_img_ocaenia_west_map);
                    //Toast.makeText(SubMapsActivity.this, "Open Sub Map West",
                            //Toast.LENGTH_SHORT).show();
                } else {
                    imgBmp = BitmapFactory.decodeResource(getResources(),
                            R.drawable.obodrel_img_ocaenia_east_map);
                    setTitle(R.string.activity_east);
                    //Toast.makeText(SubMapsActivity.this, "Open Sub Map East",
                            //Toast.LENGTH_SHORT).show();
                }
                canvas.drawBitmap(imgBmp, new Rect(0, 0, imgBmp.getWidth(), imgBmp.getHeight()),
                        new Rect(0, 0, this.getWidth(), this.getHeight()), null);
            }
        }
    }
}
