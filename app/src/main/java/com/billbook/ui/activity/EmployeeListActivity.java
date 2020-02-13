package com.billbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.billbook.adapter.EmployeeListAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.billbook.R;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {
    RecyclerView rcEmployee;
    EmployeeListAdapter employeeListAdapter;
    List<String> lstEmployee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Employee List");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rcEmployee = (RecyclerView) findViewById(R.id.rc_employee);
        rcEmployee.setLayoutManager(new LinearLayoutManager(this));

        lstEmployee = new ArrayList<>();
        lstEmployee.add("");
        lstEmployee.add("");
        lstEmployee.add("");
        lstEmployee.add("");
        lstEmployee.add("");

        employeeListAdapter = new EmployeeListAdapter(lstEmployee,this);
        rcEmployee.setAdapter(employeeListAdapter);

        findViewById(R.id.btn_add_employee).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeListActivity.this,EmployeeRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
