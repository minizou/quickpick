package mini.decision_maker;

import android.text.Editable;
import android.text.TextWatcher;

public class ViewTextWatcher implements TextWatcher {
    private final int choiceIndex;

    public ViewTextWatcher(int choiceIndex) {
        this.choiceIndex = choiceIndex;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable e) {
        String s = e.toString();
        StringsApp.setOption(choiceIndex,s);
    }
}
