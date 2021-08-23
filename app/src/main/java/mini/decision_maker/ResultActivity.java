package mini.decision_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class ResultActivity extends AppCompatActivity {
    private DecisionMaker decisionMaker;
    private Button btnDecide;
    private TextView txtChoice;
    private int numChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtChoice = findViewById(R.id.txt_choice);
        btnDecide = findViewById(R.id.btn_decide_result);
        decisionMaker = new DecisionMaker();

        Intent intent = getIntent();
        numChoices = intent.getIntExtra("numChoices",numChoices);
        randomDecision();
    }

    private void randomDecision() {
        if (numChoices > 1) {
            int index = decisionMaker.getRandomIndex(numChoices);
            String decision = decisionMaker.getChoiceFromIndex(index);
            btnDecide.setEnabled(true);
            // avoiding picking decisions the user left blank / didn't fill
            if (decision == null || decision.equals("")) {
                HashSet<Integer> indexSet = generateIndexSet();
                while (!indexSet.isEmpty() &&  (decision == null || decision.equals(""))) {
                    indexSet.remove(index);
                    index = decisionMaker.getRandomIndex(numChoices);
                    decision = decisionMaker.getChoiceFromIndex(index);
                }
                if (indexSet.isEmpty()) {
                    decision = "You have not specified any choices.";
                    btnDecide.setEnabled(false);
                }
            }
            txtChoice.setText(decision);
        }
    }

    private HashSet<Integer> generateIndexSet() { // generates set of numChoices
        HashSet<Integer> indexSet = new HashSet<>();
        switch(numChoices) {
            case 5:
                indexSet.add(4);
            case 4:
                indexSet.add(3);
            case 3:
                indexSet.add(2);
            case 2:
                indexSet.add(0);
                indexSet.add(1);
        }
        return indexSet;
    }

    // button interaction

    public void clickDecide(View v) {
        randomDecision();
    }

    public void clickBack(View v) { finish(); }
}