package kz.ant.firebase.activities.admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kz.ant.firebase.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseReference databaseReference;

    private Button buttonService1, buttonService2, buttonService3, buttonService4, buttonService5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // databaseReference = FirebaseDatabase.getInstance().getReference();
        bindViews();
    }


    private void bindViews() {
        buttonService1 = (Button)findViewById(R.id.buttonService1);
        buttonService2 = (Button)findViewById(R.id.buttonService2);
        buttonService3 = (Button)findViewById(R.id.buttonService3);
        buttonService4 = (Button)findViewById(R.id.buttonService4);
        buttonService5 = (Button)findViewById(R.id.buttonService5);

        buttonService1.setOnClickListener(this);
        buttonService2.setOnClickListener(this);
        buttonService3.setOnClickListener(this);
        buttonService4.setOnClickListener(this);
        buttonService5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, CreatorActivity.class);
        switch (view.getId()) {
            case R.id.buttonService1: {
                intent.putExtra("service", "service_1");
                break;
            }
            case R.id.buttonService2: {
                intent.putExtra("service", "service_2");
                break;
            }
            case R.id.buttonService3: {
                intent.putExtra("service", "service_3");
                break;
            }
            case R.id.buttonService4: {
                intent.putExtra("service", "service_4");
                break;
            }
            case R.id.buttonService5: {
                intent.putExtra("service", "service_5");
                break;
            }
            default: {
                break;
            }
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}
