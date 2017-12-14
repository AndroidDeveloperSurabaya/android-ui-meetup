package me.inibukanadit.androidui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by inibukanadit on 12/14/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private ImageView mImageAvatar;
    private TextView mTextName;
    private TextView mTextMessage;
    private TextView mTextTime;

    private ContactClickListener mContactClickListener;

    public ContactViewHolder(View itemView, ContactClickListener contactClickListener) {
        super(itemView);

        mImageAvatar = itemView.findViewById(R.id.image_contact);
        mTextName = itemView.findViewById(R.id.text_contact_name);
        mTextMessage = itemView.findViewById(R.id.text_contact_message);
        mTextTime = itemView.findViewById(R.id.text_contact_time);

        mContactClickListener = contactClickListener;
    }

    public void bind(final Contact contact) {
        mImageAvatar.setImageResource(contact.getAvatar());
        mTextName.setText(contact.getName());
        mTextMessage.setText(contact.getMessage());
        mTextTime.setText(contact.getTime());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContactClickListener.onClick(contact);
            }
        });
    }

}
