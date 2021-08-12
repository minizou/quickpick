package mini.decision_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText option1;
    private EditText option2;
    private EditText option3;
    private EditText option4;
    private EditText option5;
    private Button btnAdd;
    private Button btnSubtract;

    private int numOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);
        option5 = findViewById(R.id.option_5);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);

        numOptions = 2;
    }

    public void clickAdd(View v) {
        switch(numOptions) {
            case 2:
                option3.setVisibility(View.VISIBLE);
                option3.setEnabled(true);
                setButton(btnSubtract,true,R.color.red);
                break;
            case 3:
                option4.setVisibility(View.VISIBLE);
                option4.setEnabled(true);
                break;
            case 4:
                option5.setVisibility(View.VISIBLE);
                option5.setEnabled(true);
                setButton(btnAdd,false,R.color.green);
                break;
        }
        numOptions++;
    }

    public void clickSubtract(View v) {
        switch(numOptions) {
            case 5:
                option5.setVisibility(View.INVISIBLE);
                option5.setEnabled(false);
                setButton(btnAdd,true,R.color.green);
                break;
            case 4:
                option4.setVisibility(View.INVISIBLE);
                option4.setEnabled(false);
                break;
            case 3:
                option3.setVisibility(View.INVISIBLE);
                option3.setEnabled(false);
                setButton(btnSubtract,false,R.color.red);
                break;
        }
        numOptions--;
    }

    public void clickDecide(View v) {
        Intent resultIntent = new Intent(this,ResultActivity.class);
        startActivity(resultIntent);
    }

    private void setButton(Button b, boolean enable, int color) {
        b.setEnabled(enable);
        b.setBackgroundColor(enable ? getResources().getColor(color) :
                getResources().getColor(R.color.background_lighter_grey));
        b.setTextColor(enable ? getResources().getColor(R.color.white) :
                getResources().getColor(R.color.light_grey));
    }
}