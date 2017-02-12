package ng.joeydalu.android.samples.viewpager.gui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ng.joeydalu.android.samples.viewpager.R;
import ng.joeydalu.android.samples.viewpager.gui.activity.Activity;
import ng.joeydalu.android.samples.viewpager.gui.activity.ActivityWithFragments;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentWithFragments extends Fragment {

    public static FragmentWithFragments newInstance(){
        return new FragmentWithFragments();
    }

    /** back button */
    private ImageButton btnBack;

    /** says foo */
    private ImageButton btnLogo;

    /** {@link ViewPager} for paging {@link android.support.v4.app.Fragment}'s */
    private ViewPager viewPager;

    public FragmentWithFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_with_fragments, container, false);

        //find our views
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        btnBack = (ImageButton) view.findViewById(R.id.btnBack);
        btnLogo = (ImageButton) view.findViewById(R.id.btnLogo);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        btnLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "foo :D", Toast.LENGTH_SHORT).show();
            }
        });

        //add margins to the viewpager
        viewPager.setPageMargin(4);
        viewPager.setPageMarginDrawable(R.color.black);

        //setup our viewpager in this method
        setupViewPager();
        return view;
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

        //notice we use getChildFragmentManager() as the parameter here. If this was an Activity,
        //we would use getSupportFragmentManager() instead.
        //see FragmentWithFragments

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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
                Toast.makeText(getActivity(), "Position "+position +" selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
