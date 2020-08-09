package com.example.csk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csk.Profiles;

public class EditDet extends AppCompatActivity {
    private EditText e0,e1,e2,e3;
    private playerdetails[] playerdetails;
    private Button update;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_det);

        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
            playerdetails=(playerdetails[])extra.getSerializable("obj");
            position=extra.getInt("position");
        }

        e0=findViewById(R.id.e0);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        update=findViewById(R.id.button);

        e0.setText(playerdetails[position].firstName);
        e1.setText(playerdetails[position].lastName);
        e2.setText(playerdetails[position].position);
        e3.setText(playerdetails[position].country);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playerdetails[position].firstName=e0.getText().toString();
                playerdetails[position].lastName=e1.getText().toString();
                playerdetails[position].position=e2.getText().toString();
                playerdetails[position].country=e3.getText().toString();

                Intent i=new Intent(EditDet.this, Profiles.class);
                i.putExtra("obj",playerdetails).putExtra("pos",position);
                startActivity(i);
                finish();


            }
        });
    }
}
