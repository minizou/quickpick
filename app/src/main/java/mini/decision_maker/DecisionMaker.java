package mini.decision_maker;

import java.util.Random;

public class DecisionMaker {

    public DecisionMaker() { }

    public String getChoiceFromIndex(int index) {
        String choice = StringsApp.getOption(index);
        return choice;
    }

    public int getRandomIndex(int numOptions) {
        Random random = new Random();
        int randomIndex = random.nextInt(numOptions);
        System.out.println("getRandomIndex: " + randomIndex + " | NumOptions: " + numOptions);
        return randomIndex;
    }
}
