package com.ezcred.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezcred.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 25/04/17.
 */

public class FragmentAdapter extends RecyclerView.Adapter<FragmentAdapter.ViewHolder>{

    private Context context;
    private String [] yogaCat;
    private List<String> content;
    private List<String> date;

    public FragmentAdapter(ArrayList<String> date, ArrayList<String> content){
        this.date = date;
        this.content = content;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        ViewHolder viewHolder;
        context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.fragment_recycler_item, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTime.setText(date.get(position));
        holder.txtContent.setText(content.get(position));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTime;
        private TextView txtContent;
        private ImageView imgSchedule;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTime = (TextView) itemView.findViewById(R.id.txtTime);
            txtContent = (TextView) itemView.findViewById(R.id.txtContent);
            imgSchedule = (ImageView) itemView.findViewById(R.id.txtSchedule);

        }
    }

}
