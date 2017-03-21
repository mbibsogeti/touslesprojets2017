package fr.ib.travelandroidma;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ib on 21/03/2017.
 */

public class PlaneActivity extends Activity {

    private long start;

    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        start=System.currentTimeMillis();
        setContentView(new PlaneView(this));
    }

    @Override
    public void onBackPressed() {
        long end = System.currentTimeMillis();
        long t = end - start;
        Intent i = new Intent();
        i.putExtra("t",t);
        // Renvoie le résultat de l'activité : une 'Intent', systématiquement.
        setResult(0,i);
        // A la fin car arrête l'activité.
        super.onBackPressed();
    }

    private class PlaneView extends View {
        public PlaneView(Context ctx) {
            super (ctx);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(
                    getResources(), R.drawable.plane);
            canvas.drawBitmap(b, 0, 0, null);
        }
        @Override
        public boolean onTouchEvent(MotionEvent e) {
            // Déclenche l'ouverture d'une fenêtre de recherche web
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY,"");
            startActivity(i);
            return true;
        }
    }
}