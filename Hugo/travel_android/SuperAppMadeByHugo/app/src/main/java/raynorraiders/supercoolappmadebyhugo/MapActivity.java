package raynorraiders.supercoolappmadebyhugo;

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

    // appel au constructeur de l'app. L'app (Context) et la vue (MapView) sont reliés les uns aux autres dès le début
    public void onCreate(Bundle s) {
        super.onCreate(s);
        // affiche un texte au démarrage de l'app. this fait référence à cette activité
//        Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show();
        // appel à un texte défini dans strings.xml sous le label text_app_name
        Toast.makeText(this, getString(R.string.text_app_name), Toast.LENGTH_LONG).show();
        // appel à l'app depuis la vue (MapView(this))
        setContentView(new MapView(this));
        Log.i("MapActivity", "AFK");
    }

    // affichage de l'app sur l'émulateur
    private class MapView extends View {
        public MapView(Context ctx) {
            // appel à la vue depuis l'app (super(ctx))
            super(ctx);
        }

        // pour afficher la carte sur l'émulateur
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.mapa_oceania_capitales);
            canvas.drawBitmap(b, 0, 0, null);
        }

        // démarrage d'une activité lorsque on réalise une action.
        // Ici on va de MapActivitity.this vers SubmapsActivity.class lorsque'on tappe sur la carte MapView
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                int area;
                if (event.getX() < getWidth() / 2) {
                    area = 1;
                } else {
                    area = 2;
                }
                i.putExtra("area", area);
                startActivity(i);
            }
            return true;
        }
    }
}