package obodrel.fr.android_travel_obodrel.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by ib on 24/03/2017.
 */

public class RegisterDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Travel.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE IF NOT EXISTS " + RegisterEntry.TABLE_NAME + " (" +
                    RegisterEntry._ID + " INTEGER PRIMARY KEY," +
                    RegisterEntry.COLUMN_NAME_NAME + " TEXT," +
                    RegisterEntry.COLUMN_NAME_TELEPHONE + " TEXT," +
                    RegisterEntry.COLUMN_NAME_LOCATION + " TEXT," +
                    RegisterEntry.COLUMN_NAME_INFORMATIONS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + RegisterEntry.TABLE_NAME;

    public RegisterDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public static class RegisterEntry implements BaseColumns {
        public static final String TABLE_NAME = "register";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_TELEPHONE = "telephone";
        public static final String COLUMN_NAME_LOCATION = "location";
        public static final String COLUMN_NAME_INFORMATIONS = "informations";
    }
}
