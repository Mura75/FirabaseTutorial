package kz.ant.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import kz.ant.firebase.models.BeautySalon;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etPhone, etEmail, etAddress, etTimetable;

    private Button buttonCreate;

    DatabaseReference databaseReference;

    DatabaseReference drBeautySalon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();
    }

    private void initViews() {
        etName = (EditText)findViewById(R.id.etName);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etTimetable = (EditText)findViewById(R.id.etTimetable);
        etPhone = (EditText)findViewById(R.id.etPhone);
        buttonCreate = (Button)findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BeautySalon beautySalon = new BeautySalon();
                beautySalon.setName(etName.getText().toString());
                beautySalon.setAddress(etAddress.getText().toString());
                beautySalon.setEmail(etEmail.getText().toString());
                beautySalon.setTimetable(etTimetable.getText().toString());
                beautySalon.setPhone(etPhone.getText().toString());

                drBeautySalon = databaseReference.child("Salon");
                drBeautySalon.setValue(beautySalon);

                drBeautySalon.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                Toast.makeText(MainActivity.this, "Salon created", Toast.LENGTH_SHORT).show();

                etPhone.setText("");
                etAddress.setText("");
                etEmail.setText("");
                etTimetable.setText("");
                etName.setText("");
            }
        });
    }



}
