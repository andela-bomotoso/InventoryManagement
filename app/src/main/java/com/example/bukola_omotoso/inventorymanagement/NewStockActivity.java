package com.example.bukola_omotoso.inventorymanagement;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import data.InventoryContract;

public class NewStockActivity extends AppCompatActivity {
    private EditText itemName;
    private EditText itemCategory;
    private EditText itemPrice;
    private FloatingActionButton saveItemFAB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_stock);


        itemName = (EditText)findViewById(R.id.item_name);
        itemCategory = (EditText)findViewById(R.id.item_category);
        itemPrice = (EditText)findViewById(R.id.item_price);
        saveItemFAB = (FloatingActionButton)findViewById(R.id.save_item_fab);
        saveItemFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveItem();
            }
        });



    }

    private void saveItem() {
        String itemNameString = itemName.getText().toString().trim();
        String itemCategoryString = itemCategory.getText().toString().trim();
        String itemPriceString = itemPrice.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(InventoryContract.InventoryEntry.Column_ITEM_NAME, itemNameString);
        values.put(InventoryContract.InventoryEntry.Column_ITEM_CATEGORY,itemCategoryString);
        values.put(InventoryContract.InventoryEntry.Column_ITEM_PRICE,Double.parseDouble(itemPriceString));

        getContentResolver().insert(InventoryContract.InventoryEntry.CONTENT_URI,values);
    }
}
