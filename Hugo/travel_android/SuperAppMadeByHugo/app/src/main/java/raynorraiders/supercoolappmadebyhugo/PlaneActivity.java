package raynorraiders.supercoolappmadebyhugo;

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
import android.widget.Toast;

public class PlaneActivity extends Activity {

    private long start;

    public void onCreate(Bundle s) {
        super.onCreate(s);
        Toast.makeText(this, "Viaje en Caracal!!", Toast.LENGTH_LONG).show();
        setContentView(new PlaneActivity.MapView(this));
        start = System.currentTimeMillis();
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onBackPressed() {
        long end = System.currentTimeMillis();
        long deltaT = end - start;
        Intent i = new Intent();
        i.putExtra("time", deltaT);
        setResult(0, i);
        super.onBackPressed();
    }

    private class MapView extends View {
        public MapView(Context ctx) {
            super(ctx);
        }

        protected void onDraw(Canvas canvas) {
            // R: classe qui contient tout le contenu du dossier res, où tout est static.
            // La définition est dans app/build/generated/source/r/debug/myappname/R.java
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.eve_ship);
            canvas.drawBitmap(b, 0, 0, null);
        }

        // initier une recherche internet lorsqu'on tape sur l'image du caracal
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
                i.putExtra(SearchManager.QUERY, "caracal eve");
                startActivity(i);
            }
            return true;
        }
    }
}
