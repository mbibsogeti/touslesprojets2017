package travel.jk.travelandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ib on 24/03/2017.
 */

public class TravelHelper extends SQLiteOpenHelper {
    // CONSTRUCTEUR //
    public TravelHelper(Context context) {
        // (contexte, nom de la base si plusieurs, mécanisme peu important, version de la base)
        super(context, "travel", null, 1);
    } // end constructor

    // Méthode appelée lorsque la base n'existe pas encore.
    // Les noms ne correpsondent pas forcément avec les attributs de la classe RegisterActivity
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE request(name TEXT, phone TEXT, location TEXT, info TEXT);");
    } // end onCreate method

    // Cette méthode est app
    // .01 nbgvfcdsq+
    // $^pmolikujhygtrfdeszaelée lorsque la version de la base a été changée.
    // Le changement est détecté par le changement du 4ème argument du constructeur. C'est à
    // l'utilisateur de maintenir ce numéro. Méthode contenant du code qui modifie la table.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    } // end onUpgrade method

    public int insertRequest(String name, String phone, String location, String info) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO request VALUES(?, ?, ?, ?);", new Object[]{
                name, phone, location, info});
        // Nombre de requêtes faites avec le même nom (celui passé en paramètre : ?)
        Cursor curseur = db.rawQuery(
                "SELECT COUNT(*) FROM request WHERE name=?",
                new String[]{name});
        curseur.moveToFirst();
        // Récupération du numéro de la requête
        int nb = curseur.getInt(0);
        curseur.close();
        db.close();
        return nb;
    }
} // end SQLiteOpenHelper class