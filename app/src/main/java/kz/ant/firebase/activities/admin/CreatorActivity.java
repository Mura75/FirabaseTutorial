package kz.ant.firebase.activities.admin;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kz.ant.firebase.R;
import kz.ant.firebase.fragments.admin.CreateMasterFragment;

public class CreatorActivity extends AppCompatActivity {

    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creator);

        if (getIntent().hasExtra("service")) {
            value = getIntent().getStringExtra("service");

            if (value.equals("service_1")) {
                createFragment(new CreateMasterFragment());
            }
            if (value.equals("service_2")) {

            }
            if (value.equals("service_3")) {

            }
        }

    }

    private void createFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}
