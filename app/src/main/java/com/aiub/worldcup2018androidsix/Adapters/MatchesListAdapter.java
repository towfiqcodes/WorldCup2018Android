package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;
import com.bumptech.glide.Glide;
import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchesListAdapter extends BaseAdapter {
    private Context context;
    private List<MatchModel> matchModelList;
    private Date date;
    private DatabaseHelper databaseHelper;

    public MatchesListAdapter(Context context, List<MatchModel> matchModelList) {
        this.context = context;
        this.matchModelList = matchModelList;
    }

    @Override
    public int getCount() {
        return matchModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /*@Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }
    */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.match_list_item,
                parent, false);
        TextView groupName = view.findViewById(R.id.groupName);
        TextView homeTeamName = view.findViewById(R.id.homeTeamName);
        TextView homeGoal = view.findViewById(R.id.homeGoal);
        TextView awayTeamName = view.findViewById(R.id.awayTeamName);
        TextView awayGoal = view.findViewById(R.id.awayGoal);
        CircleImageView homeTeamFlag = view.findViewById(R.id.homeTeamFlag);
        CircleImageView awayTeamFlag = view.findViewById(R.id.awayTeamFlag);
        RelativeTimeTextView matchTime = view.findViewById(R.id.matchTime);

        MatchModel matchModel = matchModelList.get(position);
        //matchTime.setReferenceTime( matc );
        covertStringToDate(matchModel.getMatchTime());
        matchTime.setReferenceTime(date.getTime());

        databaseHelper = new DatabaseHelper(context);
        Team homeTeam = databaseHelper.getTeam(matchModel.getHomeTeam());
        Team awayTeam = databaseHelper.getTeam(matchModel.getAwayTeam());

        groupName.setText(matchModel.getMatchStage());
        homeTeamName.setText(homeTeam.getName());
        awayTeamName.setText(awayTeam.getName());
        homeGoal.setText("" + matchModel.getHomeResult());
        awayGoal.setText("" + matchModel.getAwayResult());

        Glide.with(context).load(homeTeam.getIcon()).into(homeTeamFlag);
        Glide.with(context).load(awayTeam.getIcon()).into(awayTeamFlag);

        return view;
    }

    private void covertStringToDate(String matchTime) {
        // Date date = new Date();
        Log.e("match Time", matchTime);
        // String dtStart = "2018-06-28T18:00:00+04:00";
        String dtString = matchTime;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZ");
        try {
            date = format.parse(dtString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
