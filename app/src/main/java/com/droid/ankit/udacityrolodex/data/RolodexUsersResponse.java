
package com.droid.ankit.udacityrolodex.data;


import java.util.List;

public class RolodexUsersResponse {

    private boolean mSuccess;
    private List<UserData> mRolodex;

    public boolean ismSuccess() {
        return mSuccess;
    }

    public void setmSuccess(boolean mSuccess) {
        this.mSuccess = mSuccess;
    }

    public List<UserData> getmRolodex() {
        return mRolodex;
    }

    public void setmRolodex(List<UserData> mRolodex) {
        this.mRolodex = mRolodex;
    }
}
