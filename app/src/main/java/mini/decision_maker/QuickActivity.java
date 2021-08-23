package mini.decision_maker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.Random;

public class QuickActivity extends AppCompatActivity {
    private TextView txtChoice;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick);

        random = new Random();
        txtChoice = findViewById(R.id.txt_choice_quick);

        clickDecide(findViewById(R.id.btn_decide_quick));
    }

    public void clickDecide(View v) {
        boolean choice = random.nextBoolean();

        txtChoice.setText(choice ? "Yes" : "No");
        txtChoice.setTextColor(choice ?
                    getResources().getColor(R.color.light_green) : getResources().getColor(R.color.light_red));

        Window window = this.getWindow();
        window.setStatusBarColor(choice ?
                getResources().getColor(R.color.light_green) : getResources().getColor(R.color.light_red));
    }

    public void clickBack(View v) {
        finish();
    }
}