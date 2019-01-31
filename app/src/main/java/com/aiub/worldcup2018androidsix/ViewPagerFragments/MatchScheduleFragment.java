package com.aiub.worldcup2018androidsix.ViewPagerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiub.worldcup2018androidsix.Adapters.GroupRecyclerAdapter;
import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchScheduleFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<List<Team>> groupList = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private List<Team> teamList = new ArrayList<>();
    private String[] groupNames = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};

    public MatchScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
        teamList = databaseHelper.getALLTeams();

        prepareDataFromSQLite();
        // prepareData();
    }

    private void prepareDataFromSQLite() {
        for (int i = 0; i < groupNames.length; i++) {
            List<Team> group = new ArrayList();

            group = databaseHelper.getTeamsByGroup(groupNames[i]);
            groupList.add(group);
            Log.e("GroupName: ", groupNames[i]);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_schedule, container, false);

        recyclerView = view.findViewById(R.id.groupRecyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);

        recyclerView.setLayoutManager(gridLayoutManager);

        GroupRecyclerAdapter groupRecyclerAdapter =
                new GroupRecyclerAdapter(getActivity(), groupList, groupNames);
        recyclerView.setAdapter(groupRecyclerAdapter);

        return view;
    }
   /* private void prepareData() {

        List<Team> group = new ArrayList();
        Team team = new Team(1, "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png", "Russia", "RUS");
        group.add(team);

        team = new Team(2,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                        "Saudi Arabia", "KSA");
        group.add(team);

        team = new Team(3,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                        "Egypt", "EGY");
        group.add(team);

        team = new Team(4,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                        "Uruguay", "URU");
        group.add(team);

        groupList.add(group);

        group = new ArrayList();
        team = new Team(5, "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png", "Russia", "RUS");
        group.add(team);

        team = new Team(6,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                        "Saudi Arabia", "KSA");
        group.add(team);

        team = new Team(7,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                        "Egypt", "EGY");
        group.add(team);

        team = new Team(8,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                        "Uruguay", "URU");
        group.add(team);

        groupList.add(group);
    }
*/
}
