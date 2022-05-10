package br.com.pauloreis.trabalhoothon1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Random;

import br.com.pauloreis.trabalhoothon1.databinding.FragmentFirstBinding;
import br.com.pauloreis.trabalhoothon1.services.PhraseService;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        PhraseService phraseService = new PhraseService();

        TextView selectedPhraseText = (TextView) binding.selectedPhraseText;
        selectedPhraseText.setText(phraseService.getPhraseByIndex(0));

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    binding.previousButton.setEnabled(true);
                    selectedPhraseText.setText(phraseService.getNextPhrase());
                } catch (Exception e) {
                    binding.nextButton.setEnabled(false);
                    Toast toast = Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        binding.previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    binding.nextButton.setEnabled(true);
                    selectedPhraseText.setText(phraseService.getPreviousPhrase());
                } catch (Exception e) {
                    binding.previousButton.setEnabled(false);
                    Toast toast = Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Random random = new Random();
                    int randomNumber = random.nextInt(phraseService.getPhrases().size());

                    binding.nextButton.setEnabled(true);
                    binding.previousButton.setEnabled(true);

                    phraseService.setActualPhraseIndex(randomNumber);

                    selectedPhraseText.setText(phraseService.getPhraseByIndex(randomNumber));
                } catch (Exception e) {
                    binding.previousButton.setEnabled(false);
                    Toast toast = Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        binding.creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}