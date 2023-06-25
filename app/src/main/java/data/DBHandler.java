package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
        String query2 = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME2+"( "+ COLUMN_ID+" TEXT PRIMARY KEY,"+ COLUMN_DATE+" TEXT, "+ COLUMN_SURAH+" INTEGER, "+ COLUMN_PARA+" INTEGER, "+ COLUMN_AYAT+" TEXT, "+ COLUMN_SABQI+" INTEGER,"+ COLUMN_MANZIL+" INTEGER)";
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
}
