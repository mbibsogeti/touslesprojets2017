package raynorraiders.supercoolappmadebyhugo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SubmapsActivity extends Activity {

    public void onCreate(Bundle s) {
        super.onCreate(s);
        int area = getIntent().getIntExtra("area", 1);
        if (area == 1) {
            Toast.makeText(this, "Oceania occidental", Toast.LENGTH_LONG).show();
            setContentView(new SubmapsActivity.MapView(this));
        } else {
            Toast.makeText(this, "Oceania oriental", Toast.LENGTH_LONG).show();
            setContentView(new SubmapsActivity.MapView(this));
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data.getLongExtra("time", 0) > 500) {
            //parametre qui renvoit le temps en ms
            long ms = data.getLongExtra("time", 0);
            //parametre qui renvoit le mot second en singulier ou pluriel, en fonction de la valeur de ms
            String sec = getResources().getQuantityString(R.plurals.second, (int) ms / 1000);
            //appel au string défini dans strings.xml avec deux parametres: ms et sec
            Toast.makeText(this, getString(R.string.day_warning, (int) ms / 1000, sec), Toast.LENGTH_LONG).show();
        }
    }

    private class MapView extends View {
        public MapView(Context ctx) {
            super(ctx);
        }

        protected void onDraw(Canvas canvas) {
            int area = getIntent().getIntExtra("area", 1);
            if (area == 1) {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.occ_oceania);
                canvas.drawBitmap(b, 0, 0, null);
            } else {
                Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.oceania_east);
                canvas.drawBitmap(b, 0, 0, null);
            }
        }

        public boolean onTouchEvent(MotionEvent event) {
            if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                Intent i = new Intent(SubmapsActivity.this, PlaneActivity.class);
                int area = 1;
                i.putExtra("area", area);
                // 0=entier
                startActivityForResult(i, 0);
            }
            return true;
        }
    }
}
