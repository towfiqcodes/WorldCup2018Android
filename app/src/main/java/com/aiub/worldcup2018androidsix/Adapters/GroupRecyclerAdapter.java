package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.NavigationDrawerFragments.GroupDetailsFragment;
import com.aiub.worldcup2018androidsix.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupRecyclerAdapter extends
        RecyclerView.Adapter<GroupRecyclerAdapter.MyViewHolder> {

    private List<List<Team>> groupList;
    private String[] groupNames;
    private Context context;

    public GroupRecyclerAdapter(Context context, List<List<Team>> groupList, String[] groupNames) {
        this.groupList = groupList;
        this.groupNames = groupNames;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final int index = position;
        holder.groupName.setText("Group " + groupNames[index]);
        Picasso.get().load(groupList.get(position).get(0).getIcon()).into(holder.flagOne);
        Picasso.get().load(groupList.get(position).get(1).getIcon()).into(holder.flagTwo);
        Picasso.get().load(groupList.get(position).get(2).getIcon()).into(holder.flagThree);
        Picasso.get().load(groupList.get(position).get(3).getIcon()).into(holder.flagFour);
        holder.matchesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();// data passing one fragment to another fragment;
                GroupDetailsFragment groupDetailsFragment = new GroupDetailsFragment();
                bundle.putString("groupSelectedName", groupNames[index]);
                groupDetailsFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.replace(R.id.framlayout, groupDetailsFragment);
                fragmentTransaction.commit();

                ((AppCompatActivity) context).getSupportActionBar().setTitle("Group " + groupNames[index]);

            }
        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView groupName, matchesText, tablesText;
        CircleImageView flagOne, flagTwo, flagThree, flagFour;

        public MyViewHolder(View itemView) {
            super(itemView);

            groupName = itemView.findViewById(R.id.groupName);
            matchesText = itemView.findViewById(R.id.matchesText);
            tablesText = itemView.findViewById(R.id.tableText);
            flagOne = itemView.findViewById(R.id.flagOne);
            flagTwo = itemView.findViewById(R.id.flagTwo);
            flagThree = itemView.findViewById(R.id.flagThree);
            flagFour = itemView.findViewById(R.id.flagFour);
        }
    }
}
