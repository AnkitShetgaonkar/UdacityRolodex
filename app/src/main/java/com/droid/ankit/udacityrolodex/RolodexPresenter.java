package com.droid.ankit.udacityrolodex;


import com.droid.ankit.udacityrolodex.data.RolodexUsersResponse;
import com.droid.ankit.udacityrolodex.network.RolodexRemote;

/**
 * Created by Ankit on 12/20/2017.
 * Interacts with the remote api and notifys the view
 */

public class RolodexPresenter {
    private RolodexView mView;
    public RolodexPresenter(RolodexView view){
        this.mView = view;
    }

    public void init(){
        RolodexRemote.getInstance().getRolodexData(new RolodexRemote.Callback<RolodexUsersResponse>() {
            @Override
            public void success(RolodexUsersResponse response) {
                mView.showRolodex(response);
            }

            @Override
            public void failure(String message) {
                mView.showError(message);
            }
        });
    }
}
