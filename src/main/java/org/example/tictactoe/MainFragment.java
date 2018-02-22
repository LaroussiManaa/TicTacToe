
package org.example.tictactoe;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Laroussi on 12/01/2018.
 */

public class MainFragment extends Fragment {

   private AlertDialog mDialog;

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
      View rootView =
            inflater.inflate(R.layout.fragment_main, container, false);
      // Les boutons ici ...
      View newButton = rootView.findViewById(R.id.new_button);
      View continueButton = rootView.findViewById(R.id.continue_button);
      View aboutButton = rootView.findViewById(R.id.about_button);
      newButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(getActivity(), GameActivity.class);
            getActivity().startActivity(intent);
         }
      });
      continueButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent intent = new Intent(getActivity(), GameActivity.class);
            intent.putExtra(GameActivity.KEY_RESTORE, true);
            getActivity().startActivity(intent);
         }
      });
      aboutButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage(R.string.about_text);
            builder.setCancelable(false);
            builder.setPositiveButton(R.string.ok_label,
                  new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                        // rien
                     }
                  });
            mDialog = builder.show();
         }
      });
      return rootView;
   }

   @Override
   public void onPause() {
      super.onPause();

      // se débarasser de la boîte de dialogue
      if (mDialog != null)
         mDialog.dismiss();
   }
}
