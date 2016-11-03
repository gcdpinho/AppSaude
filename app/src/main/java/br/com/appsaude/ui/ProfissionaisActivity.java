package br.com.appsaude.ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.appsaude.R;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ProfissionaisActivity extends BackableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profissionais);

        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        designConfigurations(message);
    }

    private void designConfigurations(String message){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.actionbar_backbutton);
        ab.setDisplayHomeAsUpEnabled(true);
        TextView actionBar = (TextView) findViewById(R.id.actionBarId);
        actionBar.setText(message);
        actionBar.setTextColor(Color.parseColor("#FFFFFF"));
    }
}
