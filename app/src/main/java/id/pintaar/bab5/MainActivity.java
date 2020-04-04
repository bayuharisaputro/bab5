package id.pintaar.bab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.pintaar.bab5.adapter.RecyclerAdapter;
import id.pintaar.bab5.model.Hero;
import id.pintaar.bab5.service.api;
import id.pintaar.bab5.service.retrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button addHero;
    ProgressDialog progressDialog;
    List<Hero> heroList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    int id, team;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final api service = retrofitService.getRetrofitInstance().create(api.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("loading..");
        addHero = findViewById(R.id.btn_getHero);
        recyclerView = findViewById(R.id.recycler_hero);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter(this,heroList);
        recyclerView.setAdapter(adapter);
        id = 1;
        team = 1;
        addHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Call<Hero> call = service.getHerobyId(Integer.toString(id));
                call.enqueue(new Callback<Hero>() {
                    @Override
                    public void onResponse(Call<Hero> call, Response<Hero> response) {
                        if(heroList.size()%4 == 0) {
                            heroList.add(new Hero("", "", "team" + team,response.body().getBiography(),response.body().getImage(),"header"));
                            team++;
                        }
                        heroList.add(new Hero(response.body().getResponse(),response.body().getName(),response.body().getId(),response.body().getBiography(),response.body().getImage(),
                                "hero"));
                        adapter.notifyDataSetChanged();
                        id++;
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Hero> call, Throwable t) {

                    }
                });
            }
        });








    }

}
