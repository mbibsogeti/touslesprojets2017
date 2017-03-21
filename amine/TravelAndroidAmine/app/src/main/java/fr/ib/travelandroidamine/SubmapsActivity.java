package fr.ib.travelandroidamine;

import android.app.Activity;
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

public class SubmapsActivity extends Activity {
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        //Toast.makeText(this,"Ceci est un pseudo Zoom",Toast.LENGTH_LONG).show();
        setContentView(new SubmapsActivity.MapView(this));
    }
    //afficher un toast quand on met plus de deux secondes dans Plane pour revenir en arrière
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getLongExtra("t",0)>2000)
            Toast.makeText(SubmapsActivity.this,"data",Toast.LENGTH_LONG).show();
    }

    private class MapView extends View {
        public MapView(Context ctx) {
            super(ctx);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //le 1 par défaut si pas de donnée il affiche la première image
            int area = getIntent().getIntExtra("area", 1);
            //test du area pour détreminer le côté de l'appui sur l'écran
            if (area == 1) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.west);
                canvas.drawBitmap(b, 0, 0, null);
                Toast.makeText(SubmapsActivity.this, "west", Toast.LENGTH_LONG).show();
            } else if (area == 2) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.east);
                canvas.drawBitmap(b, 0, 0, null);
                Toast.makeText(SubmapsActivity.this, "east", Toast.LENGTH_LONG).show();
            }
        }

        //affichage d'avion
        public boolean onTouchEvent(MotionEvent e) {
            if (e.getActionMasked() == MotionEvent.ACTION_DOWN) {
                //déterminer le chemin de l'objet en cours à l'objet qu'on veut aller
                Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);
                //startActivity(i);
                // au moment de l'appel on compte bien avoir un résultat
                startActivityForResult(i,0);
            }
            return true;
        }
    }
}