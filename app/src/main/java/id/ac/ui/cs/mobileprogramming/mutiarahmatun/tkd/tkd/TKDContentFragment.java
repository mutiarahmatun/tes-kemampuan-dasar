package id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.tkd;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.R;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.OptionsView;
import id.ac.ui.cs.mobileprogramming.mutiarahmatun.tkd.view.QuestionView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TKDContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TKDContentFragment extends Fragment {

//    private NoteViewModel noteViewModel;
    private OptionsView optionsView;
    private QuestionView questionView;

    public static TKDContentFragment newInstance() {
        return new TKDContentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTKDContentBinding binding =
                FragmentTKDContentBinding.inflate(inflater, container, false);
//        noteViewModel = ViewModelProviders.of(getActivity()).get(NoteViewModel.class);
//        binding.setNoteViewModel(noteViewModel);
        optionsViewModel = ViewModelProviders.of(getActivity()).get(OptionsView.class);
        binding.setOptionsView(optionsView);
        questionView = ViewModelProviders.of(getActivity()).get(QuestionView.class);
        binding.setQuestionView(questionView);
        binding.setLifecycleOwner(this);
        binding.setTKDContentInterface(this);
        return binding.getRoot();
    }


}