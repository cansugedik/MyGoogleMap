package com.example.testgooglemap;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * Created by CANSU on 4.06.2018.
 */

public class GlobalFunctions {

    //ortak progessbar kullanımı
    public static ProgressDialog progressDialog;

    public static void getProgesbar(Activity activity, String msg) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public static void statusProgessbar(final Boolean status) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    if (status) {
                        progressDialog.cancel();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }) {

        }.start();

    }

}

