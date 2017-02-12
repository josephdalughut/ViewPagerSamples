package ng.joeydalu.android.samples.viewpager.gui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ng.joeydalu.android.samples.viewpager.R;
import ng.joeydalu.android.samples.viewpager.gui.fragment.NumberFragment;

public class ActivityWithFragments extends AppCompatActivity {

    /** back button */
    private ImageButton btnBack;

    /** {@link ViewPager} for paging {@link android.support.v4.app.Fragment}'s */
    private ViewPager viewPager;

    /** says foo */
    private ImageButton btnLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_fragments);

        //find views
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btnLogo = (ImageButton) findViewById(R.id.btnLogo);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityWithFragments.this, "foo :D", Toast.LENGTH_SHORT).show();
            }
        });

        //add margins to the viewpager
        viewPager.setPageMargin(4);
        viewPager.setPageMarginDrawable(R.color.black);

        //setup our viewpager in this method
        setupViewPager();
    }

    /**
     * Sets up our view pager by creating a list of fragments and attaching a {@link android.support.v4.app.FragmentPagerAdapter}
     * to the {@link ViewPager} to page through our list of fragments
     */
    private void setupViewPager(){

        //initialize empty fragment list
        final List<Fragment> fragmentList = new ArrayList<>();

        //add Fragments you want to show up in the viewpager to the list
        fragmentList.add(NumberFragment.newInstance(0));
        fragmentList.add(NumberFragment.newInstance(1));
        fragmentList.add(NumberFragment.newInstance(2));
        fragmentList.add(NumberFragment.newInstance(3));
        fragmentList.add(NumberFragment.newInstance(4));
        fragmentList.add(NumberFragment.newInstance(5));
        fragmentList.add(NumberFragment.newInstance(6));
        fragmentList.add(NumberFragment.newInstance(7));
        fragmentList.add(NumberFragment.newInstance(8));
        fragmentList.add(NumberFragment.newInstance(9));
        fragmentList.add(NumberFragment.newInstance(10));

        //then set a new FragmentPagerAdapter to the ViewPager

        //notice we use getSupportFragmentManager() as the parameter here. If this was a fragment,
        //we would use getChildFragmentManager() instead.
        //see FragmentWithFragments

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                //return the fragment in this position from our list
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                //very important. Return the size of the list / the number of fragments you are displaying.
                //if you don't, nothing would show up on your view pager
                return fragmentList.size();
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ActivityWithFragments.this, "Position "+position +" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
