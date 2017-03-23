package fr.ib.travelandroidbelto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import static android.R.attr.data;

/**
 * Created by ib on 21/03/2017.
 */

public class SubmapsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(new SubmapsView(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data.getLongExtra("timehaha",0)>500)
            Toast.makeText(this,"Super Avion", Toast.LENGTH_LONG).show();
        //Une façon de plus pour l'internationalisation et l'affichage de texte, nombre en seconde(c'etait en miniseconde au départ)
        // on ajoute un second paramètre(getString(R...,data.get..../1000,....)  {avec data.get.../1000 comme premier paramètre et getResources.... comme second paramètre)
        Toast.makeText(this,getString(R.string.day_warning,data.getLongExtra("timehaha",0)/1000,getResources()
                .getQuantityString(R.plurals.second,(int)data
                        .getLongExtra("timehaha",0))), Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, data);
    }
    private class SubmapsView extends View {

        public SubmapsView(Context ctx){
            super(ctx);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            // afficher une image différente en fonction du click.
            int area=getIntent().getIntExtra("area", 1);
            if (area==1)
            {Bitmap b= BitmapFactory.decodeResource(getResources(),R.drawable.west);
            canvas.drawBitmap(b,0,0,null);}
            else
            {Bitmap b= BitmapFactory.decodeResource(getResources(),R.drawable.est);
            canvas.drawBitmap(b,0,0,null);}
        }
    }
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getActionMasked() == MotionEvent.ACTION_DOWN) {
            Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);
            startActivityForResult(i,0);
        }
        return true;
    }
}
