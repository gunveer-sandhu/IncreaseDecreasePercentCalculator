package gunveer.codes.percentinc_deccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "whatever....";
    EditText etInitial, etLater;
    TextView tvValue, tvIncDec, textView;
    Button btnCalc, btnReset;
    public double initial, later, change, incDec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInitial = findViewById(R.id.etInitial);
        etLater = findViewById(R.id.etLater);
        tvValue = findViewById(R.id.tvValue);
        tvIncDec = findViewById(R.id.tvIncDec);
        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);
        textView = findViewById(R.id.textView);



        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initial = Double.valueOf(etInitial.getText().toString());
                later = Double.valueOf(etLater.getText().toString());
                change = later - initial;
                Log.d(TAG, "Change: "+ change);

                if(change>0){
                    if(initial<0){
                        initial = 0 - initial;
                    }

                   incDec = Double.valueOf(String.format("%.3f", Double.valueOf(change/initial*100)));
                    Log.d(TAG, "incDec: "+ incDec);
                   tvValue.setText(String.valueOf(incDec));
                   tvIncDec.setText("Increase");

                }else if(change<0){
                    if(initial<0){
                        initial = 0 - initial;
                    }
                    change = 0 - change;
                    incDec = Double.valueOf(String.format("%.2f", Double.valueOf(change/initial*100)));
                    tvValue.setText(String.valueOf(incDec));
                    tvIncDec.setText("Decrease");
                }else{

                    tvValue.setText("");
                    textView.setText("");
                    tvIncDec.setText("No Change");
                    //change = 0
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etInitial.setText("");
                etLater.setText("");
                tvValue.setText("0");
                tvIncDec.setText("Inc/Dec");
                initial=0;
                later=0;
                change = 0;
                incDec = 0;
            }
        });
    }
}