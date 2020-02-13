package com.billbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.billbook.adapter.StockListAdapter;
import com.billbook.listneres.ItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.billbook.R;

import java.util.ArrayList;
import java.util.List;

public class StockListActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView rcStock;
    List<String> lstStock;
    StockListAdapter stockListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Stock List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rcStock = (RecyclerView) findViewById(R.id.rc_stock);
        rcStock.setLayoutManager(new LinearLayoutManager(this));
        lstStock = new ArrayList<>();
        lstStock.add("");
        lstStock.add("");
        lstStock.add("");
        lstStock.add("");
        lstStock.add("");
        stockListAdapter = new StockListAdapter(this,lstStock);
        rcStock.setAdapter(stockListAdapter);

        stockListAdapter.setItemClickListener(this);
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(StockListActivity.this,ItemListActivity.class);
        startActivity(intent);
    }
}
