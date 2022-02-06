package com.prabhutech.prabhupaysdk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.prabhutech.prabhupay_sdk.PrabhuSdk;

import java.util.HashMap;
import java.util.Objects;


/**
 * Sample Code for PrabhuPAY SDK
 */
public class MainActivity extends AppCompatActivity {
    Button payViaPrabhuPay;
    TextInputLayout user,pass,voucher;
    TextInputEditText us,pa,vo;
    String username="", password = "",vouchers= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        payViaPrabhuPay = findViewById(R.id.btn_pay);

        user = findViewById(R.id.layoutUserName);
        pass = findViewById(R.id.layoutPassword);
        voucher = findViewById(R.id.layout_voucherNumber);
        us = findViewById(R.id.et_username);
        pa = findViewById(R.id.et_password);
        vo = findViewById(R.id.et_voucher);
        payViaPrabhuPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Objects.requireNonNull(us.getText()).toString().isEmpty()){
                    username = "jenish";
                }
                else
                    username = us.getText().toString();

                if (Objects.requireNonNull(pa.getText()).toString().isEmpty()){
                    password = "Admin@123";
                }
                else
                    password = pa.getText().toString();

                if (vo.getText().toString().isEmpty()){
                    vouchers = "12345777100077B";
                }
                else
                    vouchers = vo.getText().toString();

                new PrabhuSdk(
                        MainActivity.this,
                        PrabhuSdk.ENV_STAGE,
                        username,
                        password,
                        vouchers,
                        "1",
                        "Remarks for Testings", new PrabhuSdk.PrabhuCallBack() {
                    @Override
                    public void onSuccess(HashMap<String, String> response) {
                        Log.i("success", response.toString());
                    }

                    @Override
                    public void onError(HashMap<String, String> error) {
                        Log.i("error", error.toString());
                    }
                });
            }
        });
    }
}