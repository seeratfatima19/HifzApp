package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    public static final int DB_VERSION =1;
    public static final String DB_NAME = "Students";

    // data of first table
    public static final String TABLE_NAME1 = "student_data";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE= "age";
    public static final String COLUMN_CLASS="class";

    // data for table 2
    public static final String TABLE_NAME2 = "daily_data";
    public static final String COLUMN_SURAH = "surah";
    public static final String COLUMN_PARA = "para";
    public static final String COLUMN_AYAT="ayat";
    public static final String COLUMN_SABQI="sabqi";
    public static final String COLUMN_MANZIL="manzil";
    public static final String COLUMN_DATE = "date";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query1 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME1+"( "+ COLUMN_ID+" TEXT PRIMARY KEY,"+ COLUMN_NAME+" TEXT, "+ COLUMN_AGE+" TEXT, "+ COLUMN_CLASS+" TEXT)";
        String query2 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME2+"( "+ COLUMN_ID+" TEXT ,"+ COLUMN_DATE+" TEXT, "+ COLUMN_SURAH+" INTEGER, "+ COLUMN_PARA+" INTEGER, "+ COLUMN_AYAT+" TEXT, "+ COLUMN_SABQI+" INTEGER,"+ COLUMN_MANZIL+" INTEGER)";
        db.execSQL(query1);
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insertStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_ID, student.getId());
        values1.put(COLUMN_NAME, student.getName());
        values1.put(COLUMN_AGE, student.getAge());
        values1.put(COLUMN_CLASS, student.get_Class());
        int i = (int) db.insert(TABLE_NAME1, null, values1);
        db.close();
        return i;
    }

    public void showDb()
    {
        String selectQuery = "SELECT  * FROM " + TABLE_NAME1;

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        System.out.println(cursor.getString(0));
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
            }

        } finally {
            try { db.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
        }
    }

    public Student getStudent(String studentId)
    {
        String query1= "SELECT * FROM "+ TABLE_NAME1+ " WHERE "+ COLUMN_ID +"= '"+studentId+"'";
        SQLiteDatabase db=this.getReadableDatabase();
        Student student=null;
        try {

            Cursor cursor = db.rawQuery(query1, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        student= new Student();
                        student.setId(cursor.getString(0));
                        student.setName(cursor.getString(1));
                        student.setAge(cursor.getInt(2));
                        student.setClass(cursor.getInt(3));

                        System.out.println(cursor.getString(1));
                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
            }

        } finally {
            try { db.close(); } catch (Exception ex) {System.out.println(ex.getMessage());}
        }

        return student;
    }

    public int updateStudent(String id, String date, int surah, int para, String sabaq, int sabqi, int manzil)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values1 = new ContentValues();
        values1.put(COLUMN_ID, id);
        values1.put(COLUMN_DATE,date);
        values1.put(COLUMN_SURAH, surah);
        values1.put(COLUMN_PARA, para);
        values1.put(COLUMN_AYAT, sabaq);
        values1.put(COLUMN_SABQI, sabqi);
        values1.put(COLUMN_MANZIL, manzil);
        int i = (int) db.insert(TABLE_NAME2, null, values1);
        db.close();
        return i;

    }

    public ArrayList<StudentData> getStudentData(String id) {
        String query1 = "SELECT * FROM " + TABLE_NAME2 + " WHERE " + COLUMN_ID + "= '" + id + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<StudentData> studentData = new ArrayList<StudentData>();
        try {

            Cursor cursor = db.rawQuery(query1, null);
            try {

                // looping through all rows and adding to list
                if (cursor.moveToFirst()) {
                    do {
                        StudentData student = new StudentData();
                        student.setId(cursor.getString(0));
                        student.setDate(cursor.getString(1));
                        student.setSurah(cursor.getInt(2));
                        student.setPara(cursor.getInt(3));
                        student.setSabaq(cursor.getString(4));
                        student.setSabqi(cursor.getInt(5));
                        student.setManzil(cursor.getInt(6));

                        System.out.println(cursor.getString(1));
                        studentData.add(student);
                    } while (cursor.moveToNext());
                }

            } finally {
                try {
                    cursor.close();
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } finally {
            try {
                db.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return studentData;
    }
}
