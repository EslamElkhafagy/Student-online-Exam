package layout.Register;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Connection extends SQLiteOpenHelper {

    public static final String DataBaseName="Student.db";
/************** profile ****************************/
    public static final String TableName="Data_Table";
    public static final String col_1="ID";
    public static final String col_2="UserName";
    public static final String col_3="Phone";
    public static final String col_4="Address";
    public static final String col_5="Email";
    public static final String col_6="Password";
    public static final String col_7="Type";

    /**************** course ***********************/
    public static final String TableCourse="COURSE_Table";
    public static final String cid="IDCOURSE";
    public static final String ccode="CODECOURSE";
    public static final String cname="NAMECOURSE";
    public static final String csem="SEMCOURSE";
    public static final String cdetails="DETAILSCOURSE";
    public static final String cuser="USERID";
    public static final String cquiz="QUIZ";
    public static final String csdate="START";
    public static final String cedate="END";
    public static final String cqdetails="QDETAILS";


    public Connection(Context context) {
        super(context, DataBaseName, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table " + TableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, UserName TEXT ,Phone TEXT,Address TEXT,Email TEXT,Password TEXT,Type TEXT)");
//            db.execSQL("Create Table " + TableCourse +
//                    "( " + cid + " integer primary key autoincrement" +
//                    " , " + ccode + " Text , " + cname + " Text , " + csem + " Text , "
//                    + cdetails + " Text , FOREIGN KEY (" + col_1 + ") REFERENCES Persons(" + col_1 + ")");

            db.execSQL("create table " + TableCourse + " (IDCOURSE INTEGER PRIMARY KEY AUTOINCREMENT, CODECOURSE TEXT ,NAMECOURSE TEXT,SEMCOURSE TEXT,DETAILSCOURSE TEXT,USERID TEXT,QUIZ TEXT,START TEXT,END TEXT,QDETAILS TEXT)");


        }catch (Exception e){
            System.out.println(".... \n "+e+"\n ........... \n");

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists " + TableCourse);
        db.execSQL("DROP TABLE IF EXITS "+ TableName);
        onCreate(db);

    }
/*********************   methods   profile  ***********************************/
    public boolean insert(String name,String phone,String address , String email ,String password,String type){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,name);
        contentValues.put(col_3,phone);
        contentValues.put(col_4,address);
        contentValues.put(col_5,email);
        contentValues.put(col_6,password);
        contentValues.put(col_7,type);
        // return record num
        long res= db.insert(TableName,null,contentValues);

        if(res==-1)
            return false;
        else
            return true;
    }

    public Cursor getProfileData(String email,String pass){
        SQLiteDatabase db =this.getWritableDatabase();

          Cursor res = db.rawQuery("select * from " + TableName + " where Email=? and Password=? ", new String[]{email,pass});

        return res;

    }
/** not used */
    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TableName,null);
        return res;

    }

    public boolean update(String id,String name,String phone,String address , String email ,String type){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,phone);
        contentValues.put(col_4,address);
        contentValues.put(col_5,email);
//        contentValues.put(col_6,password);
        contentValues.put(col_7,type);

        db.update(TableName,contentValues,"ID = ?",new String[]{id});

        return true;


    }
    /** not used */
    public boolean delete(String id){

        SQLiteDatabase db =this.getWritableDatabase();
        int r= db.delete(TableName,"ID = ? ",new String[]{id});
        if(r>0)
            return true;
        else
            return false;



    }

    /*************** method   course **********************/

    public boolean insertCourse(String code,String name,String sem , String details ,String userid){

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ccode,code);
        contentValues.put(cname,name);
        contentValues.put(csem,sem);
        contentValues.put(cdetails,details);
        contentValues.put(cuser,userid);
        contentValues.put(cquiz,"false");
        contentValues.put(csdate,"false");
        contentValues.put(cedate,"false");
        contentValues.put(cqdetails,"false");
        long res= db.insert(TableCourse,null,contentValues);

        if(res==-1)
            return false;
        else
            return true;


    }

public boolean deleteCourse(String id){

    SQLiteDatabase db =this.getWritableDatabase();
    int r= db.delete(TableCourse,"CODECOURSE = ? ",new String[]{id});
    if(r>0)
        return true;
    else
        return false;

}


    public Cursor getcourseData(String code){
        SQLiteDatabase db =this.getWritableDatabase();

//        Cursor res = db.rawQuery("select * from "+TableName+" where Email='"+email+"'"+"and Password='"+pass+"'",null);

        Cursor res = db.rawQuery("select * from " + TableCourse + " where CODECOURSE=? ", new String[]{code});


        return res;

    }


    public boolean updateCousreData(String code,String name,String sem , String details){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
//        contentValues.put(ccode,code);
        contentValues.put(cname,name);
        contentValues.put(csem,sem);
        contentValues.put(cdetails,details);


        db.update(TableCourse,contentValues,"CODECOURSE = ?",new String[]{code});

        return true;

    }


    public Cursor loadcoursesname(){

        SQLiteDatabase db =this.getWritableDatabase();

//        Cursor res = db.rawQuery("select * from "+TableName+" where Email='"+email+"'"+"and Password='"+pass+"'",null);

        Cursor res = db.rawQuery("select NAMECOURSE from " + TableCourse , null);


        return res;
    }

    public Cursor courseDataView(String name){
        SQLiteDatabase db =this.getWritableDatabase();

//        Cursor res = db.rawQuery("select * from "+TableName+" where Email='"+email+"'"+"and Password='"+pass+"'",null);

        Cursor res = db.rawQuery("select * from " + TableCourse + " where NAMECOURSE=? ", new String[]{name});


        return res;

    }

    public boolean CreateQuiz(String quiz,String start,String end , String details,String name){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(cquiz,quiz);
        contentValues.put(csdate,start);
        contentValues.put(cedate,end);
        contentValues.put(cqdetails,details);


        db.update(TableCourse,contentValues,"NAMECOURSE = ?",new String[]{name});

        return true;

    }

    public Cursor Getquiz(){

        SQLiteDatabase db =this.getWritableDatabase();

        String code="false";
//        Cursor res = db.rawQuery("select * from "+TableName+" where Email='"+email+"'"+"and Password='"+pass+"'",null);

        Cursor res = db.rawQuery("select * from " + TableCourse + " where QUIZ=? ", new String[]{code});


        return res;
    }

    public Cursor LoadAvquiz(){

        SQLiteDatabase db =this.getWritableDatabase();

        String code="true";
//        Cursor res = db.rawQuery("select * from "+TableName+" where Email='"+email+"'"+"and Password='"+pass+"'",null);

        Cursor res = db.rawQuery("select * from " + TableCourse + " where QUIZ=? ", new String[]{code});


        return res;
    }


}
