package me.inibukanadit.androidui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.coordinator_layout), "Please don't touch me!", Snackbar.LENGTH_SHORT).show();
            }
        });

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Aditya", "Bro, jadi kemana?!", "08:11 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Ahmad", "Keren banget kemaren PyCon-nya!", "08:14 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Chandra", "...", "08:43 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Aditya", "Bro, jadi kemana?!", "08:11 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Bagus", "Lagi dimana mas?", "08:17 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Bagus", "Lagi dimana mas?", "08:17 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Ahmad", "Keren banget kemaren PyCon-nya!", "08:14 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Aditya", "Bro, jadi kemana?!", "08:11 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Ahmad", "Keren banget kemaren PyCon-nya!", "08:14 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Chandra", "...", "08:43 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_accent, "Bagus", "Lagi dimana mas?", "08:17 PM"));
        contactList.add(new Contact(R.drawable.ic_avatar_primary, "Chandra", "...", "08:43 PM"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ContactAdapter contactAdapter = new ContactAdapter(contactList, this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(contactAdapter);

        ItemTouchHelper.Callback touchHelperCallback = new ContactTouchHelperCallback(contactAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onClick(Contact contact) {
        Toast.makeText(this, contact.getName(), Toast.LENGTH_SHORT).show();
    }

}
