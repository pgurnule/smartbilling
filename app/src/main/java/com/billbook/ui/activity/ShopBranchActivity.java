package com.billbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.billbook.adapter.ShopListAdapter;
import com.billbook.listneres.ItemClickListener;
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

public class ShopBranchActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView rcShopList;
    List<String> lstShops;
    ShopListAdapter shopListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_branch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Shop(Branch) List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rcShopList = (RecyclerView)findViewById(R.id.rc_shop_list);
        rcShopList.setLayoutManager(new LinearLayoutManager(this));
        lstShops = new ArrayList<>();
        lstShops.add("");
        lstShops.add("");
        lstShops.add("");
        lstShops.add("");

        shopListAdapter = new ShopListAdapter(this,lstShops);
        rcShopList.setAdapter(shopListAdapter);
        shopListAdapter.setItemClickListener(this);

        findViewById(R.id.btn_add_branch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopBranchActivity.this,AddBranchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(ShopBranchActivity.this,ShopDetailsActivity.class);
        startActivity(intent);
    }
}
