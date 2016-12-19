package cardapiodigital.tecsoluction.com.cardapiodigital.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import cardapiodigital.tecsoluction.com.cardapiodigital.entidade.Garcon;

/**
 * Created by winds on 20/11/2016.
 */
public class GarconDao {

    private SQLiteDatabase database;
    private CriarBanco dbHelper;
    private Context cx;

    //Campos da tabela
    private String[] colunas = {
            GarconColunas._ID,
            GarconColunas.COLUMN_NAME_NOME_GARCON,
            GarconColunas.COLUMN_NAME_SENHA_GARCON,
//            UsuarioColunas.COLUMN_NAME_PAGAMENTO,
//            UsuarioColunas.COLUMN_NAME_CONTA,
//            UsuarioColunas.COLUMN_NAME_LATITUDE,
//            UsuarioColunas.COLUMN_NAME_LONGETUDE,

    };

    public GarconDao(Context context) {
        dbHelper = new CriarBanco(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void read() throws SQLException {
        database = dbHelper.getReadableDatabase();
    }

    public Long inserir(Garcon pValue) {
        open();
        ContentValues values = valuesPut(pValue);

        //Carregar os valores nos campos do Contato que será incluído
        values.put(GarconColunas.COLUMN_NAME_ID, pValue.getId());
        values.put(GarconColunas.COLUMN_NAME_NOME_GARCON, String.valueOf(pValue.getNomegarcon()));
        values.put(GarconColunas.COLUMN_NAME_SENHA_GARCON, String.valueOf(pValue.getSenhagarcon()));
//        values.put(HeadacheContractor.COLUMN_NAME_HORAFIM, pValue.getHoraTermino());
//        values.put(HeadacheContractor.COLUMN_NAME_HORAINI, pValue.getHoraTermino());
//        values.put(HeadacheContractor.COLUMN_NAME_INTENSIDADE, String.valueOf(pValue.getIntensidade()));

        Long result = database.insert(GarconColunas.TABLE_NAME, null, values);
        close();

        return result;
    }


    public int alterar(Garcon pValue) {
        open();

        Long id = pValue.getId();

        Log.i("id_alt", "id para alterar: " + String.valueOf(id));
        //Carregar os novos valores nos campos que serão alterados
        ContentValues values = valuesPut(pValue);

        //Alterar o registro com base no ID
        int result = database.update(GarconColunas.TABLE_NAME, values,
                GarconColunas._ID + " = " + id, null);

        close();

        return result;
    }
//
//    public int excluir(Headache pValue) {
//
//        Long id = pValue.getId();
//
//        //Exclui o registro com base no ID
//        int result = database.delete(HeadacheContractor.TABLE_NAME,
//                HeadacheContractor._ID + " = " + id, null);
//        return result;
//    }

  //  public Cursor consultar(String query) {

//        read();
//        List<Garcon> lstGarcon = new ArrayList<>();
//
//        //Consulta para trazer todos os dados da tabela headache ordenados pela coluna data inicio
//        Cursor cursor = database.query(GarconColunas.TABLE_NAME, colunas,
//                null, null, null, null, GarconColunas.COLUMN_NAME_ID);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Garcon garcon = cursorGarcon(cursor);
//            lstGarcon.add(garcon);
//            cursor.moveToNext();
//        }
//
//        //Tenha certeza que você fechou o cursor
//        cursor.close();
//        close();
//        Cursor cursor = cx.getContentResolver().query(CardapioDigitalProvider.HOROSCOPO_URI,
//                GarconColunas.ALL_COLUMNS,
//                where,
//                null,
//                null);
//        return cursor;
    //}

    //Converter o Cursor de dados no objeto POJO ContatoVO
//    private Garcon cursorGarcon(Cursor cursor) {
//        Garcon garcon = new Garcon();
//
//        Log.i("id", "id " + String.valueOf(cursor.getLong(0)));
//        Log.i("nomeGarcon", "1: " + cursor.getString(1));
//        Log.i("senha", "2: " + cursor.getString(2));
//
//
//        garcon.setId(cursor.getLong(0));
//        garcon.setNomegarcon(cursor.getString(1));
//        garcon.setSenhagarcon(cursor.getString(2));
//
//        return garcon;
//    }

    private ContentValues valuesPut(Garcon pValue) {
        ContentValues values = new ContentValues();

        values.put(GarconColunas._ID, pValue.getId());
        values.put(GarconColunas.COLUMN_NAME_NOME_GARCON, pValue.getNomegarcon());
        values.put(GarconColunas.COLUMN_NAME_SENHA_GARCON, pValue.getSenhagarcon());



        return values;
    }

}
