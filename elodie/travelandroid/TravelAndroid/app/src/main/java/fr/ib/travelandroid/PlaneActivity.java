package fr.ib.travelandroid;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class PlaneActivity extends Activity{
    private long start;
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(new PlaneActivity.MapView(this));

        //initialisation de la variable avec un décompte depuis les années 70 lors de la création de la vue
        start= System.currentTimeMillis();
    }

    @Override
    public void onBackPressed() {
        long end = System.currentTimeMillis();
        long t = end-start;

        //intention pour action de conteneur - intention vide
        Intent i = new Intent();
        i.putExtra("t",t);

        //Etape 2: Intention est le resultat de mon activité qui produit un nombre et un long - se réalise lorsque que l'on revient en arrière
        setResult(0,i);
        super.onBackPressed();
    }

    //Classe interne pour la vue
    private class MapView extends View {
        public MapView(Context ctx) {
            super(ctx);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
            canvas.drawBitmap(b, 0, 0, null);
            super.onDraw(canvas);
        }

        //Intention floue - va chercher une activité de recherche -  si plusieurs activités mènent vers la même ACTION, l'appli demande alors de choisir l'activité que l'on veut
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY,"A 380");
            startActivity(i);

            return true;
        }
    }
}
