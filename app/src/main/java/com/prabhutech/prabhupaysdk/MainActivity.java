package com.prabhutech.prabhupaysdk;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.prabhutech.prabhupay_sdk.PrabhuSdk;

import java.util.HashMap;


/**
 * Sample Code for PrabhuPAY SDK
 */
public class MainActivity extends AppCompatActivity {
    Button payViaPrabhuPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        payViaPrabhuPay = findViewById(R.id.btn_pay);
        payViaPrabhuPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PrabhuSdk(
                        MainActivity.this,
                        PrabhuSdk.ENV_STAGE,
                        "jenish",
                        "Admin@123",
                        "12345777100077B",
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