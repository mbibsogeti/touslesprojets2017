package fr.ib.travelandroidma;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ib on 24/03/2017.
 */

public class TravelHelper extends SQLiteOpenHelper {
    public TravelHelper (Context ctx) {
        // constructeur à args : context, nom de la base, (null est un détail), version de la base.
        // le numéro de version est à modifier à la main !
        super(ctx, "travel", null, 1);
    }
    // fonction de création de la BD :
    public void onCreate (SQLiteDatabase db) {
        // Requête en SQL :
        db.execSQL("create table request(name TEXT, phone TEXT, place TEXT, info TEXT);");
    }
    // fonction de mise à jour de la BD :
    // Si l'on change le numéro de la version donné dans le constructeur,
    // on peut compléter cette fonction pour mettre à jour la BD avec
    // des requêtes adaptées.
    public void onUpgrade (SQLiteDatabase db, int old, int nw) {

    }
    // fonction d'insertion :
    public int insertRequest (String name, String phone, String place, String info) {
        SQLiteDatabase db = getWritableDatabase();
        // On fait l'insertion INSERT en utilisant un tableau d'objets (bizarre mais comme ça) :
        db.execSQL("INSERT INTO request VALUES (?,?,?,?);",
                new Object[] {
                        name,phone,place,info
                });
        // lecture de l'information avec un SELECT.
        Cursor c = db.rawQuery("SELECT count(*) FROM request WHERE name=?",new String[]{name});
        c.moveToFirst();
        int nb = c.getInt(0);
        c.close();
        db.close();
        return nb;
    }
}
