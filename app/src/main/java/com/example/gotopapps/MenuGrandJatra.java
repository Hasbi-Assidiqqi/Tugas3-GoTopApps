package com.example.gotopapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class MenuGrandJatra extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] menuAwalBross = new String[]{
                "Call Center",
                "SMS",
                "Location",
                "Website",
                "Info"
        };

        MenuGrandJatra.this.setListAdapter(new ArrayAdapter<>(MenuGrandJatra.this, android.R.layout.simple_list_item_1, menuAwalBross));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object object = getListAdapter().getItem(position);
        String strObject = object.toString();

        menuAwalBross(strObject);
    }

    private void menuAwalBross(String strObject) {
        Intent intent = null;

        try {
            String phoneNumber = "0761850888";
            String greatingMessage = "Hallo, ";
            String location = "google.navigation:q=0.5314404194501895, 101.44868044939085";
            String website = "https://www.jatrahotels.com/grandjatra-pekanbaru/";
            String info = "Hotel Grand Jatra Pekanbaru";

            switch (strObject) {
                case "Call Center" :
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                    break;
                case "SMS" :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
                    intent.putExtra("sms_body", greatingMessage);
                    break;
                case "Location" :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                    break;
                case "Website" :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                    break;
                case "Info" :
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, info);
                    break;
            }

            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
