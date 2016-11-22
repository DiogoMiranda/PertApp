package diogo.miranda.pert.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import diogo.miranda.pert.Model.Atividade;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Diogo on 30/04/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "atividade.sqlite";
    public static final String TABLE_NAME = "myatividade";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLER = "titler";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_RESPONSIBLE = "responsible";
    public static final String COLUMN_QTD = "qtd";
    public static final String COLUMN_STATUS = "status";


    private HashMap hp;

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " + TABLE_NAME +
                        "(" + COLUMN_ID + " integer primary key autoincrement, " +
                        COLUMN_TITLER + " text, "+
                        COLUMN_RESPONSIBLE + " text, "+
                        COLUMN_DESCRIPTION + " text, "+
                        COLUMN_QTD + " text, "+
                        COLUMN_STATUS + " text)"
        );
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //----------------------------------------------------------------------------------------------
    public Integer addStudentContact(String titler, String description, String responsible, Double qtd, String status){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contantValues = new ContentValues();
        contantValues.put(COLUMN_TITLER,titler);
        contantValues.put(COLUMN_DESCRIPTION,description);
        contantValues.put(COLUMN_RESPONSIBLE, responsible);
        contantValues.put(COLUMN_QTD, qtd);
        contantValues.put(COLUMN_STATUS,status);

        Integer res = (int) db.insert(TABLE_NAME, null, contantValues);
        db.close();

        Log.i("", "DAO - Add");
        return res;
    }

    //----------------------------------------------------------------------------------------------
    public boolean updateStudentContact(Integer id, String titler, String description, String responsible, Double qtd, String status){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contantValues = new ContentValues();
        contantValues.put(COLUMN_TITLER,titler);
        contantValues.put(COLUMN_DESCRIPTION,description);
        contantValues.put(COLUMN_RESPONSIBLE, responsible);
        contantValues.put(COLUMN_QTD, qtd);
        contantValues.put(COLUMN_STATUS,status);

        db.update(TABLE_NAME, contantValues, "id = ?", new String[]{Integer.toString(id)});
        db.close();
        Log.i("", "DAO - Update");
        return true;
    }

    //----------------------------------------------------------------------------------------------
    public Integer deleteContact(Integer id){
        SQLiteDatabase db=this.getWritableDatabase();
        int res = db.delete(TABLE_NAME," id = ?",new String[]{Integer.toString(id)});
        db.close();
        Log.i("", "DAO - Delete");
        return res;
    }

    //----------------------------------------------------------------------------------------------
    public Cursor getData(int contactid){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from " + TABLE_NAME + " where " + COLUMN_ID + " = " + contactid, null);
        db.close();

        return res;
    }

    //----------------------------------------------------------------------------------------------
    //TODO: Criei este método getAtividadeByID para retornar ja um objeto Atividade e não um cursor como no método GetData.
    public Atividade getAtividadeByID(Integer contactid){

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("Select * from " + TABLE_NAME + " where " + COLUMN_ID + " = " + contactid, null);

        Atividade atividade = new Atividade();

        if (cursor.moveToFirst()){
            atividade.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
            atividade.setTitler(cursor.getString(cursor.getColumnIndex(COLUMN_TITLER)));
            atividade.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
            atividade.setResponsible(cursor.getString(cursor.getColumnIndex(COLUMN_RESPONSIBLE)));

            atividade.setQtd(cursor.getDouble(cursor.getColumnIndex(COLUMN_QTD)));
            atividade.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));

            db.close();

            return atividade;
        }
        else{
            return null;
        }
    }

    //----------------------------------------------------------------------------------------------
    public int numberOfRows(){
        SQLiteDatabase db=this.getWritableDatabase();
        int numRows=(int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        db.close();

        return numRows;
    }

    //----------------------------------------------------------------------------------------------
    public ArrayList<Atividade> getAllStudentContacts(){
        ArrayList<Atividade> arrayAtividade = new ArrayList<Atividade>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {

                Atividade atividade = new Atividade();
                atividade.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                atividade.setTitler(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                atividade.setResponsible(cursor.getString(cursor.getColumnIndex(COLUMN_RESPONSIBLE)));
                atividade.setDescription(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)));
                atividade.setQtd(cursor.getDouble(cursor.getColumnIndex(COLUMN_QTD)));
                atividade.setStatus(cursor.getString(cursor.getColumnIndex(COLUMN_STATUS)));

                arrayAtividade.add(atividade);
                atividade = null;

            } while (cursor.moveToNext());

            cursor.close();
            db.close();

        }
        return arrayAtividade;
    }
}
