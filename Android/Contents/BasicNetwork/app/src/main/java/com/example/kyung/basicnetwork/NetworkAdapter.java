package com.example.kyung.basicnetwork;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.kyung.basicnetwork.AsyncTaskExample.AsyncTaskExample;
import com.example.kyung.basicnetwork.NetworkExample.NetworkBasic;
import com.example.kyung.basicnetwork.NetworkExample.NetworkBasicOne;
import com.example.kyung.basicnetwork.NetworkExample.NetworkBasicTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyung on 2017-10-16.
 */

public class NetworkAdapter extends PagerAdapter {

    private static final int COUNT = 4;

    List<View> viewList;
    Context context;

    public NetworkAdapter(Context context){
        this.context = context;
        viewList = new ArrayList<>();
        viewList.add(new NetworkBasic(context));
        viewList.add(new NetworkBasicOne(context));
        viewList.add(new NetworkBasicTwo(context));
        viewList.add(new AsyncTaskExample(context));
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
