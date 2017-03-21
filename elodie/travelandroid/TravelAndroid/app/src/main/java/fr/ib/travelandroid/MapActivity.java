package fr.ib.travelandroid;

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
 * Created by ib_Elodie on 20/03/2017.
 * Classe MapActivity appelée automatiquement car déclarée dans AndroidManifest.xml
 *
 * Constructeur
 * appel du onCreate
 * appel de setContentView - ma vue = instance de ma propre classe - this pour le context
 *
 * De plus, on réagit a un autre évenement. A chaque fois que la vue est utilisée, la méthode onDraw est appelée.
 */

public class MapActivity extends Activity{

    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        Log.i("MapActivity","onCreate");
        Toast.makeText(this,"Bienvenue",Toast.LENGTH_LONG).show();
        setContentView(new MapView(this));
    }


    //Classe interne pour la vue
    private class MapView extends View{
        public MapView (Context ctx){
            super(ctx);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.oceanie);
            canvas.drawBitmap(b,0,0,null);
            super.onDraw(canvas);
        }


        //méthode onTouchEvent pour appeler l'activité SubmapsActivity dès que je clique - Création d'une intention sous forme clé = Area + valeur:1 ou 2
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if(event.getActionMasked()==MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                int area;
                if(event.getX()<getWidth()/2) area=1;
                else area = 2;
                i.putExtra("area",area);//conteneur temporaire
                startActivity(i);
            }
            return true;
        }
    }
}
