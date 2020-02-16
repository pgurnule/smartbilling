package com.billbook.ui.activity;

import android.os.Bundle;

import com.billbook.controller.ShopRegistrationController;
import com.billbook.model.request.Address;
import com.billbook.model.request.Branch;
import com.billbook.model.request.ShopDetails;
import com.billbook.observer.ShopRegistrationObserver;
import com.billbook.util.VU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Toast;

import com.billbook.R;

import java.util.ArrayList;
import java.util.List;

public class ShopRegistrationActivity extends AppCompatActivity implements ShopRegistrationObserver {

    private EditText edShopName,edOwnerName,edOwnerMobile,edOwnerEmail,edArea,edLandMark,edCity,edState,edPincode;
    private ProgressBar progressBar;
    private Button btnSubmit;
    private ScrollView scrMainLayout;
    private ShopRegistrationController shopRegistrationController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_registration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.register_shop));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initUI();

    }

    private void initUI() {
        edShopName = (EditText) findViewById(R.id.editTextShopName);
        edOwnerName = (EditText) findViewById(R.id.editTextOwnerName);
        edOwnerMobile = (EditText) findViewById(R.id.editTextOwnerMobile);
        edOwnerEmail = (EditText) findViewById(R.id.editTextEmail);
        edArea = (EditText) findViewById(R.id.edArea);
        edLandMark = (EditText) findViewById(R.id.edLandmark);
        edCity = (EditText) findViewById(R.id.edCity);
        edState = (EditText) findViewById(R.id.edState);
        edPincode = (EditText) findViewById(R.id.edPincode);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        btnSubmit = (Button) findViewById(R.id.btn_register);
        scrMainLayout = (ScrollView) findViewById(R.id.scroll_main_layout);

        shopRegistrationController = new ShopRegistrationController(this,this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    scrMainLayout.setVisibility(View.GONE);
                    progressBar.setVisibility(View.VISIBLE);
                    shopRegistrationController.sendDataToServer(setData());
                }
            }
        });
    }



    public boolean validate(){
        int flg = 0;

        if(VU.isEmpty(edShopName)){
            flg = 1;
            edShopName.requestFocus();
            edShopName.setError("Please Enter Shop Name");
        }else if(VU.isEmpty(edOwnerName)){
            flg = 1;
            edOwnerName.requestFocus();
            edOwnerName.setError("Please Enter Owner Name");
        }else if(VU.isEmpty(edOwnerMobile)){
            flg = 1;
            edOwnerMobile.requestFocus();
            edOwnerMobile.setError("Please Enter Mobile");
        }else if(VU.isContactNo(edOwnerMobile)){
            flg = 1;
            edOwnerMobile.requestFocus();
            edOwnerMobile.setError("Please Enter Valid Mobile");
        }else if(VU.isEmpty(edOwnerEmail)){
            flg = 1;
            edOwnerEmail.requestFocus();
            edOwnerEmail.setError("Please Enter Email");
        }else if(VU.isEmailId(edOwnerEmail)){
            flg = 1;
            edOwnerEmail.requestFocus();
            edOwnerEmail.setError("Please Enter Valid Email");
        }else if(VU.isEmpty(edArea)){
            flg = 1;
            edArea.requestFocus();
            edArea.setError("Please Enter Area");
        }else if(VU.isEmpty(edLandMark)){
            flg = 1;
            edLandMark.requestFocus();
            edLandMark.setError("Please Enter Landmark");
        }else if(VU.isEmpty(edCity)){
            flg = 1;
            edCity.requestFocus();
            edCity.setError("Please Enter City");
        }else if(VU.isEmpty(edPincode)){
            flg = 1;
            edPincode.requestFocus();
            edPincode.setError("Please Enter Pincode");
        }else if(VU.isEmpty(edState)){
           flg = 1;
           edState.requestFocus();
           edState.setError("Please Enter State");
        }

        if(flg>0)
            return false;
        else
            return true;
    }

    @Override
    public void onSuccess() {
        scrMainLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Shop data Saved Successfully", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        scrMainLayout.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Server Error Please Try again", Toast.LENGTH_SHORT).show();

    }

    public ShopDetails setData(){

        /* Set Address  details */
        Address address = new Address();
        address.setLevel1("");
        address.setLevel2("");
        address.setLevel3("");
        address.setArea(edArea.getText().toString().trim());
        address.setLandMark(edLandMark.getText().toString().toString());
        address.setCity(edCity.getText().toString().trim());
        address.setPin(Integer.parseInt(edPincode.getText().toString().trim()));
        address.setState(edState.getText().toString().trim());




        /* Set Branch Details */
        Branch branch = new Branch();
        branch.setAddress(address);
        branch.setOwnerName(edOwnerName.getText().toString().trim());
        branch.setPhoneNumber(1);
        branch.setShopDetails(new ShopDetails());
        branch.setShopName(edShopName.getText().toString().trim());

        List<Branch> lstBranch = new ArrayList<>();
        lstBranch.add(branch);


        ShopDetails shopDetails = new ShopDetails();
        shopDetails.setShopName(edShopName.getText().toString().trim());
        shopDetails.setPhoneNumber(Long.parseLong(edOwnerMobile.getText().toString().trim()));
        shopDetails.setOwnerName(edOwnerName.getText().toString().trim());
        shopDetails.setModifiedBy("");
        shopDetails.setBranchs(lstBranch);

        return shopDetails;

    }
}
