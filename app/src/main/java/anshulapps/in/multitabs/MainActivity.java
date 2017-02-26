package anshulapps.in.multitabs;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //This is our tablayout
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;
    ArrayList<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new1);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);

        ArrayList<String> tabpage = new ArrayList();
        ArrayList<Fragment> fragmentList = new ArrayList<>();

        tabpage.add("Handyman");
        tabpage.add("Professional");
        tabpage.add("Repair");
        tabpage.add("Event");
        tabpage.add("Health");
        tabpage.add("Interests");
        tabpage.add("Beauty");
        tabpage.add("Gifting");
        int size = tabpage.size();

        for (int i = 0; i < size; i++) {

            Fragment fragment;
            fragment = new MainFragement();
            Bundle bundle = new Bundle();
            String name = tabpage.get(i);
            bundle.putString("mii", name);
            bundle.putInt("pos", i);
            fragment.setArguments(bundle);

            fragmentList.add(fragment);
        }


        for (int i = 0; i < size; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabpage.get(i)));
        }

        MainActivity.Pager adapter = new MainActivity.Pager(
                MainActivity.this,
                getSupportFragmentManager(),
                tabpage.size(),
                tabpage,
                fragmentList);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                Log.e("poss", tab.getPosition() + "");

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }





    public final class Pager extends FragmentStatePagerAdapter {
        int mNumOfTabs;
        Fragment fragment = null;
        ArrayList<String> tabname;
        ArrayList<Fragment> fragmentList;

        Bundle bundle = new Bundle();
        FragmentManager fm;
        Context context;

        public Pager(Context context, FragmentManager fm, int NumOfTabs, ArrayList<String> tabpage, ArrayList<Fragment> fragmentList) {
            super(fm);
            this.context = context;
            this.fm = fm;
            this.mNumOfTabs = NumOfTabs;
            this.tabname = tabpage;
            this.fragmentList = fragmentList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);

        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
