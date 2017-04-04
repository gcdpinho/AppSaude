package br.com.appsaude.util;

import android.content.Context;
import android.widget.Toast;

public class Utils {

    public static Toast errorToast(String error, Context context){
        return Toast.makeText(context, error, Toast.LENGTH_SHORT);
    }

}
