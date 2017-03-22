package fr.ib.travelandroidnicolas;


import android.app.Activity;
import android.app.SearchManager;
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

public class Planeactivity extends Activity {
    private long start;

    protected void onCreate(Bundle S) {

        super.onCreate(S);
        Log.i("Planeactivity", "onCreate");
        //Toast.makeText(this, "avion", Toast.LENGTH_LONG).show();
        //initialise le start
        start = System.currentTimeMillis();

        setContentView(new Planeactivity.MapView(this));
    }

    @Override

    public void onBackPressed() {
        long end = System.currentTimeMillis();
        long t = end - start;
        Intent i = new Intent();
        //Toast.makeText(this,getString(R.string.daywarning,1), Toast.LENGTH_LONG).show();

        i.putExtra("t", t);
        setResult(0, i);
        super.onBackPressed();

    }

    private class MapView extends View {
        public MapView(Context ctx) {

            super(ctx);


        }


        @Override
        protected void onDraw(Canvas canvas) {

            Log.i("Planeactivity", "onDraw");
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.avion);
            canvas.drawBitmap(b, 0, 0, null);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            i.putExtra(SearchManager.QUERY, "facebook");
            startActivity(i);

            return super.onTouchEvent(event);
        }
    }
}












