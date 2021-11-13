package com.example.adidas;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class WorkoutsAdapter extends BaseAdapter {

    private List<Model> lista;

    public WorkoutsAdapter(List<Model> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.item_workouts, parent, false);

        TextView tv_TimeAndDifficulty = item.findViewById(R.id.tv_TimeDifficulty);
        TextView tv_Title = item.findViewById(R.id.tv_Title);
        ImageView iv_Workout = item.findViewById(R.id.imageView);
        TextView tv_Tag1 = item.findViewById(R.id.tvTag1);
        TextView tv_Tag2 = item.findViewById(R.id.tvTag2);

        Model current = lista.get(position);
        String timeAndDifficulty = current.getTime() + " min - " + current.getDifficulty();
        tv_TimeAndDifficulty.setText(timeAndDifficulty);
        tv_Title.setText(current.getTitle());
        iv_Workout.setImageResource(current.getImage());
        tv_Tag1.setText(current.getTags()[0]);
        tv_Tag2.setText(current.getTags()[1]);
        return item;
    }

    public void updateList(List<Model> listaNoua){
        this.lista.clear();
        this.lista.addAll(listaNoua);
        notifyDataSetChanged();
    }
}
