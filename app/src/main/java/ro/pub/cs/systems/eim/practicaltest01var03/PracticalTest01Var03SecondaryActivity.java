package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {

    private Button ok, cancel;
    private TextView second_result;

    private ButtonClickListener listener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);

        second_result = findViewById(R.id.second_result_text);
        ok = findViewById(R.id.ok_button);
        cancel = findViewById(R.id.cancel_button);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("second_result_text")) {
            String val = intent.getExtras().getString("second_result_text");
            second_result.setText(val);
        }

        ok.setOnClickListener(listener);
        cancel.setOnClickListener(listener);
    }
}