package ro.pub.cs.systems.eim.practicaltest01var03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private Button plus;
    private Button minus;
    private Button second_activity;
    private EditText first_number_edit_text, second_number_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        first_number_edit_text = findViewById(R.id.first_number_edit_text);
        second_number_edit_text = findViewById(R.id.second_number_edit_text);
        plus = findViewById(R.id.plus_button);
        minus = findViewById(R.id.minus_button);
        second_activity = findViewById(R.id.second_activity_button);

        first_number_edit_text.setText(String.valueOf(1));
        second_number_edit_text.setText(String.valueOf(1));
    }
}