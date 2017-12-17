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
        setContentView(R.layout.activity_main); // set activity_main.xml sebagai layout dari Activity ini

        // Mengambil Floating Action Button dari activity_main.xml
        // dan memberikan OnClickListener
        FloatingActionButton fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Memunculkan Snackbar di CoordinatorLayout yg ada di activity_main.xml
                Snackbar.make(findViewById(R.id.coordinator_layout), "Please don't touch me!", Snackbar.LENGTH_SHORT).show();
            }
        });

        // Menyiapkan data dummy untuk ditampilkan ke RecyclerView
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

        // (56) setup RecyclewView,
        // (57) inisialisasi VERTICAL LinearLayoutManager dan
        // (58) DividerItemDecoration utk 'garis' diantara setiap item
        // (59) inisialisasi ContactAdapter dan memasukkan Data Dummy sebelumnya ke dalam Adapter tsb, dan masukkan ContactClickListener (this)
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration verticalDividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        ContactAdapter contactAdapter = new ContactAdapter(contactList, this);

        // (62 - 64) set LayoutManager, ItemDecoration dan Adapter ke RecyclerView
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(verticalDividerItemDecoration);
        recyclerView.setAdapter(contactAdapter);

        // (67 - 69) Inisialisasi ItemTouchHelper Callback utk swipe and drag action kemudian attach ke RecyclerView
        ItemTouchHelper.Callback touchHelperCallback = new ContactTouchHelperCallback(contactAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelperCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView); // attach touchhelper callback ke recyclerview
    }

    @Override
    public void onClick(Contact contact) {
        // munculkan toast
        Toast.makeText(this, contact.getName(), Toast.LENGTH_SHORT).show();
    }

}
