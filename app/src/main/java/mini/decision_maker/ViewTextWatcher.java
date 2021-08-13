package mini.decision_maker;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class ViewTextWatcher implements TextWatcher {
    private int optionNum;

    public ViewTextWatcher(int optionNum) {
        this.optionNum = optionNum;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable e) {
        String s = e.toString();
        StringsApp.setOption(optionNum,s);
    }
}
