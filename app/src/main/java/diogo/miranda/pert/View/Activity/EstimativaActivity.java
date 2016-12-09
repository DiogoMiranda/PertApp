package diogo.miranda.pert.View.Activity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import diogo.miranda.pert.Model.CalculoPert;
import diogo.miranda.pert.R;

import java.util.HashMap;

import static android.support.v4.app.NavUtils.*;

public class EstimativaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtvalor1;
    private EditText edtvalor2;
    private EditText edtvalor3;
    private Button btncalcular;

    private CalculoPert calculoPert;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_pert);
        //ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.i("", "EstimativaActivity");
        edtvalor1 = (EditText) findViewById(R.id.edtvalor1);
        edtvalor2 = (EditText) findViewById(R.id.edtvalor2);
        edtvalor3 = (EditText) findViewById(R.id.edtvalor3);
        btncalcular = (Button) findViewById(R.id.btncalcular);
        btncalcular.setOnClickListener(this);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public void onClick(View v) {

        // Recortado para CalculoPert

        String v1 = edtvalor1.getText().toString();
        String v2 = edtvalor2.getText().toString();
        String v3 = edtvalor3.getText().toString();

        if (v1.trim().isEmpty() || v2.trim().isEmpty() || v3.trim().isEmpty()) {

            AlertDialog.Builder dig = new AlertDialog.Builder(this);
            dig.setMessage(" Existem campos vazios: ");
            dig.setNeutralButton("Ok", null);
            dig.show();

        } else {

            HashMap<String, Long> estimativas = new HashMap<>();

            estimativas.put("otimista", Long.valueOf(edtvalor1.getText().toString()));
            estimativas.put("provavel", Long.valueOf(edtvalor2.getText().toString()));
            estimativas.put("pessimista", Long.valueOf(edtvalor3.getText().toString()));

            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ResultCalcDialog dialogResult = new ResultCalcDialog().newInstance(estimativas);
            dialogResult.show(ft, "dialogResult");
 }

    }
    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EstimativaActivity Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://diogo.miranda.pert/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "EstimativaActivity Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://diogo.miranda.pert/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
