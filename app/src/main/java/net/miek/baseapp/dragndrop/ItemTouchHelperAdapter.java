package net.miek.baseapp.dragndrop;

/**
 * Created by Mike Wang on 2015/11/16.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
