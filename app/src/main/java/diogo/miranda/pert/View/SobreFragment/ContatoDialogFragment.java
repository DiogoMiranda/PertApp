package diogo.miranda.pert.View.SobreFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;


import com.bluejamesbond.text.DocumentView;
import com.google.android.gms.appinvite.AppInviteInvitation;

import diogo.miranda.pert.R;
import diogo.miranda.pert.View.Activity.SobreActivity;


public class ContatoDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_layout_contato, null);
        DocumentView dvText = (DocumentView) view.findViewById(R.id.dvTexto);
        dvText.setText("Desenvolvedor, Diogo Francisco Miranda \n" +
                       "" );

        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Contato")


                .setNegativeButton("Compartilhar", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                        inviteCall();
                    }
                })
                .setPositiveButton("Não, obrigado", null);

        return alert.show();
    }

        private void inviteCall() {
            Intent intent = new AppInviteInvitation.IntentBuilder("Pert")
                    .setMessage("Visite o Perfil do Desenvolvedor no Linkedin")
                    .setDeepLink(Uri.parse("https://www.linkedin.com/in/diogo-francisco-miranda-3a06a556"))
                    .build();

            startActivityForResult(intent, SobreActivity.REQUEST_INVIDE);
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SobreActivity.REQUEST_INVIDE){
            if(resultCode == 0){
                String ids[] = AppInviteInvitation.getInvitationIds(resultCode, data);
            }
        }
    }
}
