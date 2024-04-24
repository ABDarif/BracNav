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
    private static final int VERSION_NUMBER = 19;
    private Context context;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            POINT_A + " TEXT NOT NULL, " +
            POINT_B + " TEXT NOT NULL, " +
            START_X + " TEXT NOT NULL, " +
            START_Y + " TEXT NOT NULL, " +
            STOP_X + " TEXT NOT NULL, " +
            STOP_Y + " TEXT NOT NULL, " +
            START_X2 + " TEXT NOT NULL, " +
            START_Y2 + " TEXT NOT NULL, " +
            STOP_X2 + " TEXT NOT NULL, " +
            STOP_Y2 + " TEXT NOT NULL, " +
            START_X3 + " TEXT NOT NULL, " +
            START_Y3 + " TEXT NOT NULL, " +
            STOP_X3 + " TEXT NOT NULL, " +
            STOP_Y3 + " TEXT NOT NULL);";
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
}