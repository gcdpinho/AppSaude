package br.com.appsaude.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import br.com.appsaude.R;
import br.com.appsaude.util.Utils;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity {

    Button btnConnect;
    Button btnAlreadyConnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        designConfigurations();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/HINDGUNTUR-REGULAR.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        btnConnect = (Button) findViewById(R.id.connect);
        btnAlreadyConnect = (Button) findViewById(R.id.alreadyConnect);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startSintomas();
            }
        });
        btnAlreadyConnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startSintomas();
            }
        });

    }

    private void designConfigurations() {
        //Logo aleatório a cada abertura do app
        final int[] photos={R.drawable.logo_vertical_azul, R.drawable.logo_vertical_verde,R.drawable.logo_vertical_vermelho};
        final ImageView image= (ImageView) findViewById(R.id.logo);
        final Random ran=new Random();
        int i=ran.nextInt(photos.length);
        image.setImageResource(photos[i]);
    }

    private void startSintomas(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting()) {
            Intent intent = new Intent(this, SintomasActivity.class);
            this.startActivity(intent);
        }
        else
            Utils.errorToast("Falha na conexão com a Internet. Tente novamente mais tarde.", getApplicationContext()).show();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else {
            Intent intent = new Intent(this, SintomasActivity.class);
            this.startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
