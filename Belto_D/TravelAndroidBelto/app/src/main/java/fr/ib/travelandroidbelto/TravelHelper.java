package fr.ib.travelandroidbelto;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ib on 24/03/2017.
 */
// une classe pour gérer le stockage et la base de donnée
    //on create, crée la base si elle n'existe pas
    // onUpgrade le met à jour si la dernière valeur dans super (....,"travel", null, 1) est différent de int num
    // faudra toujours changer cette valeur dans super si on modifie la base
public class TravelHelper extends SQLiteOpenHelper {
    public TravelHelper(Context context){
        super(context,"travel",null,1);
    }
    // creation de la base avec des nom au au hasard (name, phone location)
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table request(name TEXT,phone TEXT,location TEXT, info TEXT);");

    }
    public void onUpgrade(SQLiteDatabase db, int old, int num){}
    public int insertRequest(String name, String phone, String location, String info){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("INSERT INTO request VALUES(?,?, ?, ?)",
        new Object[]{name,phone, location,info});
        // chemin inverse recuperer quelque chose dans la base en créant un cursor
        Cursor c=db.rawQuery("SELECT count(*) FROM request WHERE name=?",new String[]{name});
        c.moveToFirst();
        int nb=c.getInt(0);
        c.close();
    db.close();return nb;
    }
}
