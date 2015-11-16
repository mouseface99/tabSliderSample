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
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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


public class StableArrayAdapter extends RecyclerView.Adapter<StableArrayAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mData;

    public StableArrayAdapter(Context context, List<String> objects) {
        mContext = context;
        mData = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.text_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public CardView mCard;

        public ViewHolder(View v) {
            super(v);
            mCard = (CardView) v;
            mTextView = (TextView) v.findViewById(R.id.pager_info);
            int color = Utils.getColor();
            mTextView.setBackgroundColor(color);
            mTextView.setTextColor((0xFFFFFFFF - color) + 0xFF000000);
//            mTextView.setTextColor(Color.GRAY);
//            mTextView.setBackgroundColor(Color.WHITE);
        }
    }
}
