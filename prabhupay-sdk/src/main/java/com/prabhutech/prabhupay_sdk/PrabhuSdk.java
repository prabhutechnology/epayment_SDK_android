package com.prabhutech.prabhupay_sdk;

import android.content.Context;
import android.content.Intent;

import com.prabhutech.prabhupay_sdk.activity.EpaymentLoginActivity;

/**
 * Created by Niken on 7/29/2020.
 */
public class PrabhuSdk {
    public static final int ENV_LIVE = 0;
    public static final int ENV_TEST = 1;
    public static final int ENV_STAGE = 2;

    private Context context;
    public static int env;
    private String merchantId, password, inVoiceNo, totalAmount, remarks;
    PrabhuCallBack callBack;

    public PrabhuSdk(Context context, int env, String merchantId, String password, String inVoiceNo, String totalAmount, String remarks, PrabhuCallBack callBack) {
        this.context = context;
        PrabhuSdk.env = env;
        this.merchantId = merchantId;
        this.password = password;
        this.inVoiceNo = inVoiceNo;
        this.totalAmount = totalAmount;
        this.remarks = remarks;
        setCallBack(callBack);
        openActivity();
    }


    /**
     * redirects to login page
     */
    private void openActivity(){
        EpaymentLoginActivity.setPrabhuCallBack(new PrabhuCallBack() {
            @Override
            public void isCompleted(Boolean success) {
                callBack.isCompleted(success);
            }
        });
        Intent intent = new Intent(context, EpaymentLoginActivity.class);
        intent.putExtra("merchantId", merchantId);
        intent.putExtra("password", password);
        intent.putExtra("inVoiceNo", inVoiceNo);
        intent.putExtra("totalAmount", totalAmount);
        intent.putExtra("remarks", remarks);

        context.startActivity(intent);
    }

    private void setCallBack(PrabhuCallBack callBack){
        this.callBack = callBack;
    }

    public interface PrabhuCallBack{
        public void isCompleted(Boolean success);
    }
}
