package cardapiodigital.tecsoluction.com.cardapiodigital.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by winds on 20/11/2016.
 */
public class CriarBanco extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.F
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CardapioDigital.db";


    public CriarBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GarconColunas.SQL_CREATE_ENTRIES);
//        db.execSQL(UsuarioColunas.SQL_CREATE_ENTRIES);
//        db.execSQL(ModeloColunas.SQL_CREATE_ENTRIES);
//        db.execSQL(PagamentoColunas.SQL_CREATE_ENTRIES);
//        db.execSQL(PerfilColunas.SQL_CREATE_ENTRIES);
//        db.execSQL(ContaColunas.SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(GarconColunas.SQL_DELETE_ENTRIES);
//        db.execSQL(UsuarioColunas.SQL_DELETE_ENTRIES);
//        db.execSQL(ModeloColunas.SQL_DELETE_ENTRIES);
//        db.execSQL(PagamentoColunas.SQL_DELETE_ENTRIES);
//        db.execSQL(PerfilColunas.SQL_DELETE_ENTRIES);
//        db.execSQL(ContaColunas.SQL_DELETE_ENTRIES);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
