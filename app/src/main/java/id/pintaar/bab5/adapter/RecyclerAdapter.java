package id.pintaar.bab5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.pintaar.bab5.DetailHeroActivity;
import id.pintaar.bab5.R;
import id.pintaar.bab5.model.Hero;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Hero> rvData;
    private Context context;

    public RecyclerAdapter(Context context, List<Hero> inputData) {
        this.rvData = inputData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v;
         ViewHolder vh;
         if(viewType == 0) {
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_hero, parent, false);
             vh = new FirstHolder(v);
         }
         else {
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_header, parent, false);
             vh = new SecondHolder(v);
         }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        if(rvData.get(position).getType().equals("header")) {
            final SecondHolder secondHolder = (SecondHolder) holder;
            secondHolder.header.setText(rvData.get(position).getName());


        }
        else {
            final FirstHolder firstHolder = (FirstHolder) holder;
            firstHolder.nama.setText(rvData.get(position).getBiography().getFullName());
            firstHolder.alter.setText(rvData.get(position).getBiography().getAlterEgos());
            firstHolder.pob.setText(rvData.get(position).getBiography().getPlaceOfBirth());
            firstHolder.fApp.setText(rvData.get(position).getBiography().getFirstAppearance());
            firstHolder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailHeroActivity.class);
                    intent.putExtra("name",rvData.get(position).getBiography().getFullName());
                    intent.putExtra("alter",rvData.get(position).getBiography().getAlterEgos());
                    intent.putExtra("pob",rvData.get(position).getBiography().getPlaceOfBirth());
                    intent.putExtra("fapp",rvData.get(position).getBiography().getFirstAppearance());
                    intent.putExtra("image",rvData.get(position).getImage().getUrl());
                    context.startActivity(intent);
                }
            });

        }

       //set holder

    }

    @Override
    public int getItemViewType(int position) {
        int a =0;
        if(rvData.get(position).getType().equals("header")) {
            a = 1;

        }
        return a;
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class FirstHolder extends ViewHolder {
        TextView nama,alter,pob,fApp;
        ConstraintLayout content;


        public FirstHolder(View v) {
            super(v);
            nama = v.findViewById(R.id.name);
            alter = v.findViewById(R.id.alter_egos);
            pob = v.findViewById(R.id.pob);
            fApp = v.findViewById(R.id.first_app);
            content = v.findViewById(R.id.cl_content);


        }
    }

    public class SecondHolder extends ViewHolder {

        TextView header;
        public SecondHolder(View v) {
            super(v);
            header = v.findViewById(R.id.textHeader);

            //inisiasi id view
        }
    }

}
