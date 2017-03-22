package fr.ib.travelandroidamine;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ib on 21/03/2017.
 */

public class PlaneActivity extends Activity {
    private long start;
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        //initialiser le start
        start=System.currentTimeMillis();
        setContentView(new PlaneActivity.MapView(this));
    }
    //déterminer le temps dans l'application plane
    @Override
    public void onBackPressed() {
        long end=System.currentTimeMillis();
        long t=end-start;
        Intent i=new Intent();

        i.putExtra("t",t);
        setResult(0,i);
        super.onBackPressed();

    }
    private class MapView extends View {
        public MapView(Context ctx) {
            super(ctx);
        }
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
            canvas.drawBitmap(b, 0, 0, null);
            Toast.makeText(PlaneActivity.this, "plane", Toast.LENGTH_LONG).show();
        }
    //lancer une recherche internet une fois que tu clique sur l'activité plane
        @Override
        public boolean onTouchEvent(MotionEvent e) {
            super.onTouchEvent(e);
            if (e.getActionMasked() == MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY, "A380");
                startActivity(i);
            }
            return true;
        }
    }
}