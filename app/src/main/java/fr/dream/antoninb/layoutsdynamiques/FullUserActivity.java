package fr.dream.antoninb.layoutsdynamiques;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import fr.dream.antoninb.layoutsdynamiques.databinding.ActivityFullUserBinding;

public class FullUserActivity extends AppCompatActivity {

    TextView nom;
    TextView prenom;
    TextView age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_user);
        User user = (User) getIntent().getSerializableExtra("user");

        ActivityFullUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_full_user);
        binding.setUser(user);

    }


}
