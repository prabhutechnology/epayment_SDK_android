package com.prabhutech.prabhupaysdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.prabhutech.prabhupay_sdk.PrabhuSdk;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;


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
                new PrabhuSdk(MainActivity.this, PrabhuSdk.ENV_LIVE, "<MerchantId>", "<Password>", "<Invoice No.>", "<Total Amount>", "<Remarks>", new PrabhuSdk.PrabhuCallBack() {
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