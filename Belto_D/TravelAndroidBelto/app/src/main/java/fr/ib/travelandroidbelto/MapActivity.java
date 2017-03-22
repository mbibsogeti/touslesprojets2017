package fr.ib.travelandroidbelto;

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
//* on lance l'application après avoir configurer le fichier AndroidManifest.xml, cette classe sera appeler automatiquement comme on l'a definie comme classe de départ!
public class MapActivity extends Activity {
    // on redéfinie la mère
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ma vue principale contient ma classe MapView
        // un fichier message log qui sera affiché dans la console
        // le premier(MapActivity= la classe, Le second(Oncreate)= le message avec des infos)
        Log.i("MapActivity","onCreatehahahaha");
        Toast.makeText(this,"Bienvenue sur mon application, je suis Belto", Toast.LENGTH_LONG).show();
        setContentView(new MapView(this));
    }
    // la class MapView hérite de view et redefinie la mère
    private class MapView extends View {
        //
        //Context devient un paramètre de l'instance de class Mapview
        public MapView(Context ctx){
           //*j'appelle le constructeur de la mère
            super(ctx);
        }
// pour afficher l'image
        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b= BitmapFactory.decodeResource(getResources(),R.drawable.oceanie);
            // on l'affiche à x=0 et y=0
            canvas.drawBitmap(b,0,0,null);
        }
        public boolean onTouchEvent(MotionEvent e){
            // ne faire ceci que quand on click et pas quand on relache la souris
            if (e.getActionMasked() == MotionEvent.ACTION_DOWN) {
                //aller chercher l'activity et la lancer
                // pour le second, on met la class
                Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                // récupérer la position du click
                int area;
                if(e.getX()<getWidth()/2)
                    area=1;
                else
                    area=2;
                // on recupère la valeur et on le met dans dictionnaire ("clé", valeur);
                i.putExtra("area",area);
                startActivity(i);
            }
            return true;
        }
    }
}
