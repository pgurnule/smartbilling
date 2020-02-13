package com.billbook.ui.activity;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.billbook.R;
import com.billbook.adapter.OrderAdapter;
import com.billbook.listneres.ItemClickListener;
import com.billbook.ui.fragment_dialog.CustomerDetailDialog;
import com.billbook.ui.fragment_dialog.DiscountDialog;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity implements ItemClickListener {

    RecyclerView rcOrder;
    List<String> lstOrder;
    OrderAdapter orderAdapter;
    public final int CUSTOMIZED_REQUEST_CODE = 0x0000ffff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rcOrder = (RecyclerView)findViewById(R.id.rc_order);
        rcOrder.setLayoutManager(new LinearLayoutManager(this));
        lstOrder = new ArrayList<>();
        lstOrder.add("");
        lstOrder.add("");
        lstOrder.add("");
        lstOrder.add("");

        orderAdapter = new OrderAdapter(lstOrder,OrderActivity.this);
        rcOrder.setAdapter(orderAdapter);
        orderAdapter.setItemClickListener(this);

        findViewById(R.id.btn_add_product).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCustomScanner(view);
            }
        });
        findViewById(R.id.txt_add_cust_details).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                custDetailDialog();
            }
        });
    }
    public void scanCustomScanner(View view) {
        new IntentIntegrator(this).setOrientationLocked(false).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != CUSTOMIZED_REQUEST_CODE && requestCode != IntentIntegrator.REQUEST_CODE) {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        switch (requestCode) {
            case CUSTOMIZED_REQUEST_CODE: {
                Toast.makeText(this, "REQUEST_CODE = " + requestCode, Toast.LENGTH_LONG).show();
                break;
            }
            default:
                break;
        }

        IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);

        if(result.getContents() == null) {
            Log.d("MainActivity", "Cancelled scan");
            Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
        } else {
            Log.d("MainActivity", "Scanned");
            Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
        }
    }

    public void discountDialog() {
        FragmentManager manager = getFragmentManager();
        /**Instantiating the DialogFragment class*/
        DiscountDialog alert = new DiscountDialog();
        /**Creating a bundle object to store the selected item's index*/
        Bundle b = new Bundle();
        /**Storing the selected item's index in the bundle object */
        alert.setArguments(b);
        alert.show(manager, "alert_dialog_radio");
    }

    public void custDetailDialog() {
        FragmentManager manager = getFragmentManager();
        /**Instantiating the DialogFragment class*/
        CustomerDetailDialog alert = new CustomerDetailDialog();
        /**Creating a bundle object to store the selected item's index*/
        Bundle b = new Bundle();
        /**Storing the selected item's index in the bundle object */
        alert.setArguments(b);
        alert.show(manager, "alert_dialog_radio");
    }
    @Override
    public void itemClicked(int position) {
        discountDialog();
    }
}
