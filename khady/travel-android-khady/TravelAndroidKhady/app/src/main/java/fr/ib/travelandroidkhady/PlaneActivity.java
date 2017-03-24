package fr.ib.travelandroidkhady;

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

/**
 * Created by ib on 21/03/2017.
 */

public class PlaneActivity extends Activity {
    private long start;


    protected void onCreate(Bundle s) {
        start = System.currentTimeMillis();
        super.onCreate(s);
        setContentView(new PlaneView(this));
    }

    public void onBackPressed() {// la f° BackPressed() permet de revenir à l'affichage précédent
        long end = System.currentTimeMillis();
        long t = end - start;
        Intent i = new Intent();
        i.putExtra("t", t);
        setResult(0, i);
        super.onBackPressed();
    }

    private class PlaneView extends View {
        public PlaneView(Context ctx) {
            super(ctx);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
            canvas.drawBitmap(b, 0, 0, null);

        }


        @Override
        public boolean onTouchEvent(MotionEvent e) {

            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);//lance une intention qui fait une recherche sur l'avion quand on clique sur l'avion
            i.putExtra(SearchManager.QUERY, "concorde");
            startActivity(i);

            return true;


        }

    }

}