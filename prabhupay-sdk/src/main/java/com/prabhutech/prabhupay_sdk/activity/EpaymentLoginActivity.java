package com.prabhutech.prabhupay_sdk.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.prabhutech.prabhupay_sdk.PrabhuSdk;
import com.prabhutech.prabhupay_sdk.R;
import com.prabhutech.prabhupay_sdk.fragment.FragElogin;

public class EpaymentLoginActivity extends AppCompatActivity {
    public static Boolean isSuccess = false;
    static PrabhuSdk.PrabhuCallBack prabhuCallBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epayment_login);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, FragElogin.newInstance(), "FRAG_SDK").commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isSuccess){
            prabhuCallBack.isCompleted(true);
        } else {
            prabhuCallBack.isCompleted(false);
        }
    }


    public static void  setPrabhuCallBack(PrabhuSdk.PrabhuCallBack callBack){
        prabhuCallBack = callBack;
    }

}