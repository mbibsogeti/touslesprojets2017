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


public class Submaps extends Activity {
    @Override
    protected void onCreate(Bundle S) {
        super.onCreate(S);
        Log.i("Submaps", "onCreate");
        //Toast.makeText(this,getString(R.string.toast),Toast.LENGTH_LONG).show();


        setContentView(new SubmapsView(this));
        getActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //le getlong extra vine de la classe planeactivity et du calcul du temps qu'on met a apuyer sur backspace, le paramètre, 0 n'sest pas utilisé ic

       if (data.getLongExtra("t",0)>2000)
           Toast.makeText(this,getString(R.string.daywarning,data.getLongExtra("t",0)/1000,getResources().getQuantityString(R.plurals.second,(int)data.getLongExtra("t",0))),Toast.LENGTH_LONG).show();
    }
    private class SubmapsView extends View {
        public SubmapsView(Context ctx) {

            super(ctx);


        }
        @Override
        protected void onDraw(Canvas canvas) {
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.oceaniest);
            canvas.drawBitmap(b, 0, 0, null);
            super.onDraw(canvas);
        }

        @Override
        public boolean onTouchEvent(MotionEvent e) {
            Intent i = new Intent(Submaps.this, Planeactivity.class);
            startActivityForResult(i, 0);

            return true;
        }
    }
}








