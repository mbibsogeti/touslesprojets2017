package fr.ib.travelandroidbelto;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PlaneView(this));
        start=System.currentTimeMillis();
        // affichage d'une icone pour une activité (déjà declaré dans (activity android icon) du fichier XML)
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onBackPressed() {
        long end = System.currentTimeMillis();
        long t = end - start;
        Intent i = new Intent();
        i.putExtra("timehaha", t);
        setResult(0, i);
        super.onBackPressed();
    }

    private class PlaneView extends View {

        public PlaneView(Context ctx){
            super(ctx);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            // afficher une image différente en fonction du click.
            int area=getIntent().getIntExtra("area", 1);
            {Bitmap b= BitmapFactory.decodeResource(getResources(),R.drawable.plane);
                canvas.drawBitmap(b,0,0,null);}
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent i= new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY,"Avion A320");
            startActivity(i);
            return super.onTouchEvent(event);
        }
    }
}
