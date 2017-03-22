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
        if (data.getLongExtra("timehaha",0)>2000)
            Toast.makeText(this,"Super Avion", Toast.LENGTH_LONG).show();
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
