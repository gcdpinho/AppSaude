package br.com.appsaude.util;

import android.content.Context;
import android.widget.Toast;

public class Util{

    public static String url = "appsaude.pe.hu/android/services";
    public static String language = ".php";

    public static Toast errorToast(String error, Context context){
        return Toast.makeText(context, error, Toast.LENGTH_SHORT);
    }



}
