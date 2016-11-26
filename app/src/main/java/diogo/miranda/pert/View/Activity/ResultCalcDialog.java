package diogo.miranda.pert.View.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

import diogo.miranda.pert.Model.CalculoPert;
import diogo.miranda.pert.R;

import java.util.HashMap;

public class ResultCalcDialog extends DialogFragment {

    public static ResultCalcDialog newInstance(HashMap<String, Long> estimativa) {
        ResultCalcDialog f = new ResultCalcDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putSerializable("estimativa", estimativa);
        f.setArguments(args);

        return f;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_result_calc, null);
        DocumentView dvText = (DocumentView) view.findViewById(R.id.dv_result_calc);

        HashMap<String, Long> estimativas = (HashMap<String, Long>) getArguments().getSerializable("estimativa");

        CalculoPert calculoPert = new CalculoPert();
        calculoPert.setOtimista(estimativas.get("otimista"));
        calculoPert.setProvavel(estimativas.get("provavel"));
        calculoPert.setPessimista(estimativas.get("pessimista"));

        dvText.setText("Duração mais provavel da atividade: " + calculoPert.getResultado() + " dias / horas. \n\n" +
                "Desvio padrão da atividade:  " + calculoPert.getDesvioPadrao() + "\n\n" +
                "Variância é de: " + calculoPert.getVariacia());


        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Resultado")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });

        return alert.show();
    }
}
