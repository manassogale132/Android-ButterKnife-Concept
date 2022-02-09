package com.example.butterknifeexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.firstNameET)
    EditText firstNameET;

    @BindView(R.id.lastNameET)
    EditText lastNameET;

    @BindView(R.id.firstNameTV)
    TextView firstNameTV;

    @BindView(R.id.secondNameTV)
    TextView secondNameTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.setTextButton)
    public void changeTextButtonClickFun() {
        firstNameTV.setText(firstNameET.getText().toString());
        secondNameTV.setText(lastNameET.getText().toString());
    }

    @OnClick(R.id.clearButton)
    public void clearButtonClickFun() {
        firstNameTV.setText("");
        secondNameTV.setText("");
    }

    @OnClick(R.id.dialogButton)
    public void dialogButtonClickFun() {
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        final View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.setView(dialogView);
        dialog.show();

        dialogView.findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //your business logic
                Toast.makeText(MainActivity.this, "Pressed OK",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialogView.findViewById(R.id.buttonCancle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed Cancle",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialogView.findViewById(R.id.closeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Pressed Close",
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}