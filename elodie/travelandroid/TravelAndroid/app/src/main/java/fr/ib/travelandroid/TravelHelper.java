package fr.ib.travelandroid;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TravelHelper extends SQLiteOpenHelper {
    public TravelHelper(Context ctx) {
        super(ctx, "travel", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table request(name TEXT, phone TEXT, location TEXT, info TEXT);");
    }

    @Override
    //permet de faire des mises à jour de la base i.e
    // lorsque l'on aura changer le int dans le constructeur de la classe de la base de donnée
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insertRequest(String name, String phone, String location, String info) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO request VALUES(?,?,?,?);", new Object[]{name, phone, location, info});
        Cursor c = db.rawQuery("SELECT count(*) c FROM request WHERE name=?",new String[]{name});
        c.moveToFirst();
        int nb = c.getInt(0);
        c.close();
        db.close();
        return nb;
    }
}
