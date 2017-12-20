package com.droid.ankit.udacityrolodex.network;

import com.droid.ankit.udacityrolodex.data.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ankit on 12/20/2017.
 */
public interface RolodexService {
     @GET("CardData.json")
     Call<List<UserData>> fetchRolodex();
}
