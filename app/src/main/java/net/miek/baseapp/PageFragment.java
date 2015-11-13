package net.miek.baseapp;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mike Wang on 2015/11/12.
 */
public class PageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.pager_fragment, container, false);

        TextView tv = (TextView)root.findViewById(R.id.pager_info);

        int color = Utils.getColor();
        root.setBackgroundColor(color);
        tv.setTextColor((0xFFFFFFFF - color) + 0xFF000000);

        if(tv != null)
            tv.setText("This is " + getArguments().getString("page_info"));

        return root;
    }
}
