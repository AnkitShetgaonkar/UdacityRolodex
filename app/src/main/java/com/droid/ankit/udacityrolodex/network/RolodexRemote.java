package com.droid.ankit.udacityrolodex.network;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.droid.ankit.udacityrolodex.data.RolodexUsersResponse;
import com.droid.ankit.udacityrolodex.data.UserData;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ankit on 12/20/2017.
 */

public class RolodexRemote {


    private static RolodexRemote mInstance;
    private final RolodexService mRolodexService;

    private static final String TAG = RolodexRemote.class.getSimpleName();

    private RolodexRemote() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRolodexService = retrofit.create(RolodexService.class);
    }

    /**
     * singleton network class
     *
     * @return
     */
    public static RolodexRemote getInstance() {
        if (mInstance == null) {
            //if instance doesnt exist create a new one
            mInstance = new RolodexRemote();
        }
        return mInstance;
    }

    /**
     * makes and api call and fetches all rolodex data
     * @param callback
     */
    public void getRolodexData(final Callback<RolodexUsersResponse> callback) {
        if(mRolodexService == null){
            Log.d(TAG,"Something went wrong");
            callback.failure("Something went wrong");
            return;
        }

        Call<List<UserData>> rolodexCall = mRolodexService.fetchRolodex();
        rolodexCall.enqueue(new retrofit2.Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                if(!response.isSuccessful()) {
                    callback.failure("failed to fetch rolodex");
                    return;
                }
                RolodexUsersResponse rolodex  = new RolodexUsersResponse();
                rolodex.setmRolodex(response.body());
                callback.success(rolodex);
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                callback.failure("failed to fetch rolodex");
            }
        });

    }

    /**
     * network call back
     * @param <T>
     */
    public interface Callback<T> {
        void success(T t);
        void failure(String message);
    }
}
