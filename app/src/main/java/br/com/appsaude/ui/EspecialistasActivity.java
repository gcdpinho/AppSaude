package br.com.appsaude.ui;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.appsaude.R;

public class EspecialistasActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialistas);
        designConfigurations();
    }

    private void designConfigurations() {
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText("Especialistas");
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }
}
