package net.miek.baseapp.baseui;

import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.miek.baseapp.R;
import net.miek.baseapp.dragndrop.StableArrayAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Mike Wang on 2015/11/12.
 */
public class PageFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeLayout;
    private String[] mData = new String[]{"This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on",
            "This is Mike", "Random word", "Sample Text", "Another Sample words", "And it's on and on"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.pager_fragment, container, false);

        // Setup list view
        List<String> mCheeseList = Arrays.asList(mData);
        StableArrayAdapter adapter = new StableArrayAdapter(getActivity(), mCheeseList);
        RecyclerView mRecyclerView = (RecyclerView) root.findViewById(R.id.listview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);


        // Setup pull to refresh
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
                swipeLayout.setRefreshing(false);
            }
        }, 4000);
        Snackbar.make(getActivity().getCurrentFocus(), "onRefresh la~~", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
}
