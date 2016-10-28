package br.com.appsaude;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class SintomasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        designConfigurations();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/HINDGUNTUR-REGULAR.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        callVolley();
    }

    private void callVolley() {
        final TextView mTextView = (TextView) findViewById(R.id.text);
        final Context context = getApplicationContext();
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://appsaude.pe.hu/android/teste.php";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String output = "";
                        try {
                            output = new String(response.getBytes("ISO-8859-1"), "UTF-8");

                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, output, Toast.LENGTH_LONG).show();
                    //    mTextView.setText("Response is: " + response.substring(0, 300));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Erro na requisão do banco.", Toast.LENGTH_LONG).show();
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //TODO: Verificar a necessidade de imagem para backbutton do menu
        // ab.setCustomView(R.layour.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        // TextView actionBar = (TextView) findViewById(R.id.actionBarId)
    }
}
