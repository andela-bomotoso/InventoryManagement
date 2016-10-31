package com.example.bukola_omotoso.inventorymanagement;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import data.InventoryContract;

public class StockActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int STOCK_LOADER = 0;
    StockCursorAdapter stockCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StockActivity.this,NewStockActivity.class);
                startActivity(intent);
            }
        });
        ListView stockListView = (ListView)findViewById(R.id.stock_list);
        stockCursorAdapter = new StockCursorAdapter(this,null);
        stockListView.setAdapter(stockCursorAdapter);
        getLoaderManager().initLoader(STOCK_LOADER,null,this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String [] projection = {
                InventoryContract.InventoryEntry._ID,
                InventoryContract.InventoryEntry.Column_ITEM_NAME,
                InventoryContract.InventoryEntry.Column_ITEM_PRICE,
                InventoryContract.InventoryEntry.Column_ITEM_CATEGORY

        };
        return new CursorLoader(this, InventoryContract.InventoryEntry.CONTENT_URI, projection, null,null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        stockCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        stockCursorAdapter.swapCursor(null);
    }
}
