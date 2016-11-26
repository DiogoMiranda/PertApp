package diogo.miranda.pert.View.Activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import diogo.miranda.pert.R;
import diogo.miranda.pert.View.SobreFragment.AgradecimentoDialogFragment;
import diogo.miranda.pert.View.SobreFragment.ContatoDialogFragment;
import diogo.miranda.pert.View.SobreFragment.NotaVersaoDialogFragment;
import diogo.miranda.pert.View.SobreFragment.TecnicaPertDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SobreActivity extends AppCompatActivity {

    FragmentTransaction ft;
    public static final int REQUEST_INVIDE = 78;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        //------------------------------------------------------------------

        // Criando uma array falsa de strings com os títulos das nossas Aulas
        String[] data = {
                "Contato",
                "Técnica Pert",
                "Agradecimentos",
                "              Versão 1.11"
        };


        // Criando uma lista (ArrayList) com os dados criados acima
        List<String> listOfLastPosts = new ArrayList<String>(Arrays.asList(data));

        // Agora que já temos os dados, vamos criar um Adapter, no caso um ArrayAdapter

        ArrayAdapter<String> listOfLastPostsAdapter = new ArrayAdapter<String>(
                this, // O contexto atual
                R.layout.layout_listview, // O arquivo de layout de cada item
                R.id.list_item_post_title_textview, // O ID do campo a ser preenchido
                listOfLastPosts // A fonte dos dados
        );


        // Cria uma referência para a ListView
        ListView listView = (ListView) findViewById(R.id.list_last_posts);
        listView.setAdapter(listOfLastPostsAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    //Contato
                    case 0:
                        ft = getSupportFragmentManager().beginTransaction();
                        ContatoDialogFragment contato = new ContatoDialogFragment();
                        contato.show(ft, "dialog");

                    break;

                    //Tecnica
                    case 1:
                        ft = getSupportFragmentManager().beginTransaction();
                        TecnicaPertDialogFragment tecnica = new TecnicaPertDialogFragment();
                        tecnica.show(ft, "dialog");
                        break;

                    //Agradecimento
                    case 2:
                        ft = getSupportFragmentManager().beginTransaction();
                        AgradecimentoDialogFragment agradecimento = new AgradecimentoDialogFragment();
                        agradecimento.show(ft, "dialog");
                        break;

                    //Versao
                    case 3:
                        ft = getSupportFragmentManager().beginTransaction();
                        NotaVersaoDialogFragment versao = new NotaVersaoDialogFragment();
                        versao.show(ft, "dialog");
                        break;

                }
            }
        });

    }
}


