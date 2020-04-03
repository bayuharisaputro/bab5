package id.pintaar.bab5.service;

import id.pintaar.bab5.model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface api {
    @GET("{id}")
    Call<Hero> getHerobyId(@Path("id") String id);


}

