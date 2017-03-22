package travel.jk.travelandroid;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Julian on 21/03/2017.
 */

public class PlaneActivity extends Activity {

    private long start;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        // Affiche un texte éphémère au moment du lancement de l'application.
        // Cette affichage se fait dans l'objet en cours : le téléphone.
        // Ma vue est une instance de la classe MapView (voir ci-dessous)
        setContentView(new PlaneActivity.MapView(this));
        start = System.currentTimeMillis();
    } // end onCreate method

    @Override
    public void onBackPressed() {
        // end n'est utilisée qu'ici donc variable locale.
        // En revanche, start est utilisé dans 2 méthodes différentes donc passage en attribut.
        long end = System.currentTimeMillis();
        // Temps écoulé entre le moment où j'appuie sur back et le moment d'arrivée
        long t = end - start;
        Intent intention = new Intent();
        intention.putExtra("temps", t);
        // setResult : voici le résultat de cette activité
        // Ici, le résultat est une intention avec un entier valant 0 dedans
        setResult(0, intention);
        // À mettre après tout le reste car c'est cet appel au constructeur qui ferme l'activité
        super.onBackPressed();
    }

    public class MapView extends View {

        public MapView(Context ctx) {
            super(ctx);
        } // end MapView method

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avion);
            canvas.drawBitmap(bitmap, 0, 0, null);
        } // end onDraw method@Override

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            // Instanciation d'une nouvelle intention qui fait une recherche sur internet
            Intent intention = new Intent(Intent.ACTION_WEB_SEARCH);
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                intention.putExtra(SearchManager.QUERY, "concorde");
                startActivity(intention);
            }
            return true;
        }
    } // end MapView class
}