package cardapiodigital.tecsoluction.com.cardapiodigital.dao;

import android.provider.BaseColumns;

/**
 * Created by winds on 20/11/2016.
 */
public class GarconColunas implements BaseColumns {

    public GarconColunas() {
    }

    public static final String TABLE_NAME = "Garcon";

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_NOME_GARCON = "nome";
    public static final String COLUMN_NAME_SENHA_GARCON = "senha";
//    public static final String COLUMN_NAME_PAGAMENTO = "pagamento";
//    public static final String COLUMN_NAME_CONTA = "conta";
//    public static final String COLUMN_NAME_LATITUDE = "latitude";
//    public static final String COLUMN_NAME_LONGETUDE = "longetude";


    private static final String TEXT_TYPE = " TEXT";
       private static final String DOUBLE_TYPE = " DOUBLE";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY NOT NULL, " +
                    COLUMN_NAME_ID + INTEGER_TYPE + COMMA_SEP +
                    COLUMN_NAME_NOME_GARCON + TEXT_TYPE + COMMA_SEP +
                    COLUMN_NAME_SENHA_GARCON + TEXT_TYPE + COMMA_SEP +


                    " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;





}
