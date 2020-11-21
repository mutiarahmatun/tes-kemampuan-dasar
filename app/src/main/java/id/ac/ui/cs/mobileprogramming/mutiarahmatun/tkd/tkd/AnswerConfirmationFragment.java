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
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.QuestionView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.TimerView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.UserView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerConfirmationFragment extends Fragment implements AnswerConfirmationInterface {

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
//        noteViewModel = ViewModelProviders.of(getActivity()).get(NoteViewModel.class);
//        binding.setNoteViewModel(noteViewModel);
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
        TKDActivity quizActivity = (TKDActivity)getActivity();
        quizActivity.back();
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


//        if (LocaleCheck.isLocaleIndonesia()){
//            noteViewModel.addToFullNote("Question:\n" +
//                    questionViewModel.getCurrentIdQuestion().getValue());
//        } else {
//            noteViewModel.addToFullNote("Question:\n" +
//                    questionViewModel.getCurrentEnQuestion().getValue());
//        }
//        noteViewModel.addToFullNote("Note:\n" +
//                noteViewModel.getNote().getValue());

//        noteViewModel.setNote(null);
        questionView.nextQuestion();
        optionsView.setOptionChecked(null);

        getFragmentManager().beginTransaction()
                .replace(R.id.TKDContent, TKDContentFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}