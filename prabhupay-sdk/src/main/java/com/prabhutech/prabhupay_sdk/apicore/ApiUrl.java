package com.prabhutech.prabhupay_sdk.apicore;


import com.prabhutech.prabhupay_sdk.BuildConfig;
import com.prabhutech.prabhupay_sdk.PrabhuSdk;

/**
 * Created by Niken on 7/30/2020.
 */
public class ApiUrl {
    public static final String baseUrl;
    static {
        if (!PrabhuSdk.isTest) {
            baseUrl = "https://sys.prabhupay.com/api/";
        } else {
            baseUrl = "https://testsys.prabhupay.com/api/";
        }

    }
    //    public final static String BaseUrl = "https://testsys.prabhupay.com/api/";

    public final static String Initiate = "EPayment/Initiate";
    public final static String trxnLogin = "EPayment/EpaymentTrxnLogin";
    public final static String trxnDetail = "EPayment/EpaymentTrxnDetail";
    public final static String trxnConfirm = "EPayment/EpaymentTrxnConfirm";
}