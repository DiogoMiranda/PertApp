package diogo.miranda.pert.View.SobreFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;

import com.bluejamesbond.text.DocumentView;
import diogo.miranda.pert.R;

/**
 * Created by Diogo Miranda on 01/11/2016.
 */

public class TecnicaPertDialogFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_layout_tecnica, null);
        DocumentView dvTecnicaTexto1 = (DocumentView) view.findViewById(R.id.dvTecnicaTexto1);
        DocumentView dvTecnicaTexto2 = (DocumentView) view.findViewById(R.id.dvTecnicaTexto2);
        ImageView imgTecnicaPert = (ImageView) view.findViewById(R.id.imgTecnicaFormulaPert);


        dvTecnicaTexto1.setText("A técnica PERT tem por objetivo descobrir a duração de uma tarefa baseando-se em três estimativas possíveis para uma determinada atividade: estimativa Otimista (O), Pessimista (P), e mais Provável (MP). .\n" +
                ". Otimista = É o cenário perfeito, onde tudo dá certo.\n" +
                ". Pessimista = É o pior cenário, onde tudo vai dar errado.\n" +
                ". Mais Provável = É um cenário razoável, onde tudo ficará dentro da normalidade, sem grandes surpresas (nem boas nem ruins).\n\n" +
                "Fórmula do cálculo PERT:\n");


        dvTecnicaTexto2.setText("Esta fórmula aplica um peso maior para a estimativa Mais Provável, mas não deixa de considerar as estimativas Pessimista e Otimista. .\n" +
                "Mesmo em posse da estimativa mais provável, elemento com maior peso na média ponderada, existem duas outras informações muito importantes a serem consideradas, as estimativas Otimista e Pessimista, as quais podem estar muito afastadas da média calculada. Para medir como os elementos estão espalhados em volta da média existem duas outras medidas estatísticas: variância e desvio padrão.\n" +
                "Variância: É uma medida que indica o quão longe os valores se encontram de um valor esperado.\n" +
                "Desvio Padrão: Serve para medir o quanto de variação ou dispersão existe em relação à média, e sua forma se estabelece pela raiz quadrada da variância de cada atividade.");


        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Técnica")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return alert.show();
    }
}
