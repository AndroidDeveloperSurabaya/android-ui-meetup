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

    private List<Contact> mContacts;
    private ContactClickListener mContactClickListener;

    public ContactAdapter(List<Contact> contacts, ContactClickListener contactClickListener) {
        mContacts = contacts;
        mContactClickListener = contactClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_contact, null, false);
        ContactViewHolder viewHolder = new ContactViewHolder(view, mContactClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.bind(mContacts.get(position));
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mContacts, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mContacts, i, i - 1);
            }
        }

        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mContacts.remove(position);
        notifyItemRemoved(position);
    }
}
