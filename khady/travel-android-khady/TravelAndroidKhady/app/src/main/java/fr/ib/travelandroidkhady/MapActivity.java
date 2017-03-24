package fr.ib.travelandroidkhady;

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
 * Created by ib on 20/03/2017.
 */

public class MapActivity extends Activity {
    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        Log.i("MapActivity","onCreate");
        Toast.makeText(this, "Bienvenue", Toast.LENGTH_LONG).show();//Toast.LENGTH_LONG.show()affiche "Bienvenue" sur l'émulateur pdt 5s
        setContentView(new MapView(this));
    }

    private class MapView extends View{
        public MapView(Context ctx){
            super(ctx);
    }
     @Override
     protected void onDraw(Canvas canvas){

          Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.oceanie);
          canvas.drawBitmap(b,0,0,null);

        }

        @Override
        public boolean onTouchEvent(MotionEvent e){
            if(e.getActionMasked()== MotionEvent.ACTION_DOWN){//ACTION_DOWN veut dire quand on appuie(vers le bas)avecla souris et c'est une constante
            Intent i = new Intent(MapActivity.this, SubmapsActivity.class);
                int area;
                if(e.getX()< getWidth()/2)
                    area=1;
                else
                    area=2;
                i.putExtra("area",area);
            startActivity(i);
            }
            return true;
        }



    }
}


