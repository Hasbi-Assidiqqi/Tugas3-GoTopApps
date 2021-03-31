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

public class MenuAwalBross extends ListActivity {
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

        MenuAwalBross.this.setListAdapter(new ArrayAdapter<>(MenuAwalBross.this, android.R.layout.simple_list_item_1, menuAwalBross));
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
            String phoneNumber = "076147333";
            String greatingMessage = "Hallo, ";
            String location = "google.navigation:q=0.463823.101.390353";
            String website = "http://awalbros.com/branch/pekanbaru/";
            String info = "Rumah Sakit Awal Bross Pekanbaru";

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
