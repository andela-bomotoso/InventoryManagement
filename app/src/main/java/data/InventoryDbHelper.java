package data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static  final String DATABASE_NAME = "inventory.db";

    public InventoryDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String SQL_CREATE_STOCK_TABLE = "CREATE TABLE "+ InventoryContract.InventoryEntry.TABLE_NAME + "("
                + InventoryContract.InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                InventoryContract.InventoryEntry.Column_ITEM_NAME + " TEXT NOT NULL," +
                InventoryContract.InventoryEntry.Column_ITEM_PRICE + " REAL," +
                InventoryContract.InventoryEntry.Column_ITEM_CATEGORY + " TEXT);";
        sqLiteDatabase.execSQL(SQL_CREATE_STOCK_TABLE);
        Log.d("CREATE_TABLE_STATEMENT",SQL_CREATE_STOCK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
