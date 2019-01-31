package com.aiub.worldcup2018androidsix.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.MainActivity;
import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private String API_URL = "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json";
    private DatabaseHelper databaseHelper;
    private String[] groupNames = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
    private List<Team> teamList = new ArrayList<>();
    private String[] flagUrl =
            {
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png"

            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        databaseHelper = new DatabaseHelper(SplashScreenActivity.this);
        teamList = databaseHelper.getALLTeams();
        if (teamList.size() == 0)
            getDataFromAPI();
        else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashScreenActivity.this,
                            MainActivity.class);
                    startActivity(intent);
                }
            }, 500);
        }
    }

    private void getDataFromAPI() {

        RequestQueue requestQueue = Volley.newRequestQueue(SplashScreenActivity.this);
        //take json object from world cup API;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, response.toString());

                try {
                    JSONArray stadiums = response.getJSONArray("stadiums");

                    for (int i = 0; i < stadiums.length(); i++) {
                        JSONObject stadiumObject = stadiums.getJSONObject(i);

                        int id = stadiumObject.getInt("id");
                        String name = stadiumObject.getString("name");
                        String city = stadiumObject.getString("city");
                        double lat = stadiumObject.getDouble("lat");
                        double lng = stadiumObject.getDouble("lng");
                        String image = stadiumObject.getString("image");
                    }

                    JSONArray teams = response.getJSONArray("teams");
                    int j = 0;
                    for (int i = 0; i < teams.length(); i++) {
                        JSONObject teamsObject = teams.getJSONObject(i);

                        int id = teamsObject.getInt("id");
                        String name = teamsObject.getString("name");
                        String fifaCode = teamsObject.getString("fifaCode");
                        if (i % 4 == 0 && i != 0) {
                            j++;
                        }
                        Team team = new Team(id, 1, name, fifaCode, groupNames[j], null);
                        databaseHelper.addTeam(team);
                    }
                    updateFlagForUrl();

                    //third party API name and json object name must be always same;
                    JSONObject groups = response.getJSONObject("groups");

                    for (int i = 0; i < groupNames.length; i++) {
                        String groupName = groupNames[i].toLowerCase();

                        JSONObject groupObject = groups.getJSONObject(groupName);

                        JSONArray matches = groupObject.getJSONArray("matches");

                        for (int k = 0; k < matches.length(); k++) {
                            JSONObject matchObject = matches.getJSONObject(k);

                            int name = matchObject.getInt("name");
                            int home_team = matchObject.getInt("home_team");
                            int away_team = matchObject.getInt("away_team");
                            int home_result = matchObject.getInt("home_result");
                            int away_result = matchObject.getInt("away_result");
                            String date = matchObject.getString("date");
                            int stadium = matchObject.getInt("stadium");
                            boolean finished = matchObject.getBoolean("finished");
                            int matchday = matchObject.getInt("matchday");
                            MatchModel matchModel = new MatchModel(name, stadium, home_team, away_team, home_result, away_result, groupName, date);
                            databaseHelper.addMatch(matchModel);
                        }
                    }
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }
        );

        requestQueue.add(jsonObjectRequest);
    }

    private void updateFlagForUrl() {
        for (int i = 0; i < flagUrl.length; i++) {
            databaseHelper.updateFlagUrl(i + 1, flagUrl[i]);
        }

    }
}
