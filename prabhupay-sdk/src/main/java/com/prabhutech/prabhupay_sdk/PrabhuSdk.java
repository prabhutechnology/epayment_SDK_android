package com.prabhutech.prabhupay_sdk;

import android.content.Context;
import android.content.Intent;

import com.prabhutech.prabhupay_sdk.activity.EpaymentLoginActivity;

/**
 * Created by Niken on 7/29/2020.
 */
public class PrabhuSdk {
    private Context context;
    PrabhuCallBack callBack;

    public PrabhuSdk(Context context, PrabhuCallBack callBack) {
        this.context = context;
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
        context.startActivity(intent);
    }

    private void setCallBack(PrabhuCallBack callBack){
        this.callBack = callBack;
    }

    public interface PrabhuCallBack{
        public void isCompleted(Boolean success);
    }
}
