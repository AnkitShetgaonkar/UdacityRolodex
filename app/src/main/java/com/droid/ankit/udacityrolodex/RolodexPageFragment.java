package com.droid.ankit.udacityrolodex;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.droid.ankit.udacityrolodex.data.UserData;


/**
 * Created by Ankit on 12/20/2017.
 */

public class RolodexPageFragment extends Fragment {
    private TextView mFirstName;
    private TextView mLastName;
    private TextView mCompany;
    private TextView mStartDate;
    private TextView mBio;
    //TODO imageView
    private ImageView mAvatar;

    private static final String USER_DATA_KEY = "user_data_key";
    private ViewGroup mRootView;

    public static RolodexPageFragment newInstance(UserData userData){
        RolodexPageFragment fragment = new RolodexPageFragment();
        Bundle args = new Bundle();
        args.putSerializable(USER_DATA_KEY, userData);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(
                R.layout.pager_item, container, false);

        UserData userData = (UserData) getArguments().getSerializable(USER_DATA_KEY);
        initViews(userData);
        return mRootView;
    }

    private void initViews(UserData userData){
        mFirstName = mRootView.findViewById(R.id.tv_firstName);
        mFirstName.setText(userData.getFirstName());
        mLastName = mRootView.findViewById(R.id.tv_lastName);
        mLastName.setText(userData.getLastName());
        mCompany = mRootView.findViewById(R.id.tv_company);
        mCompany.setText(userData.getCompany());
        mStartDate = mRootView.findViewById(R.id.tv_startDate);
        mStartDate.setText(userData.getStartDate());
        mBio = mRootView.findViewById(R.id.tv_bio);
        mBio.setText(userData.getBio());
        mAvatar = mRootView.findViewById(R.id.tv_avatar);
        Glide.with(this).load(userData.getAvatar()).apply(RequestOptions.circleCropTransform()).into(mAvatar);
    }
}


