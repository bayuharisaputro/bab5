package id.pintaar.bab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import id.pintaar.bab5.model.Hero;
import id.pintaar.bab5.service.api;
import id.pintaar.bab5.service.retrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private List<Hero> heroList;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final api service = retrofitService.getRetrofitInstance().create(api.class);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("loading..");
        heroList = new ArrayList<>();





    }

}
