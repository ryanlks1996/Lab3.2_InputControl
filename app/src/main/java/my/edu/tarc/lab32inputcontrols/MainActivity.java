package my.edu.tarc.lab32inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    private int position;
    private double basicPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test 1 2 3
        textViewPremium.setText("");
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        spinnerAge.setOnItemSelectedListener(this);
        //create adapter, supply with value and layout
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        //layout of each value
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);

        radioGroupGender = (RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

    }

    public void calculate(View v){
        if(position==0){
            basicPremium = 50;
        }
        else if(position==1){
            basicPremium = 55;
        }
        else if(position==2){
            basicPremium = 60;
            if(radioButtonMale.isChecked()){
                basicPremium+=50;
            }
        }
        else if(position==3){
            basicPremium = 70;
            if(radioButtonMale.isChecked()){
                basicPremium+=100;
            }
            if(checkBoxSmoker.isChecked()){
                basicPremium+=100;
            }
        }
        else if(position==4){
            basicPremium = 120;
            if(radioButtonMale.isChecked()){
                basicPremium+=100;
            }
            if(checkBoxSmoker.isChecked()){
                basicPremium+=150;
            }
        }
        else if(position==5){
            basicPremium = 160;
            if(radioButtonMale.isChecked()){
                basicPremium+=50;
            }
            if(checkBoxSmoker.isChecked()){
                basicPremium+=150;
            }
        }
        else if(position==6){
            basicPremium = 200;
            if(checkBoxSmoker.isChecked()){
                basicPremium+=250;
            }
        }
        else if(position==7){
            basicPremium = 250;
            if(checkBoxSmoker.isChecked()){
                basicPremium+=250;
            }
        }

        textViewPremium.setText(getResources().getString(R.string.premium)+" RM"+basicPremium);
    }

    public void reset(View v){
        spinnerAge.setSelection(0,true);
        radioGroupGender.clearCheck();
        checkBoxSmoker.setChecked(false);
        textViewPremium.setText(getResources().getString(R.string.premium));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
        if(position==0){
            basicPremium = 50;
        }
        else if(position==1){
            basicPremium = 55;
        }
        else if(position==2){
            basicPremium = 60;
        }
        else if(position==3){
            basicPremium = 70;
        }
        else if(position==4){
            basicPremium = 120;
        }
        else if(position==5){
            basicPremium = 160;
        }
        else if(position==6){
            basicPremium = 200;
        }
        else if(position==7){
            basicPremium = 250;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textViewPremium.setText("Please select your age.");
    }
}
