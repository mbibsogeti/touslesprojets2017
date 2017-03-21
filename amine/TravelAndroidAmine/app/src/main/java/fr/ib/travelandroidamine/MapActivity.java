package fr.ib.travelandroidamine;

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
 * Created by Amine on 20/03/2017.
 */

public class MapActivity extends Activity {
    //code pour demander un affichage
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        //log debug: je viens de passé par le onCreate
        Log.i("MapActivity","onCreate");
        //Toast affichage particulier d'un message de bienvenue à l'ouverture de l'application
        Toast.makeText(this,"Bienvenue",Toast.LENGTH_LONG).show();
        //indiquer la vue principale de notre activité
        setContentView(new MapView(this));
    }
    private class MapView extends View {
        //constructeur dans la fille identique à celui de la mère
        public MapView(Context ctx){
            super(ctx);
        }
        //affichage de carte.jpg sur notre écran appli
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Bitmap b=BitmapFactory.decodeResource(getResources(),R.drawable.carte);
            canvas.drawBitmap(b,0,0,null);
        }
        public boolean onTouchEvent(MotionEvent e){
            //le test pour éviter le rebond et l'activation de deux évenements
            if(e.getActionMasked()==MotionEvent.ACTION_DOWN) {
                //déterminer le chemin de l'objet en cours à l'objet qu'on veut aller
                Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                //localisation de l'appui sur l'écran
                int area;
                if(e.getX()<getWidth()/2)
                    area=1;
                else
                    area=2;
                //ajoute à i la donnée area
                i.putExtra("area",area);
                startActivity(i);
            }
            return true;
        }
    }
}