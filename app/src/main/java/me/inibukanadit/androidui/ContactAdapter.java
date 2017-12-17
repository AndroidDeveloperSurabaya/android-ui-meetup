package me.inibukanadit.androidui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Collections;
import java.util.List;

/**
 * Created by inibukanadit on 12/14/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> implements ContactTouchHelperAdapter {

    private List<Contact> mContacts;                        // daftar contacts yg akan ditampilkan (di set di constructor)
    private ContactClickListener mContactClickListener;     // ContactClickListener

    /**
     * Contact adapter
     *
     * @param contacts
     * @param contactClickListener
     */
    public ContactAdapter(List<Contact> contacts, ContactClickListener contactClickListener) {
        mContacts = contacts;
        mContactClickListener = contactClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // ambil context dari ViewGroup utk digunakan di LayoutInflater
        Context context = parent.getContext();

        // membuat LayoutInflater utk meng-INFLATE layout XML menjadi View (java)
        LayoutInflater inflater = LayoutInflater.from(context);

        // inflating .. item_contact.xml menjadi View Object
        View view = inflater.inflate(R.layout.item_contact, null, false);

        // inisialisasi ViewHolder ,kemudian masukkan view diatas bersama dgn ContactClickListener-nya
        ContactViewHolder viewHolder = new ContactViewHolder(view, mContactClickListener);

        // kembalikan viewholder
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        // ambil kontak di posisi yg diberikan
        Contact contact = mContacts.get(position);

        // lempar kontak ke fungsi bind() milik ViewHolder
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        // kembalikan jumlah item yg akan ditampilkan
        return mContacts.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        // jika fromPosition kurang dari toPosition
        if (fromPosition < toPosition) {
            // looping dari fromPosition hingga toPosition -> kecil ke besar
            for (int i = fromPosition; i < toPosition; i++) {
                // pindahkan item index ke-i ke bawah
                Collections.swap(mContacts, i, i + 1);
            }
        } else {
            // looping dari fromPosition hingga toPosition -> besar ke kecil
            for (int i = fromPosition; i > toPosition; i--) {
                // pindahkan item index ke-i ke atas
                Collections.swap(mContacts, i, i - 1);
            }
        }

        // notify item yg dipindahkan, dari fromPOsition hingga toPosition
        // menggunakan notifyItemMoved() akan memberikan efek animasi pergerakan item
        // sebaliknya, notifySetDataChanged() tidak akan memberikan animasi
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        // hapus kontak di posisi yg diberikan
        mContacts.remove(position);

        // notifyItemRemoved() akan me-refresh item dan memberikan animasi pada RecyclerView
        notifyItemRemoved(position);
    }
}
