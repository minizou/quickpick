package mini.decision_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;

public class ResultActivity extends AppCompatActivity {
    private DecisionMaker decisionMaker;
    private TextView txtChoice;
    private int numOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtChoice = findViewById(R.id.txt_choice);
        decisionMaker = new DecisionMaker();

        Intent intent = getIntent();
        numOptions = intent.getIntExtra("numOptions",numOptions);
        randomDecision();
    }

    public void randomDecision() {
        StringsApp.printOptions();
        if (numOptions > 1) {
            int index = decisionMaker.getRandomIndex(numOptions);
            String decision = decisionMaker.getChoiceFromIndex(index);

            // avoiding picking decisions the user left blank / didn't fill
            if (decision == null || decision.equals("")) {
                HashSet<Integer> indexSet = generateIndexSet();
                while (!indexSet.isEmpty() &&  (decision == null || decision.equals(""))) {
                    System.out.println(index);
                    indexSet.remove(index);
                    index = decisionMaker.getRandomIndex(numOptions);
                    decision = decisionMaker.getChoiceFromIndex(index);
                }
                if (indexSet.isEmpty()) {
                    decision = "You have not specified any choices.";
                }
            }
            txtChoice.setText(decision);
        }
    }

    private HashSet<Integer> generateIndexSet() {
        HashSet<Integer> indexSet = new HashSet<>();
        switch(numOptions) {
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

    public void clickDecide(View v) {
        randomDecision();
    }

    public void clickBack(View v) { finish(); }
}