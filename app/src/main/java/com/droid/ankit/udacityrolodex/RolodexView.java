package com.droid.ankit.udacityrolodex;

import com.droid.ankit.udacityrolodex.data.RolodexUsersResponse;

/**
 * Created by Ankit on 12/20/2017.
 */

public interface RolodexView {
    void showRolodex(RolodexUsersResponse response);
    void showError(String message);

}
