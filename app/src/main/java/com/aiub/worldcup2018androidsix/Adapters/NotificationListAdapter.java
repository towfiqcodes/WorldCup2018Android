package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NotificationListAdapter extends BaseAdapter {

    private List<Team> teamList;
    private Context context;

    public NotificationListAdapter(Context context, List<Team> teamList) {
        this.context = context;
        this.teamList = teamList;
    }

    @Override
    public int getCount() {
        return teamList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.notification_list_item, parent, false);

        Team item = teamList.get(position);

        CircleImageView flag = view.findViewById(R.id.flagIcon);
        Picasso.get().load(item.getIcon()).into(flag);

        TextView countryName = view.findViewById(R.id.countryName);
        countryName.setText(item.getName());

        CheckBox isNotified = view.findViewById(R.id.isNotifiedCheckBox);
        if (item.getIsnotified() == 0)
            isNotified.setChecked(false);
        else
            isNotified.setChecked(true);
        isNotified.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        return view;
    }
}
