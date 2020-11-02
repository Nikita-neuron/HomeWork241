package ru.samsung.itschool.book;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Вызывается при нажатии пользователем на кнопку Решить */
    public void run(View view) {
        // ax+b=c
        double a = Double.parseDouble( ((EditText)
                findViewById(R.id.a)).getText().toString());
        double b = Double.parseDouble( ((EditText)
                findViewById(R.id.b)).getText().toString());
        double c = Double.parseDouble( ((EditText)
                findViewById(R.id.c)).getText().toString());
        TextView res = (TextView) findViewById(R.id.res);
        double x1 = 0;
        double x2 = 0;

        double discriminant = Math.pow(b, 2) - 4*a*c;

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    res.setText("any");
                }
                else {
                    res.setText("none");
                }
            }
            else {
                x1 = -1 * c / b;
                res.setText(String.valueOf(x1));
            }
        } else {
            if (discriminant < 0) {
                res.setText("none");
            }
            else if (discriminant == 0) {
                x1 = ((-b + Math.sqrt(discriminant)) / (2 * a));
                res.setText(String.valueOf(x1));
            }
            else {
                x1 = ((-b + Math.sqrt(discriminant)) / (2 * a));
                x2 = ((-b - Math.sqrt(discriminant)) / (2 * a));
//                Log.d("myTag", Math.sqrt(discriminant) /( 2 * a) + "");
                res.setText(x1 + " " + x2);
            }
        }
    }

}
