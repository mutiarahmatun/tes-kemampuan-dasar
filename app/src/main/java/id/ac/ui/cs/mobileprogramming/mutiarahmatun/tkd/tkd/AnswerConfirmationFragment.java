package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.interfaces.AnswerConfirmationInterface;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.databinding.FragmentAnswerConfirmationBinding;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.OptionsView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.NoteView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.QuestionView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.TimerView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.util.LocaleCheck;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerConfirmationFragment extends Fragment implements AnswerConfirmationInterface {

    private NoteView noteView;
    private OptionsView optionsView;
    private QuestionView questionView;
    private UserView userView;
    private TimerView timerView;

    public static AnswerConfirmationFragment newInstance() {
        return new AnswerConfirmationFragment();
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAnswerConfirmationBinding binding =
                FragmentAnswerConfirmationBinding.inflate(inflater, container, false);
        noteView = ViewModelProviders.of(getActivity()).get(NoteView.class);
        binding.setNoteView(noteView);
        optionsView = ViewModelProviders.of(getActivity()).get(OptionsView.class);
        binding.setOptionsView(optionsView);
        questionView = ViewModelProviders.of(getActivity()).get(QuestionView.class);
        userView = ViewModelProviders.of(getActivity()).get(UserView.class);
        timerView = ViewModelProviders.of(getActivity()).get(TimerView.class);

        binding.setAnswerConfirmationInterface(this);
        return binding.getRoot();
    }

    @Override
    public void cancel(){
        TKDActivity tkdActivity = (TKDActivity)getActivity();
        tkdActivity.back();
    }

    @Override
    public void confirm(){
        if (questionView.getCurrentAnswer().
                equals(optionsView.getOptionChecked().getValue())){
            userView.addPoin(TKDActivity.CORRECT_SCORE + timerView.getTime().getValue());
        }

        if (questionView.isQuestionRunsOut()){
            getFragmentManager().beginTransaction()
                    .replace(R.id.TKDContent, TKDResultFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
            return;
        }


       if (LocaleCheck.isLocaleIndonesia()){
           noteView.addToFullNote("Question:\n" +
                   questionView.getCurrentIdQuestion().getValue());
       } else {
           noteView.addToFullNote("Question:\n" +
                   questionView.getCurrentEnQuestion().getValue());
       }
       noteView.addToFullNote("Note:\n" +
               noteView.getNote().getValue());

       noteView.setNote(null);
        questionView.nextQuestion();
        optionsView.setOptionChecked(null);

        getFragmentManager().beginTransaction()
                .replace(R.id.TKDContent, TKDContentFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}