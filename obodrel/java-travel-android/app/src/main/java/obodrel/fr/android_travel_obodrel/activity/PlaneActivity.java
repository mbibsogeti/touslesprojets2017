package obodrel.fr.android_travel_obodrel.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import obodrel.fr.android_travel_obodrel.R;

public class PlaneActivity extends Activity {
    private long _startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PlaneView(this));
        _startTime = System.currentTimeMillis();
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onBackPressed() {
        long endTime;
        long timeElapsed;
        Intent retIntention = new Intent();

        endTime = System.currentTimeMillis();
        timeElapsed = endTime - _startTime;

        retIntention.putExtra("timeElapsed",timeElapsed);
        setResult(0,retIntention);

        super.onBackPressed();
    }

    private class PlaneView extends View {

        public PlaneView(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent launchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
            launchIntent.putExtra(SearchManager.QUERY,"concorde");
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                startActivity(launchIntent);
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap imgBmp = BitmapFactory.decodeResource(getResources(),
                    R.drawable.obodrel_img_plane);
            canvas.drawBitmap(imgBmp, new Rect(0,0,imgBmp.getWidth(),
                    imgBmp.getHeight()),new Rect(0,0,this.getWidth(),this.getHeight()),null);
        }
    }
}
