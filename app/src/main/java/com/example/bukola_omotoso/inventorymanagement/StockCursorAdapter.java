package com.example.bukola_omotoso.inventorymanagement;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import data.InventoryContract;


public class StockCursorAdapter extends CursorAdapter {

    public StockCursorAdapter(Context context, Cursor cursor)   {
        super(context,cursor,0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameTextView = (TextView)view.findViewById(R.id.item_name);
        TextView categoryTextView = (TextView)view.findViewById(R.id.item_category);
        TextView priceTextView = (TextView)view.findViewById(R.id.item_price);

        int nameColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.Column_ITEM_NAME);
        int categoryColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.Column_ITEM_CATEGORY);
        int priceColumnIndex = cursor.getColumnIndex(InventoryContract.InventoryEntry.Column_ITEM_PRICE);

        String itemName = cursor.getString(nameColumnIndex);
        String itemCategory = cursor.getString(categoryColumnIndex);
        double itemPrice = cursor.getDouble(priceColumnIndex);

        nameTextView.setText(itemName);
        categoryTextView.setText(itemCategory);
        priceTextView.setText(String.valueOf(itemPrice));

    }
}
