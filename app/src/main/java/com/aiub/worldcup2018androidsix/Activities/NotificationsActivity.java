package com.aiub.worldcup2018androidsix.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.aiub.worldcup2018androidsix.Adapters.NotificationListAdapter;
import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsActivity extends AppCompatActivity {

    private static final String TAG = NotificationsActivity.class.getSimpleName();
    private ListView notificationsListView;
    private List<Team> teamList = new ArrayList<>();
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        getSupportActionBar().setTitle("Notifications");

        notificationsListView = findViewById(R.id.notificationsListView);
        databaseHelper = new DatabaseHelper(NotificationsActivity.this);
        teamList = databaseHelper.getALLTeams();

        //makeDataReady();

        NotificationListAdapter adapter = new NotificationListAdapter(
                NotificationsActivity.this, teamList);
        notificationsListView.setAdapter(adapter);

    }

    /*private void makeDataReady() {

        NotificationItem item = new NotificationItem(
                "http://www.criollos-france.com/wp-content/uploads/2012/11/flag-ar5.png",
                "Argentina",
                true);
        dataList.add(item);

        item = new NotificationItem(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjiDQbfTw6z7WuEe01sucUbNvKhIGxz1f_JpR-2CJwp7MCX6zJ",
                "Brazil",
                false);
        dataList.add(item);

        item = new NotificationItem(
                "http://icons.iconarchive.com/icons/custom-icon-design/flag-2/256/Germany-Flag-icon.png",
                "Germany",
                true);
        dataList.add(item);
    }*/
}
