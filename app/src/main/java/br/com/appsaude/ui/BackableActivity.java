package br.com.appsaude.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.view.MenuItem;

import br.com.appsaude.util.Utils;

public class BackableActivity extends BaseActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
