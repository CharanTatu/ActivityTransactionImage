/*
 * Copyright (C) 2014 The Android Open Source Project
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

package com.example.android.activityscenetransitionbasic.ui;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.android.activityscenetransitionbasic.model.Item;
import com.example.android.activityscenetransitionbasic.R;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
BroadcastReceiver broadcastReceiver = null;
     Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
//=====================Broadcast receiver==================
        broadcastReceiver = new MyReceiver();
        internetRec();

//=========================================================

//        GridView grid = findViewById(R.id.grid);
        ListView   grid = findViewById(R.id.grid);
        grid.setOnItemClickListener(mOnItemClickListener);
        GridAdapter adapter = new GridAdapter();
        grid.setAdapter(adapter);

//         button = findViewById(R.id.team_data);
//          button.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View view) {
//                  Intent activityChangeIntent  = new Intent(MainActivity.this,DataActivity.class);
//                  MainActivity.this.startActivity(activityChangeIntent );
//              }
//          });

    }

    private final AdapterView.OnItemClickListener mOnItemClickListener
            = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Item item = (Item) adapterView.getItemAtPosition(position);

            // Construct an Intent as normal
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PARAM_ID, item.getId());

            @SuppressWarnings("unchecked")
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    MainActivity.this,


                    new Pair<>(view.findViewById(R.id.imageview_item),
                            DetailActivity.VIEW_NAME_HEADER_IMAGE),
                    new Pair<>(view.findViewById(R.id.textview_name),
                            DetailActivity.VIEW_NAME_HEADER_TITLE));

            // Now we can start the Activity, providing the activity options as a bundle
            ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
            // END_INCLUDE(start_activity)
        }
    };


    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Item.ITEMS.length;
        }

        @Override
        public Item getItem(int position) {
            return Item.ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return getItem(position).getId();
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.grid_item, viewGroup, false);
            }

            final Item item = getItem(position);

            // Load the thumbnail image
            ImageView image = view.findViewById(R.id.imageview_item);
          Picasso.with(image.getContext()).load(item.getThumbnailUrl()).into(image);

//            Retrofit retrofit = new Retrofit.Builder()
//                    .baseUrl("http://localhost:8080/getall/")
//                    .build();

            // Set the TextView's contents
            TextView name = view.findViewById(R.id.textview_name);
            name.setText(item.getName());

//            TextView data = view.findViewById(R.id.team_data);
//            data.setText(item.getAuthor());

            return view;
        }
    }
    //===============================broad cast receiver======================
    public  void internetRec(){

        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }


}

