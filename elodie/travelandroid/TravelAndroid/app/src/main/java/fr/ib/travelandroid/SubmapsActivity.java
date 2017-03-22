package fr.ib.travelandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ib on 21/03/2017.
 */

public class SubmapsActivity extends Activity{

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(new SubmapsActivity.MapView(this));
    }

    //Etape 3: Se servir du résultat de l'activité di onTouchEvent
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Si on reste plus de 2secondes et que l'on revient en arrière le TOAST apparait
        if(data.getLongExtra("t",0)>2000) Toast.makeText(SubmapsActivity.this,"quelques secondes plus tard ...",Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, data);
    }

    //Classe interne pour la vue
    private class MapView extends View {
        public MapView (Context ctx){
            super(ctx);
        }

        //Dans la méthode onDrawn getIntent pour faire référence à l'intention de MapActivity et getIntExtra pour avoir la valeur de la clé ou la modifier
        @Override
        protected void onDraw(Canvas canvas) {
            int area = getIntent().getIntExtra("area",1);

            if (area == 2) {
                Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.oceanie_est);
                canvas.drawBitmap(b,0,0,null);
            }
            else{
                Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.oceanie_ouest);
                canvas.drawBitmap(b,0,0,null);
            }
            super.onDraw(canvas);
        }

       //méthode onTouchEvent pour appeler l'activité PlaneActivity dès que je clique -
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);

                //Etape 1: je démare une activité et se prépare à recevoir un résultat
                startActivityForResult(i, 0);
            }
            return true;
        }
    }
}
