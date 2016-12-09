package diogo.miranda.pert.View.Activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import diogo.miranda.pert.Adapter.AdapterAtividade;
import diogo.miranda.pert.DAO.DBHelper;
import diogo.miranda.pert.Model.Atividade;
import diogo.miranda.pert.R;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE="MESSAGE";
    public static final int REQUEST_DISPLAY = 25;
    public static final int RESULT_ADD_OK = 26;
    public static final int RESULT_DEL_OK = 27;
    public static final int RESULT_EDT_OK = 28;
    private ListView objListView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=new DBHelper(this);
        updateListView();
        objListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Atividade atividade = (Atividade) parent.getAdapter().getItem(position);

                int id_to_search = atividade.getId();
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", id_to_search);
                Intent intent = new Intent(getApplicationContext(), DisplayAtividade.class);
                intent.putExtras(dataBundle);
                startActivityForResult(intent, REQUEST_DISPLAY);
            }
        });
    }

    //--------------------------------------------------------------------------------------------------
    public void irCalculoPert (View view){
            Intent intent = new Intent(getApplicationContext(), EstimativaActivity.class);
            startActivity(intent);

    }

    //--------------------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //--------------------------------------------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId())
        {
            case R.id.item1:Bundle dataBundle = new Bundle();
                dataBundle.putInt("id", 0);

                Log.i("", "Cliquei no menu Add");
                Intent intent = new Intent(getBaseContext(),DisplayAtividade.class);
                intent.putExtras(dataBundle);

                startActivityForResult(intent, REQUEST_DISPLAY);
                return true;

            case R.id.item2:
                dataBundle = new Bundle();
                dataBundle.putInt("id", 2);

                Intent intent2 = new Intent(getBaseContext(),SobreActivity.class);
                intent2.putExtras(dataBundle);

                startActivityForResult(intent2, 2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //--------------------------------------------------------------------------------------------------

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("", "onActivityResult. Request" + requestCode + " - Result" + resultCode);
        if(requestCode == REQUEST_DISPLAY){
            if(resultCode == RESULT_ADD_OK){
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main_linearlayout_base), "Atividade Adicionada", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }

            if(resultCode == RESULT_DEL_OK){
                 Snackbar snackbar = Snackbar.make(findViewById(R.id.main_linearlayout_base), "Atividade Deletada", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }

            if(resultCode == RESULT_EDT_OK){
                Snackbar snackbar = Snackbar.make(findViewById(R.id.main_linearlayout_base), "Atividade Editada", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        }
    }

    public boolean onOptionsItemSelected2(MenuItem item) {
        switch (item.getItemId()) {
            // Id correspondente ao botão Up/Home da actionbar
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onResume() {
        super.onResume();


        updateListView();
    }
    private void updateListView(){
        ArrayList<Atividade> arrayAtividade  = db.getAllStudentContacts();
        AdapterAtividade adapterAtividade = new AdapterAtividade(this, arrayAtividade);

        // O List view que esta no Activity_Main.XML
        objListView = (ListView)findViewById(R.id.main_listview);
        objListView.setAdapter(adapterAtividade);
    }
}
