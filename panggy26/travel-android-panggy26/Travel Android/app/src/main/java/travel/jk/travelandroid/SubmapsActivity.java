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

/**
 * Created by ib on 21/03/2017.
 */

public class SubmapsActivity extends Activity {

    protected void onCreate(Bundle bundle) {
        /**
         * Méthode appelée lors de la création
         */
        super.onCreate(bundle);
        Log.i("Tag : SubmapsActivity", "Message : je suis dans la méthode onCreate");
        // Affiche un texte éphémère au moment du lancement de l'application.
        // Cette affichage se fait dans l'objet en cours : le téléphone.
        Toast.makeText(this, "ZOOM !", Toast.LENGTH_LONG).show();
        // Ma vue est une instance de la classe MapView (voir ci-dessous)
        setContentView(new SubmapsActivity.MapView(this));
    } // end onCreate method

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.getLongExtra("temps", 0) > 2000) {
            Toast.makeText(this, "Avez-vous pensé à la ligne de changement d'heure ?", Toast.LENGTH_LONG).show();
        }
    }

    public class MapView extends View {

        public MapView(Context ctx) {
            super(ctx);
        } // end MapView method

        @Override
        protected void onDraw(Canvas canvas) {
            // 1 : donnée par défaut pour zone si jamais il ne la trouve pas
            int area = getIntent().getIntExtra("zone", 1);
            if(area == 1) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.oceanie_ouest);
                canvas.drawBitmap(bitmap, 0, 0, null);
            }
            if(area == 2) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.oceanie_est);
                canvas.drawBitmap(bitmap, 0, 0, null);
            }
        } // end onDraw method

        @Override
        // boolean : true si on s'est servi de l'événement, false sinon
        public boolean onTouchEvent(MotionEvent event) {
            Intent intention = new Intent(SubmapsActivity.this, PlaneActivity.class);
            // Ne lancer l'activité que lors de l'appui de la souris
            // Sans ça, l'application considère 2 ouvertures : une à l'appui, l'autre au relâchement
            if(event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                // Commencement d'une activité qui renverra un résultat (ici, un entier)
                startActivityForResult(intention, 0);
            }
            return true;
        } // end onTouchEvent method
    } // end MapView class
}