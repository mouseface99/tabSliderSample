package net.miek.baseapp.dragndrop;

/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.miek.baseapp.R;
import net.miek.baseapp.Utils;

import java.util.HashMap;
import java.util.List;


public class StableArrayAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mData;

    public StableArrayAdapter(Context context, List<String> objects) {
        mContext = context;
        mData = objects;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(mContext).inflate(R.layout.text_view, null);


        Log.d("MIKE", "Get view ["+position+"]");
        TextView tv = (TextView)convertView;

        int color = Utils.getColor();
        tv.setBackgroundColor(color);
        tv.setTextColor((0xFFFFFFFF - color) + 0xFF000000);
        tv.setText(mData.get(position));

        return tv;
    }
}
