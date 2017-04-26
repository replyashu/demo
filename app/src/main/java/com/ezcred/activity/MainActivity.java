package com.ezcred.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ezcred.R;
import com.ezcred.adapter.ViewPageAdapter;
import com.ezcred.fragment.DemoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPageAdapter adapter;
    private final List<String> mFragmentTitleDate = new ArrayList<>();
    private final List<String> mFragmentTitleDay = new ArrayList<>();
    private final List<String> mFragmentTitleMonth = new ArrayList<>();
    private final ArrayList<String> content = new ArrayList<>();
    private final ArrayList<String> time = new ArrayList<>();

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPageAdapter(getApplicationContext(),getSupportFragmentManager());
        // Dummy Values, can be set by api if given
        mFragmentTitleDay.add("Tuesday");
        mFragmentTitleDay.add("Wednesday");
        mFragmentTitleDay.add("Thursday");
        mFragmentTitleDay.add("Friday");

        mFragmentTitleDate.add("30");
        mFragmentTitleDate.add("31");
        mFragmentTitleDate.add("1");
        mFragmentTitleDate.add("2");

        mFragmentTitleMonth.add("May");
        mFragmentTitleMonth.add("May");
        mFragmentTitleMonth.add("June");
        mFragmentTitleMonth.add("June");

        time.add("10:30\n11:30");
        time.add("10:30\n11:30");
        time.add("10:30\n11:30");

        content.add(getResources().getString(R.string.content));
        content.add(getResources().getString(R.string.content));
        content.add(getResources().getString(R.string.content));

        fragmentManager = this.getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();


        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);


        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }

    private void setupViewPager(ViewPager viewPager) {


        for(int i = 0; i < 4; i++){
            Fragment fragment = new DemoFragment();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("time",time);
            bundle.putStringArrayList("val", content);
            fragment.setArguments(bundle);

            adapter.addFrag(fragment, mFragmentTitleDay.get(i),
                    mFragmentTitleDate.get(i), mFragmentTitleMonth.get(i));
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
