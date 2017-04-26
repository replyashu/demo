package com.ezcred.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ezcred.R;
import com.ezcred.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 25/04/17.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleDate = new ArrayList<>();
    private final List<String> mFragmentTitleDay = new ArrayList<>();
    private final List<String> mFragmentTitleMonth = new ArrayList<>();

    private Context context;

    public ViewPageAdapter(Context context, FragmentManager manager) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String day, String date, String month) {
        mFragmentList.add(fragment);
        mFragmentTitleDate.add(date);
        mFragmentTitleDay.add(day);
        mFragmentTitleMonth.add(month);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleDate.get(position);
    }

    public View getTabView(int position) {
        View tab = LayoutInflater.from(context).inflate(R.layout.tab_custom, null);
        TextView txtDate = (TextView) tab.findViewById(R.id.txtDate);
        TextView txtDay = (TextView) tab.findViewById(R.id.txtDay);
        TextView txtMonth = (TextView) tab.findViewById(R.id.txtMonth);

        txtDate.setText(mFragmentTitleDate.get(position));
        txtDay.setText(mFragmentTitleDay.get(position));
        txtMonth.setText(mFragmentTitleMonth.get(position));
        return tab;
    }

}
