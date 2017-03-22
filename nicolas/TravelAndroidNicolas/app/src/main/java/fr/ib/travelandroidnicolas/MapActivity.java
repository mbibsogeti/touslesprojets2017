package fr.ib.travelandroidnicolas;

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
@Override
    protected void onCreate(Bundle S) {
        super.onCreate(S);
        Log.i("MapActivity","onCreate");



        setContentView(new MapView(this));
    }

    private class MapView extends View {
        public MapView(Context ctx) {

            super(ctx);


        }
@Override
    protected void onDraw(Canvas canvas) {

            Log.i("MapActivity","onDraw");
            Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.carte_oceanie);
            canvas.drawBitmap(b, 0, 0, null);
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        Intent i = new Intent(MapActivity.this, Submaps.class);
        startActivityForResult(i, 0);

        return true;
    }

}







