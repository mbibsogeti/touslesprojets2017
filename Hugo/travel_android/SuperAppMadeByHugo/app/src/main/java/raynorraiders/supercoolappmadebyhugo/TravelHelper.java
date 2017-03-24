package raynorraiders.supercoolappmadebyhugo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TravelHelper extends SQLiteOpenHelper {
    public TravelHelper(Context context) {
        super(context, "travel", null, 1);
    }

    public int insertRequest(String name, String phone, String location, String info) {
        //getWritableDatabase fourni par la classe mère SQLiteOpenHelper
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO request VALUES(?,?,?,?)", new Object[]{name, phone, location, info});
        Cursor c = db.rawQuery("SELECT count(*) FROM request WHERE name=?", new String[]{name});
        c.moveToFirst();
        int nb = c.getInt(0);
        c.close();
        db.close();
        return nb;
    }


    public void onCreate(SQLiteDatabase db) {
//      commandes en sql classique
        db.execSQL("create table request(name TEXT,phone TEXT,location TEXT, info TEXT)");

    }

    public void onUpgrade(SQLiteDatabase db, int _old, int _new) {

    }

}