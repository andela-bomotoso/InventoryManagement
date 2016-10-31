package data;


import android.content.Intent;
import android.net.Uri;
import android.os.ParcelUuid;
import android.provider.BaseColumns;

public final class InventoryContract {

    public static  final String CONTENT_AUTHORITY = "com.example.bukola_omotoso.inventorymanagement";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_STOCKS = "stock";


    public InventoryContract()  {

    }


    public static final class InventoryEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_STOCKS);
        public static final String TABLE_NAME = "stock";
        public static final String _ID = BaseColumns._ID;
        public static final String Column_ITEM_NAME = "name";
        public static final String Column_ITEM_PRICE = "price";
        public static final String Column_ITEM_CATEGORY = "category";
    }

}
