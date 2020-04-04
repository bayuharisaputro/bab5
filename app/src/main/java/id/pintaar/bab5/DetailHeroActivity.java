package id.pintaar.bab5;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailHeroActivity extends AppCompatActivity {

    TextView name, alter,pob,fapp;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.name);
        alter = findViewById(R.id.alter_egos);
        pob = findViewById(R.id.pob);
        fapp = findViewById(R.id.first_app);
        image = findViewById(R.id.image);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        name.setText(getIntent().getStringExtra("name"));
        alter.setText(getIntent().getStringExtra("alter"));
        pob.setText(getIntent().getStringExtra("pob"));
        fapp.setText(getIntent().getStringExtra("fapp"));
        Glide.with(this).load(getIntent().getStringExtra("image")).into(image);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
