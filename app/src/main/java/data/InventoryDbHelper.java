package data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static  final String DATABASE_NAME = "inventory.db";

    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_STOCK_TABLE = "CREATE TABLE "+ InventoryContract.TABLE_NAME + "("
                + InventoryContract._ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                InventoryContract.Column_ITEM_NAME + "TEXT NOT NULL," +
                InventoryContract.Column_ITEM_PRICE + "REAL," +
                InventoryContract.Column_ITEM_CATEGORY + "TEXT);";
        sqLiteDatabase.execSQL(SQL_CREATE_STOCK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
