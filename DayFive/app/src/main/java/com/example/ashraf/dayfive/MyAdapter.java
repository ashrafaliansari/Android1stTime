package com.example.ashraf.dayfive;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ashraf on 18/3/17.
 */

public class MyAdapter extends BaseAdapter {
   // public MyAdapter(FragmentB fragmentB, ArrayList<MyList> values) {
      public   FragmentB activity;
    public ArrayList data;
        LayoutInflater inflator;
    public MyAdapter(FragmentB customListView, ArrayList<MyList> values) {
            activity=customListView;
            data =values;
            inflator=(LayoutInflater)customListView.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view=inflator.inflate(R.layout.custom_item,null);
            TextView text1,text2;
            text1=(TextView)view.findViewById(R.id.item1);
            text2=(TextView)view.findViewById(R.id.item2);
            final MyList val= (MyList) data.get(position);
            text1.setText(val.getName());
            text2.setText(val.getPlace());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity.getActivity(),val.getName(),Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }

    }

