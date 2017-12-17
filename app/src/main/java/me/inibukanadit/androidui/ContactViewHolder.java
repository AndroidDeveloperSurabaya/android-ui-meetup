package me.inibukanadit.androidui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by inibukanadit on 12/14/17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    // deklarasikan view dari contact yg dibuat
    private ImageView mImageAvatar;
    private TextView mTextName;
    private TextView mTextMessage;
    private TextView mTextTime;

    // deklarasikan contactClickListener
    private ContactClickListener mContactClickListener;

    // Viewholder akan mendapatkan View dan ContactClickListener
    public ContactViewHolder(View itemView, ContactClickListener contactClickListener) {
        super(itemView);

        // inisialisasi view
        mImageAvatar = itemView.findViewById(R.id.image_contact);
        mTextName = itemView.findViewById(R.id.text_contact_name);
        mTextMessage = itemView.findViewById(R.id.text_contact_message);
        mTextTime = itemView.findViewById(R.id.text_contact_time);

        // inisialisasi contactClickListener
        mContactClickListener = contactClickListener;
    }

    // fungsi ini dipanggil di ContactAdapter.onBindViewHolder( ... )
    public void bind(final Contact contact) {

        // set avatar dan text setiap view
        mImageAvatar.setImageResource(contact.getAvatar());
        mTextName.setText(contact.getName());
        mTextMessage.setText(contact.getMessage());
        mTextTime.setText(contact.getTime());

        // set onClickListener dari itemView - setiap item
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // panggil onClick
                // perhatikan bahwa MainActivity extends ContactClickListener
                // kemudian ContactClickListener (this) dipassing ke ContactAdapter
                // kontak adapter kemudian mengirim ContactClickListener ke ViewHolder ( onCreateViewHolder() )
                mContactClickListener.onClick(contact);
            }
        });
    }

}
