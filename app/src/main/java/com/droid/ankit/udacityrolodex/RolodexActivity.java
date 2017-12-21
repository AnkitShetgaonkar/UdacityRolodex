package com.droid.ankit.udacityrolodex;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.droid.ankit.udacityrolodex.data.RolodexUsersResponse;
import com.droid.ankit.udacityrolodex.data.UserData;

import java.util.ArrayList;
import java.util.List;

public class RolodexActivity extends AppCompatActivity implements RolodexView {

    private RolodexPresenter mPresenter;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private List<RolodexPageFragment> mRolodexPageFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolodex);
        mPresenter = new RolodexPresenter(this);
        mPager = findViewById(R.id.rolodexPager);
        mPresenter.init();
    }

    @Override
    public void showRolodex(RolodexUsersResponse response) {
        createRolodexFragments(response.getmRolodex());
        // Instantiate a ViewPager and a PagerAdapter.
        mPagerAdapter = new ScreenSlidePagerAdapter(mRolodexPageFragments,getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(RolodexActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * create the fragments list from the list of userdata(rolodex)
     * @param userDataList
     */
    public void createRolodexFragments(List<UserData> userDataList){
        mRolodexPageFragments = new ArrayList<>();
        for (UserData userData: userDataList) {
            mRolodexPageFragments.add(RolodexPageFragment.newInstance(userData));
        }
    }
}

