package mini.decision_maker;

import java.util.Random;

public class DecisionMaker {

    public DecisionMaker() { }

    public String getChoiceFromIndex(int index) {
        return StringsApp.getOption(index);
    }

    public int getRandomIndex(int numChoices) {
        Random random = new Random();
        return random.nextInt(numChoices);
    }
}
