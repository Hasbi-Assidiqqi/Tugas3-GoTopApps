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

public class MenuMallSka extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] menuAwalBross = new String[]{
                "Location",
                "Info"
        };

        MenuMallSka.this.setListAdapter(new ArrayAdapter<>(MenuMallSka.this, android.R.layout.simple_list_item_1, menuAwalBross));
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
            String location = "google.navigation:q=0.4996117280634903, 101.41847703959964";
            String info = "Mall SKA Pekanbaru";

            switch (strObject) {
                case "Location" :
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
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
