package com.example.csk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Squad extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PeopleAdapter peopleAdapter;
    private Button back;

    playerdetails[] details={
            new playerdetails("Shane", "Watson", "Opening Batsman", "Australia", "wa","wa"),
            new playerdetails("Faf", "du Plessis", "Opening Batsman", "South Africa", "fa","fa"),
            new playerdetails("Suresh", "Raina", "Middle Order Batsman", "India", "rai","rai"),
            new playerdetails("Ambati", "Rayudu", "Middle Order Batsman", "India", "ray","ray"),
            new playerdetails("MS", "Dhoni", "Wicket-Keeper Batsman", "India", "dh","dh"),
            new playerdetails("Kedar", "Jadhav", "Middle Order Batsman", "India", "ja","ja"),
            new playerdetails("Ravindra", "Jadeja", "All-Rounder", "India", "jad","jad"),
            new playerdetails("Dwayne", "Bravo", "All-Rounder", "West Indies", "br","br"),
            new playerdetails("Shardul", "Thakur", "Fast Bowler", "India", "sh","sh"),
            new playerdetails("Deepak", "Chahar", "Fast Bowler", "India", "ch","ch"),
            new playerdetails("Imran", "Tahir", "Spin Bowler", "South Africa", "ta","ta"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squad);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),FirstPage.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//to get data from above mentioned details of players
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
            details=(playerdetails[])extra.getSerializable("obj");

        }

        recyclerView=findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        peopleAdapter=new PeopleAdapter(details);
        recyclerView.setAdapter(peopleAdapter);

    }
}
