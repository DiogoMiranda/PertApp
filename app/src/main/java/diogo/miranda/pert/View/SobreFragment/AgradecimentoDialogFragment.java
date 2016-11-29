package diogo.miranda.pert.View.SobreFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.bluejamesbond.text.DocumentView;
import diogo.miranda.pert.R;

/**
 * Created by Diogo Miranda on 01/11/2016.
 */

public class AgradecimentoDialogFragment extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_layout, null);
        DocumentView dvText = (DocumentView) view.findViewById(R.id.dvTexto);

        dvText.setText("Romante Ezer Rodrigues - Orientador. \n" +
                       "Hugo Thomaz Souza - Desenvolvimento. \n" +
                       "Mateus Araujo - Design.");


        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Agradecimentos")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return alert.show();
    }
}
