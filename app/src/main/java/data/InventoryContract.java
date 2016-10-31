package data;


import android.content.Intent;
import android.provider.BaseColumns;

public class InventoryContract implements BaseColumns{

    public InventoryContract()  {

    }
    public static final String tableName = "stock";
    public static final String _ID = BaseColumns._ID;
    public static final String Column_ITEM_NAME = "name";
    public static final String Column_ITEM_PRICE = "price";
    public static final String Column_ITEM_CATEGORY = "category";
}
