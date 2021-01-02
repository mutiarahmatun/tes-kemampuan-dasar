package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentTkdContentBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.interfaces.TKDContentInterface;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.NoteView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.OptionsView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.QuestionView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TKDContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TKDContentFragment extends Fragment implements TKDContentInterface {

    private NoteView noteView;
    private OptionsView optionsView;
    private QuestionView questionView;

    public static TKDContentFragment newInstance() {
        return new TKDContentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTkdContentBinding binding =
                FragmentTkdContentBinding.inflate(inflater, container, false);
        noteView = ViewModelProviders.of(getActivity()).get(NoteView.class);
        binding.setNoteView(noteView);
        optionsView = ViewModelProviders.of(getActivity()).get(OptionsView.class);
        binding.setOptionsView(optionsView);
        questionView = ViewModelProviders.of(getActivity()).get(QuestionView.class);
        binding.setQuestionView(questionView);
        binding.setLifecycleOwner(this);
        binding.setTKDContentInterface(this);
        return binding.getRoot();
    }

    @Override
    public void submit() {
        if (optionsView.getOptionChecked().getValue() == null){
            showErrorAnswerNotChosen();
            return;
        }

        getFragmentManager().beginTransaction()
                .replace(R.id.TKDContent, AnswerConfirmationFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    private void showErrorAnswerNotChosen(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle(getResources().getString(R.string.no_answer));
        alertDialog.setMessage(getResources().getString(R.string.no_answer_content));

        alertDialog.setNegativeButton(getResources().getString(R.string.back_to_tkd),
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

    public void showHint(){
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            String escapedQuery = "";
            try {
                escapedQuery = URLEncoder.encode(questionView.getCurrentEnQuestion()
                        .getValue(), "UTF-8");
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Uri uri = Uri.parse("http://www.google.com/#q=" + escapedQuery);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {
            Toast.makeText(getActivity(),
                    getActivity().getResources().getString(R.string.connectivity_request),
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}