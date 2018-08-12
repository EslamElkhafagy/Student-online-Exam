package layout.Registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Enjoy on 07/05/2017.
 */
public class DbConnection extends SQLiteOpenHelper {


    public static final String DataBaseName="Student.db";
    public static final String TableDataName="Data_Table";
    public static final String TableName="Student_Table";
    public static final String col_1="ID";
    public static final String col_2="UserName";
    public static final String col_3="Phone";
    public static final String col_4="Address";
    public static final String col_5="Email";
    public static final String col_6="Password";
    public static final String col_7="Type";

    public DbConnection(Context context) {
        super(context, DataBaseName, null , 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table " + TableName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,UserName TEXT ,Phone TEXT,"
            + "Address TEXT,Email TEXT,Password TEXT)");
    db.execSQL("create table " + TableDataName + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,UserName TEXT,"
            + "Phone TEXT,Address TEXT,Email TEXT,Password TEXT,Type TEXT)");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXITS "+TableName);
//        onCreate(db);
        db.execSQL("DROP TABLE IF EXITS "+TableDataName);
        onCreate(db);

    }

    public boolean insertData(String name,String phone,String address , String email ,String password,String type){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,name);
        contentValues.put(col_3,phone);
        contentValues.put(col_4,address);
        contentValues.put(col_5,email);
        contentValues.put(col_6,password);
        contentValues.put(col_7,type);

        long res= db.insert(TableDataName,null,contentValues);

        if(res==-1)
            return false;
        else
            return true;


    }
    /****************** methods  *******************************/
    public boolean insert(String name,String phone,String address , String email ,String password){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,name);
        contentValues.put(col_3,phone);
        contentValues.put(col_4,address);
        contentValues.put(col_5,email);
        contentValues.put(col_6,password);

       long res= db.insert(TableName,null,contentValues);

        if(res==-1)
            return false;
        else
            return true;


    }

    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+TableName,null);
return res;

    }

    public boolean update(String id,String name,String phone,String address , String email ,String password){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,phone);
        contentValues.put(col_4,address);
        contentValues.put(col_5,email);
        contentValues.put(col_6,password);

        db.update(TableName,contentValues,"ID = ?",new String[]{id});

            return true;


    }

public boolean delete(String id){

    SQLiteDatabase db =this.getWritableDatabase();
   int r= db.delete(TableName,"ID = ? ",new String[]{id});
if(r>0)
    return true;
    else
    return false;



}

    public Cursor check(){
        SQLiteDatabase db =this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from "+TableName,null);
        System.out.println("res =   "+res);
        return res;

    }


}
