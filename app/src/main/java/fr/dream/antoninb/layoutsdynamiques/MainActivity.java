package fr.dream.antoninb.layoutsdynamiques;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<User> userList = new ArrayList<>();

        userList.add(new User("Blasco", "Antonin", 18));
        userList.add(new User("Stark", "Catelyn", 49));
        userList.add(new User("Snow", "John", 32));

        for (int i = 0; i < 1000; i++){
            String nom_gen = "nom " + i;
            String prenom_gen = "prenom " + i;
            int age_gen = i;
            userList.add(new User(nom_gen , prenom_gen, age_gen));
        }

        RecyclerView recycler = findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new MyAdapter(userList, this, new MyAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                System.out.println("item cliqué" + position);
                Intent intent = new Intent(getBaseContext(), FullUserActivity.class);
                intent.putExtra("user",userList.get(position));
                startActivity(intent);
            }
        }));
    }


}
