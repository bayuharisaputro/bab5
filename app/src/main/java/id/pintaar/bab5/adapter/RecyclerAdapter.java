package id.pintaar.bab5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(rvData.get(position).getType().equals("header")) {
            final FirstHolder firstHolder = (FirstHolder) holder;

        }
        else {
            final SecondHolder secondHolder = (SecondHolder) holder;

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


        public FirstHolder(View v) {
            super(v);

        }
    }

    public class SecondHolder extends ViewHolder {



        public SecondHolder(View v) {
            super(v);

            //inisiasi id view
        }
    }

}
