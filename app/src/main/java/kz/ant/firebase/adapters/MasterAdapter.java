package kz.ant.firebase.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import kz.ant.firebase.R;
import kz.ant.firebase.models.Master;

/**
 * Created by Murager on 04.09.2016.
 */
public class MasterAdapter extends BaseAdapter {

    private Context context;

    private List<Master> masterList;

    public MasterAdapter(Context context, List<Master> masterList) {
        this.context = context;
        this.masterList = masterList;
    }


    @Override
    public int getCount() {
        return masterList.size();
    }

    @Override
    public Object getItem(int i) {
        return masterList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_item_master, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.tvMasterName = (TextView) view.findViewById(R.id.tvMasterName);
            viewHolder.tvMasterPhone = (TextView) view.findViewById(R.id.tvMasterPhone);
            viewHolder.tvMasterInstagram = (TextView) view.findViewById(R.id.tvMasterInstagram);
            viewHolder.tvMasterCost = (TextView) view.findViewById(R.id.tvMasterCost);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder)view.getTag();
        }
        Master master = masterList.get(i);
        Log.d("Master_info", master.toString());
        viewHolder.tvMasterName.setText(master.getName());
        viewHolder.tvMasterPhone.setText(master.getPhone());
        viewHolder.tvMasterInstagram.setText(master.getInstagramUrl());
        viewHolder.tvMasterCost.setText(master.getCost());

        return view;
    }

    private class ViewHolder {
        TextView tvMasterName, tvMasterPhone, tvMasterInstagram, tvMasterCost;
    }
}
