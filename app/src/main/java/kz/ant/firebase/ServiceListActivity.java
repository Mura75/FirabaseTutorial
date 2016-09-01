package kz.ant.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kz.ant.firebase.models.Service;

public class ServiceListActivity extends AppCompatActivity {

    private List<Service> serviceList = new ArrayList<>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);

        listView = (ListView)findViewById(R.id.listView);
    }




}
