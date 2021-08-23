package mini.decision_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText[] options = new EditText[5];
    private SharedPreferences sharedPreferences;

    private Button btnAdd;
    private Button btnSubtract;

    private int numChoices; // number of choices on UI at given time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences =  getPreferences(MODE_PRIVATE);

        options[0] = findViewById(R.id.option_0);
        options[1] = findViewById(R.id.option_1);
        options[2] = findViewById(R.id.option_2);
        options[3] = findViewById(R.id.option_3);
        options[4] = findViewById(R.id.option_4);

        for (int i = 0; i < options.length; i++) {
            options[i].addTextChangedListener(new ViewTextWatcher(i));
        }

        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);

        numChoices = 2;

        getPreviousChoices();
        restoreNumChoices();
    }

    @Override
    protected void onStop() {
        super.onStop();
        savePreviousChoices();
    }

    // button interaction

    public void clickAdd(View v) {
        switch(numChoices) {
            case 2:
                options[2].setVisibility(View.VISIBLE);
                options[2].setEnabled(true);
                setButton(btnSubtract,true,R.color.red);
                break;
            case 3:
                options[3].setVisibility(View.VISIBLE);
                options[3].setEnabled(true);
                break;
            case 4:
                options[4].setVisibility(View.VISIBLE);
                options[4].setEnabled(true);
                setButton(btnAdd,false,R.color.green);
                break;
        }
        numChoices++;
    }

    public void clickSubtract(View v) {
        switch(numChoices) {
            case 5:
                options[4].setVisibility(View.INVISIBLE);
                options[4].setEnabled(false);
                setButton(btnAdd,true,R.color.green);
                break;
            case 4:
                options[3].setVisibility(View.INVISIBLE);
                options[3].setEnabled(false);
                break;
            case 3:
                options[2].setVisibility(View.INVISIBLE);
                options[2].setEnabled(false);
                setButton(btnSubtract,false,R.color.red);
                break;
        }
        numChoices--;
    }

    public void clickDecide(View v) {
        Intent resultIntent = new Intent(this,ResultActivity.class);
        resultIntent.putExtra("numChoices", numChoices);
        startActivity(resultIntent);
    }

    public void clickClear(View v) {
        for (EditText option : options) {
            option.getText().clear();
        }
    }

    public void clickQuick(View v) {
        Intent quickIntent = new Intent(this,QuickActivity.class);
        startActivity(quickIntent);
    }

    private void setButton(Button b, boolean enable, int color) {
        b.setEnabled(enable);
        b.setBackgroundColor(enable ? getResources().getColor(color) :
                getResources().getColor(R.color.background_lighter_grey));
        b.setTextColor(enable ? getResources().getColor(R.color.white) :
                getResources().getColor(R.color.light_grey));
    }

    // saving/getting previous state

    private void savePreviousChoices() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < options.length; i++) {
            String choice = options[i].getText().toString();
            editor.putString("" + i,choice);
        }
        editor.putInt("numChoices",numChoices);
        editor.apply();
    }

    private void getPreviousChoices() {
        if (sharedPreferences != null) {
            for (int i = 0; i < options.length; i++) {
                options[i].setText(sharedPreferences.getString("" + i,""));
            }
        }
    }

    private void restoreNumChoices() {
        int newNumChoices = sharedPreferences.getInt("numChoices",numChoices);
        while (numChoices < newNumChoices) {
            clickAdd(btnAdd);
        }
    }
}