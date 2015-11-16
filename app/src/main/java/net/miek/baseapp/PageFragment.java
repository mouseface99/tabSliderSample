package net.miek.baseapp;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mike Wang on 2015/11/12.
 */
public class PageFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeLayout;
    private TextView mTV;
    private String info;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.pager_fragment, container, false);

        mTV = (TextView) root.findViewById(R.id.pager_info);

        int color = Utils.getColor();
        root.setBackgroundColor(color);
        mTV.setTextColor((0xFFFFFFFF - color) + 0xFF000000);

        info = getArguments().getString("page_info");

        if (mTV != null)
            mTV.setText("This is " + info);


        swipeLayout = (SwipeRefreshLayout) root.findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return root;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mTV.setText("This is " + info);
                swipeLayout.setRefreshing(false);
            }
        }, 5000);
        mTV.setText("onRefresh !!!!!");
    }
}
