package me.inibukanadit.androidui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by inibukanadit on 12/14/17.
 */

public class ContactTouchHelperCallback extends ItemTouchHelper.Callback {

    private ContactTouchHelperAdapter mContactTouchHelperAdapter;

    public ContactTouchHelperCallback(ContactTouchHelperAdapter contactTouchHelperAdapter) {
        mContactTouchHelperAdapter = contactTouchHelperAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // menentukan arah mana saja yg diperbolehkan utk dilakukannya Dragging (normalnya UP - DOWN)
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;

        // menentukan arah mana saja yg diperbolehkan utk dilakukannya Swiping (normalnya START - END atau LEFT - RIGHT)
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;

        // kembalikan movement (drag / swipe) flags-nya
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // panggil onItemMove(fromPosition, toPosition)
        // ContactAdapter.onItemMove(int fromPosition, int toPosition)
        mContactTouchHelperAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // panggil onItemDismiss()
        // lihat ContactAdapter.onItemDismiss(int position)
        mContactTouchHelperAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true; // selalu kembalikan true utk enable drag
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true; // selalu kembalikan true utk enable swipe
    }
}
