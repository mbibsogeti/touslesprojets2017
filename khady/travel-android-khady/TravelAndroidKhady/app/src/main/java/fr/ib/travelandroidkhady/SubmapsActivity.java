package fr.ib.travelandroidkhady;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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

public class SubmapsActivity extends Activity {
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(new SubmapsView(this));
        getActionBar().setDisplayShowHomeEnabled(true);//cette ligne de code permet d'afficher notre icone dans l'affichage de SubmapsActivity
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        long ms = data.getLongExtra("t",0);
        if(ms>2000){// à l'affichage, au bout de 2s on peut cliquer sur le bouton retour et on revient sur la page d'avant
            Toast.makeText(this, getString(R.string.day_warning, ms/1000,getResources().getQuantityString(R.plurals.second,(int)ms/1000)),Toast.LENGTH_LONG).show();


        }
    }

    private class SubmapsView extends View {
        public SubmapsView(Context ctx) {
            super(ctx);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            int area = getIntent().getIntExtra("area", 1);
            if (area == 1) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.oceaniewest);
                canvas.drawBitmap(b, 0, 0, null);

            } else {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.oceanieeast);
                canvas.drawBitmap(b, 0, 0, null);
            }

        }


        @Override
        public boolean onTouchEvent(MotionEvent e) {
            if (e.getActionMasked() == MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);

                startActivityForResult(i,0);
            }
            return true;

        }

    }
}
