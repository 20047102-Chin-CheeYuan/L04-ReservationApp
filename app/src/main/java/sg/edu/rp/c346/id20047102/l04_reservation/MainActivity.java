package sg.edu.rp.c346.id20047102.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobile;
    EditText numPax;
    Button btConfirm;
    Button btClear;
    DatePicker dp;
    TimePicker tp;
    CheckBox cbSmoker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editInputName);
        mobile = findViewById(R.id.editInputMobile);
        numPax = findViewById(R.id.editInputNumPax);
        btConfirm = findViewById(R.id.buttonConfirm);
        btClear = findViewById(R.id.buttonClear);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        cbSmoker = findViewById(R.id.checkBoxSmoker);

        dp.updateDate(2020, 5, 1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);


        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker v, int hourOfDay, int minute) {

            }
        });

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkSmoke;
                if (cbSmoker.isChecked()) {
                    checkSmoke = "Yes";
                } else {
                    checkSmoke = "No";
                }

                int month = dp.getMonth() + 1;
                String clock;

                if (tp.getCurrentHour() >= 0 && tp.getCurrentHour() < 12) {
                    clock = "AM";
                } else {
                    clock = "PM";
                }

                if (name.getText().toString().trim().length() != 0 && mobile.getText().toString().trim().length() != 0 && numPax.getText().toString().trim().length() != 0) {

                    String text = String.format("Booking Success!\nName: %s\nPhone: %s\nPax: %s\nSmoking: %s\nDate: %d/%d/%d\nTime: %d:%d%s", name.getText(),mobile.getText(),numPax.getText(),checkSmoke,dp.getDayOfMonth(),month,dp.getYear(),tp.getCurrentHour(),tp.getCurrentMinute(),clock);

                    Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "Booking failed!\nPlease fill in all the necessary details!", Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.setText("");
                mobile.setText("");
                numPax.setText("");
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);

                Toast toast = Toast.makeText(MainActivity.this, "Cleared!", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
    }
}