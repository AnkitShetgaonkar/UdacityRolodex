package com.droid.ankit.udacityrolodex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.droid.ankit.udacityrolodex.data.RolodexUsersResponse;
import com.droid.ankit.udacityrolodex.network.RolodexRemote;

public class RolodexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolodex);

        RolodexRemote.getInstance().getRolodexData(new RolodexRemote.Callback<RolodexUsersResponse>() {
            @Override
            public void success(RolodexUsersResponse response) {
                Toast.makeText(RolodexActivity.this, "Sucesss", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(String message) {
                Toast.makeText(RolodexActivity.this, "failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

