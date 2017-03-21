package travel.jk.travelandroid;

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

public class MapActivity extends Activity {

    protected void onCreate(Bundle bundle) {
        /**
         * Méthode appelée lors de la création
         */
        super.onCreate(bundle);
        Log.i("Tag : MapActivity", "Message : je suis dans la méthode onCreate");
        // Affiche un texte éphémère au moment du lancement de l'application.
        // Cette affichage se fait dans l'objet en cours : le téléphone.
        Toast.makeText(this, "Bienvenue", Toast.LENGTH_LONG).show();
        // Ma vue est une instance de la classe MapView (voir ci-dessous)
        setContentView(new MapView(this));
    } // end onCreate method

    public class MapView extends View {

        public MapView(Context ctx) {
            super(ctx);
        } // end MapView method

        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.carte_oceanie);
            // (0,0) est le point en haut à gauche. L'image y est mise à partir de là.
            canvas.drawBitmap(bitmap, 0, 0, null);
        } // end onDraw method

        @Override
        // boolean : true si on s'est servi de l'événement, false sinon
        public boolean onTouchEvent(MotionEvent event) {
            // Création d'une nouvelle intention Intent(objet en cours, destination)
            // MapActivity.this : objet en cours ;
            Intent intention = new Intent(MapActivity.this, SubmapsActivity.class);
            // Ne lancer l'activité que lors de l'appui de la souris
            // Sans ça, l'application considère 2 ouvertures : une à l'appui, l'autre au relâchement
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                // Zone de l'image : ouest ou est
                int area;
                if(event.getX() < getWidth() / 2) {
                    area = 1;
                } // end if
                else {
                    area = 2;
                }
                // Ajout d'élément dans l'intention. Syntaxe dictionnaire.
                intention.putExtra("zone", area);
                startActivity(intention);
            } // end if
            return true;
        } // end onTouchEvent method
    } // end MapView class
} // end Mapactivity class