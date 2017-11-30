package com.jaime.jaime.apiclima;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaime.jaime.R;

import java.util.List;

/**
 * Created by Dell-PC on 29/11/2017.
 */

public class ClimaAdapter extends RecyclerView.Adapter<ClimaAdapter.ClimViewHolder> {

    private List<Clima> climaList;

    public class ClimViewHolder extends RecyclerView.ViewHolder {
        public TextView description, condition;

        public ClimViewHolder(View itemView) {
            super(itemView);
            description = (TextView) itemView.findViewById(R.id.tv_name);
            condition = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }

    public ClimaAdapter(List<Clima> climaList) {
        this.climaList = climaList;
    }

    @Override
    public ClimViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.clima_row, parent, false);

        return new ClimViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ClimViewHolder holder, int position) {
        Clima clima = climaList.get(position);
        holder.description.setText(clima.getDescription());
        holder.condition.setText(clima.getCondition());
    }

    @Override
    public int getItemCount() {
        return climaList.size();
    }

}
