package com.example.csk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Profiles extends AppCompatActivity {
    playerdetails[] playerdetails;
    int position;
    private TextView fname,lname,pos,country;
    ImageView profileimage;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            playerdetails = (playerdetails[]) extra.getSerializable("obj");
            position = extra.getInt("pos");
        }
        fname = findViewById(R.id.fnames);
        lname = findViewById(R.id.lnames);
        pos = findViewById(R.id.positions);
        country = findViewById(R.id.countries);
        profileimage = findViewById(R.id.iv_profile);
        back = findViewById(R.id.back);

        fname.setText(playerdetails[position].firstName);
        lname.setText(playerdetails[position].lastName);
        pos.setText(playerdetails[position].position);
        country.setText(playerdetails[position].country);
        int resID = getResources().getIdentifier(playerdetails[position].imageName, "mipmap", getPackageName());
        profileimage.setImageBitmap(BitmapFactory.decodeResource(getResources(), resID));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profiles.this, Squad.class);
                i.putExtra("obj", playerdetails);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT", true);
                startActivity(i);
                finish();
            }
        });
    }

        public boolean onCreateOptionsMenu(Menu menu)
        {
            getMenuInflater().inflate(R.menu.editdetails,menu);
            return super.onCreateOptionsMenu(menu);
        }

        public boolean onOptionsItemSelected(MenuItem item)
        {
            if(item.getItemId()==R.id.ed)
            {
                Intent i=new Intent(Profiles.this,EditDet.class);
                i.putExtra("obj",playerdetails).putExtra("position",position);
                startActivity(i);
                finish();

            }
            return super.onOptionsItemSelected(item);
        }
}
