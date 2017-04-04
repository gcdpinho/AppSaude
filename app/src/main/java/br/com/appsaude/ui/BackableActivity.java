package br.com.appsaude.ui;

import android.app.ProgressDialog;
import android.support.annotation.LayoutRes;
import android.view.MenuItem;

import br.com.appsaude.util.Util;

public class BackableActivity extends BaseActivity {

    protected ProgressDialog loader;
    protected Util util;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loader = new ProgressDialog(this);
        loader.setMessage("Carregando...");
        loader.setCancelable(false);
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
