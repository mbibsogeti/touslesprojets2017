package fr.ib.travelandroidma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ib on 20/03/2017.
 */

public class MapActivity extends Activity {

    // On redéfinit une méthode de la mère :
    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        // ***Faire un log ("tag","message") :
        Log.i("MapActivity*#*","onCreate*#*");
        // ***Faire un 'toast' : façon la plus rapide d'afficher du texte
        Toast.makeText(this,"Bienvenue mon cher !",Toast.LENGTH_LONG).show();
        setContentView(new MapView(this));
    }


    private class MapView extends View {
        public MapView(Context ctx) {
            super (ctx);
        }
        // ***On crée une fonction qui affichera ce que l'on veut :
        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b= BitmapFactory.decodeResource(
                    // ***'R' désigne un élément que l'on utilisera souvent
                    getResources(), R.drawable.map);
            canvas.drawBitmap(b,0,0,null);
        }

        @Override
        // ***On indique à l'appli que l'on veut un évènement uniquement au moment où
        // le user touche l'écran (onTouchEvent).
        public boolean onTouchEvent(MotionEvent e) {
            // ***La condition permet de garantir que l'évènement ne se déclenche qu'en
            // cas d'appui sur l'écran (constante 'ACTION_DOWN' de la classe 'MotionEvent')
            // L'objet 'Intent i' contient les données concernant l'endroit d'où l'on vient et
            // celui où l'on va. On peut compléter cette 'Intent' avec des données sups.
            if (e.getActionMasked()==MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                // Détection de l'endroit où l'on appuie sur l'écran :
                int area;
                if (e.getX()<getWidth()/2) {
                    area = 1;
                    Log.i("Map1","area1");
                } else {
                    area = 2;
                    Log.i("Map1","area2");
                }
                i.putExtra("area",area);
                // Exécution de l'activité.
                startActivity(i);
            }
            return true;
        }
    }
}