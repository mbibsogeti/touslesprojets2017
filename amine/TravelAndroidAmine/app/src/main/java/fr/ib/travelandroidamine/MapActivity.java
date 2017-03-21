package fr.ib.travelandroidamine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Amine on 20/03/2017.
 */

public class MapActivity extends Activity {
    //code pour demander un affichage
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
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
    }
}