package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button plus;
    private Button minus;
    private Button second_activity;
    private EditText first_number_edit_text, second_number_edit_text;
    private TextView result;

    private ButtonClickListener listener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int first_number = 0;
            int second_number = 0;

            try{
                first_number = Integer.parseInt(first_number_edit_text.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Google Play Store is not available", Toast.LENGTH_LONG).show();
            }

            try{
                second_number = Integer.parseInt(second_number_edit_text.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Google Play Store is not available", Toast.LENGTH_LONG).show();
            }

            if (id == R.id.minus_button) {
                int res = first_number - second_number;
                result.setText(first_number + " - " + second_number + " = " + res);
            } else if (id == R.id.plus_button) {
                int res = first_number + second_number;
                result.setText(first_number + " + " + second_number + " = " + res);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("first_number_edit_text", first_number_edit_text.getText().toString());
        outState.putString("second_number_edit_text", second_number_edit_text.getText().toString());
        outState.putString("result_text", result.getText().toString());

        Toast.makeText(this, first_number_edit_text.getText().toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, second_number_edit_text.getText().toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, result.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("first_number_edit_text")) {
            first_number_edit_text.setText(savedInstanceState.getString("first_number_edit_text"));
        } else {
            first_number_edit_text.setText(String.valueOf(1));

        }

        if (savedInstanceState.containsKey("second_number_edit_text")) {
            second_number_edit_text.setText(savedInstanceState.getString("second_number_edit_text"));
        } else {
            second_number_edit_text.setText(String.valueOf(1));
        }

        if (savedInstanceState.containsKey("result_text")) {
            result.setText(savedInstanceState.getString("result_text"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        first_number_edit_text = findViewById(R.id.first_number_edit_text);
        second_number_edit_text = findViewById(R.id.second_number_edit_text);
        plus = findViewById(R.id.plus_button);
        minus = findViewById(R.id.minus_button);
        second_activity = findViewById(R.id.second_activity_button);
        result = findViewById(R.id.result_text);

        first_number_edit_text.setText(String.valueOf(1));
        second_number_edit_text.setText(String.valueOf(1));

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
    }
}