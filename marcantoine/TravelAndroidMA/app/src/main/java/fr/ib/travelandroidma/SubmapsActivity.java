package fr.ib.travelandroidma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ib on 21/03/2017.
 */

public class SubmapsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle s) {
        super.onCreate(s);
        setContentView(new SubmapsView(this));
    }

    private class SubmapsView extends View {
        public SubmapsView(Context ctx) {
            super (ctx);
        }
        //On crée une fonction qui affichera ce que l'on veut :
        @Override
        protected void onDraw(Canvas canvas) {
            int area = getIntent().getIntExtra("area",1);
            Bitmap b1= BitmapFactory.decodeResource(
                    getResources(), R.drawable.westmap);
            Bitmap b2= BitmapFactory.decodeResource(
                    getResources(), R.drawable.eastmap);
            if (area == 1) {
                canvas.drawBitmap(b1,0,0,null);
            } else {
                canvas.drawBitmap(b2,0,0,null);
            }
        }
        @Override
        public boolean onTouchEvent(MotionEvent e) {
            if (e.getActionMasked()==MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);
                startActivityForResult(i,0);
            }
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data.getLongExtra("t",0)>100) {
            int temps = (int) data.getLongExtra("t",0)/1000;
            Toast.makeText(this, getString(
                    R.string.backfromplane_name,temps,getResources().getQuantityString(R.plurals.second,temps)
            ), Toast.LENGTH_LONG).show();
        }
    }
}