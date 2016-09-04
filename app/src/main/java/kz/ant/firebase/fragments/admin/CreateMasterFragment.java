package kz.ant.firebase.fragments.admin;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import kz.ant.firebase.R;
import kz.ant.firebase.adapters.MasterAdapter;
import kz.ant.firebase.models.Master;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateMasterFragment extends Fragment {

    private ListView masterListView;

    private Button buttonCreateMaster;

    private Context context;

    private DatabaseReference firebaseDatabase;

    private MasterAdapter masterAdapter;

    private List<Master> masterList = new ArrayList<>();

    public CreateMasterFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_master, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance().getReference();

        masterListView = (ListView)view.findViewById(R.id.baseListview);
        buttonCreateMaster = (Button)view.findViewById(R.id.buttonCreateMaster);

        buttonCreateMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMasterDialog();
            }
        });


        firebaseDatabase.child("Service 1").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
               updateData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                updateData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }

    private void createMasterDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.setTitle("Create new master");
        dialog.setContentView(R.layout.dialog_create_master);

        final EditText etName = (EditText)dialog.findViewById(R.id.etName);
        final EditText etPhone = (EditText)dialog.findViewById(R.id.etPhone);
        final EditText etCost = (EditText)dialog.findViewById(R.id.etCost);
        final EditText etInstagramUrl = (EditText)dialog.findViewById(R.id.etInstagramUrl);
        Button buttonCreate = (Button)dialog.findViewById(R.id.buttonCreate);

        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Master master = new Master();
                master.setPhone(etPhone.getText().toString());
                master.setName(etName.getText().toString());
                master.setCost(etCost.getText().toString());
                master.setInstagramUrl(etInstagramUrl.getText().toString());
                firebaseDatabase.child("Service 1")
                        .child("Master")
                        .push()
                        .setValue(master, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                Toast.makeText(context, "Master created", Toast.LENGTH_SHORT).show();
                            }
                });
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    private void updateData(DataSnapshot dataSnapshot) {
        masterList.clear();
        Log.d("Data_snap_1", dataSnapshot.exists() + "");
        Log.d("Data_snap_2", dataSnapshot.hasChildren() + "");

        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            Master master = ds.getValue(Master.class);
            master.setName(ds.getValue(Master.class).getName());
            master.setPhone(ds.getValue(Master.class).getPhone());
            master.setInstagramUrl(ds.getValue(Master.class).getInstagramUrl());
            master.setCost(ds.getValue(Master.class).getCost());
            masterList.add(master);
        }

        if (!masterList.isEmpty()) {
            masterAdapter = new MasterAdapter(context, masterList);
            masterListView.setAdapter(masterAdapter);
        }
    }
}
