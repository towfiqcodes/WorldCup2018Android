package com.aiub.worldcup2018androidsix.ViewPagerFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aiub.worldcup2018androidsix.Adapters.MatchesListAdapter;
import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.R;

import java.util.ArrayList;
import java.util.List;

public class MatchesFragment extends Fragment {

    private DatabaseHelper databaseHelper;
    private List<MatchModel> matchList = new ArrayList<>();
    private ListView matchListView;


    public MatchesFragment() {
        // Required empty public constructor
    }

    public void onCreate(@Nullable Bundle savaInstanceState) {

        super.onCreate(savaInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
        matchList = databaseHelper.getALLMatches();
        Log.e("MatchesFragment", "" + matchList.size());

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matches, container, false);
        matchListView = view.findViewById(R.id.matchListView);
        MatchesListAdapter matchesListAdapter = new MatchesListAdapter(getActivity(), matchList);
        matchListView.setAdapter(matchesListAdapter);

        return view;
    }
}
