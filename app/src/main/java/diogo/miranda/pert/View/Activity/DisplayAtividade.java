package diogo.miranda.pert.View.Activity;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import diogo.miranda.pert.DAO.DBHelper;
import diogo.miranda.pert.Model.Atividade;
import diogo.miranda.pert.R;

public class DisplayAtividade extends AppCompatActivity {

    int from_Where_I_Am_Coming = 0;
    private DBHelper mydb;
    TextView tv_titler;
    TextView tv_responsible;
    TextView tv_description;
    TextView tv_qtd;
    TextView tv_status;
    int id_To_Update = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_atividade);

        Log.i("", "DisplayActivity");

        tv_titler = (TextView) findViewById(R.id.edt_DisplayAtividade_Titler);
        tv_responsible = (TextView) findViewById(R.id.edt_DisplayAtividade_Responsible);
        tv_description = (TextView) findViewById(R.id.edt_DisplayAtividade_Description);
        tv_qtd = (TextView) findViewById(R.id.edt_DisplayAtividade_QTD);
        tv_status = (TextView) findViewById(R.id.edt_DisplayAtividade_Status);

        mydb = new DBHelper(this);

        Bundle extras = getIntent().getExtras();
        {
            int Value = extras.getInt("id");
            id_To_Update = Value;
            if (Value != 0) {
                //means this is the view part not the add contact part.
                Atividade atividade = mydb.getAtividadeByID(id_To_Update);

                Button b = (Button) findViewById(R.id.btn_DisplayAtividade_Salvar);
                b.setVisibility(View.INVISIBLE);

                this.tv_titler.setText((CharSequence) atividade.getTitler());
                this.tv_titler.setFocusable(false);
                this.tv_titler.setClickable(false);

                tv_responsible.setText((CharSequence) atividade.getResponsible());
                tv_responsible.setFocusable(false);
                tv_responsible.setClickable(false);

                tv_description.setText((CharSequence) atividade.getDescription());
                tv_description.setFocusable(false);
                tv_description.setClickable(false);

                tv_qtd.setText((CharSequence) atividade.getQtd().toString());
                tv_qtd.setFocusable(false);
                tv_qtd.setClickable(false);

                tv_status.setText((CharSequence) atividade.getStatus());
                tv_status.setFocusable(false);
                tv_status.setClickable(false);

            }

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int Value = extras.getInt("id");
            if (Value > 0) {
                getMenuInflater().inflate(R.menu.menu_display_contact, menu);
            } else {
                getMenuInflater().inflate(R.menu.menu_main, menu);
            }
        }
        return true;
    }


     @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.Edit_Contact:
                Button b = (Button) findViewById(R.id.btn_DisplayAtividade_Salvar);
                b.setVisibility(View.VISIBLE);
                tv_titler.setEnabled(true);
                tv_titler.setFocusableInTouchMode(true);
                tv_titler.setClickable(true);

                tv_responsible.setEnabled(true);
                tv_responsible.setFocusableInTouchMode(true);
                tv_responsible.setClickable(true);

                tv_description.setEnabled(true);
                tv_description.setFocusableInTouchMode(true);
                tv_description.setClickable(true);

                tv_qtd.setEnabled(true);
                tv_qtd.setFocusableInTouchMode(true);
                tv_qtd.setClickable(true);

                tv_status.setEnabled(true);
                tv_status.setFocusableInTouchMode(true);
                tv_status.setClickable(true);

                return true;
            case R.id.Delete_Contact:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                mydb.deleteContact(id_To_Update);
                                setResult(MainActivity.RESULT_DEL_OK);
                                finish();
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle(" Este regsitro será apagado de sua lista de Atividades ");
                d.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void saveData(View view) {

        Bundle extras = getIntent().getExtras();

            if (extras != null) {
                int Value = extras.getInt("id");
                if (Value > 0) {
                    if (mydb.updateStudentContact(id_To_Update, tv_titler.getText().toString(), tv_description.getText().toString(), tv_responsible.getText().toString(), Double.parseDouble(tv_qtd.getText().toString()), tv_status.getText().toString())) {
                        setResult(MainActivity.RESULT_EDT_OK);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sem atualização", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    if (mydb.addStudentContact(tv_titler.getText().toString(), tv_description.getText().toString(), tv_responsible.getText().toString(), Double.parseDouble(tv_qtd.getText().toString()), tv_status.getText().toString()) != -1) {
                        setResult(MainActivity.RESULT_ADD_OK);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Não adicionado", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }
            }
        }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("DisplayAtividade Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
