package ac.bracu.abdullaharif.bracnav;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bracu12thfloor.db";
    private static final String TABLE_NAME = "bracu_12thfloor_room_details";
    private static final String ID = "Id";
    private static final String POINT_A = "pointA";
    private static final String POINT_B = "pointB";
    private static final String START_X = "startX";
    private static final String START_Y = "startY";
    private static final String STOP_X = "stopX";
    private static final String STOP_Y = "stopY";
    private static final String START_X2 = "startX2";
    private static final String START_Y2 = "startY2";
    private static final String STOP_X2 = "stopX2";
    private static final String STOP_Y2 = "stopY2";
    private static final String START_X3 = "startX3";
    private static final String START_Y3 = "startY3";
    private static final String STOP_X3 = "stopX3";
    private static final String STOP_Y3 = "stopY3";
    private static final int VERSION_NUMBER = 13;
    private Context context;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            POINT_A + " VARCHAR(255) NOT NULL, " +
            POINT_B + " VARCHAR(255) NOT NULL, " +
            START_X + " VARCHAR(255) NOT NULL, " +
            START_Y + " VARCHAR(255) NOT NULL, " +
            STOP_X + " VARCHAR(255) NOT NULL, " +
            STOP_Y + " VARCHAR(255) NOT NULL, " +
            START_X2 + " VARCHAR(255) NOT NULL, " +
            START_Y2 + " VARCHAR(255) NOT NULL, " +
            STOP_X2 + " VARCHAR(255) NOT NULL, " +
            STOP_Y2 + " VARCHAR(255) NOT NULL, " +
            START_X3 + " VARCHAR(255) NOT NULL, " +
            START_Y3 + " VARCHAR(255) NOT NULL, " +
            STOP_X3 + " VARCHAR(255) NOT NULL, " +
            STOP_Y3 + " VARCHAR(255) NOT NULL);";
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS "+TABLE_NAME;
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e) {
            Toast.makeText(context, "Exception: "+e, Toast.LENGTH_LONG).show();

        }

    }
    // Method to insert entries directly into the database
    public void insertData(String pointA, String pointB, String startX, String startY, String stopX, String stopY,
                           String startX2, String startY2, String stopX2, String stopY2,
                           String startX3, String startY3, String stopX3, String stopY3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(POINT_A, pointA);
        values.put(POINT_B, pointB);
        values.put(START_X, startX);
        values.put(START_Y, startY);
        values.put(STOP_X, stopX);
        values.put(STOP_Y, stopY);
        values.put(START_X2, startX2);
        values.put(START_Y2, startY2);
        values.put(STOP_X2, stopX2);
        values.put(STOP_Y2, stopY2);
        values.put(START_X3, startX3);
        values.put(START_Y3, startY3);
        values.put(STOP_X3, stopX3);
        values.put(STOP_Y3, stopY3);

        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1) {
            // Insert failed
            Toast.makeText(context, "Data insertion failed", Toast.LENGTH_SHORT).show();
        } else {
            // Insert successful
            Toast.makeText(context, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
}