package com.billbook.ui.activity;

import android.os.Bundle;

import com.billbook.adapter.ItemListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.billbook.R;

import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {

    RecyclerView rcItems;
    ItemListAdapter itemListAdapter;
    List<String> lstItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Item List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        rcItems = (RecyclerView) findViewById(R.id.rc_item_list);
        rcItems.setLayoutManager(new LinearLayoutManager(this));
        lstItems = new ArrayList<>();
        lstItems.add("");
        lstItems.add("");
        lstItems.add("");
        lstItems.add("");
        lstItems.add("");
        itemListAdapter = new ItemListAdapter(lstItems,this);
        rcItems.setAdapter(itemListAdapter);

    }

}
