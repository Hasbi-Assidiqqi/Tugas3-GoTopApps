package com.example.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ListStore extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listHospital = new String[] {
                "Mall SKA",
                "Mall Living World",
                "Mall Pekanbaru",
                "Mall Senapelan plaza",
                "Mall Ciputra Seraya"
        };

        ListStore.this.setListAdapter(new ArrayAdapter<>(ListStore.this, android.R.layout.simple_list_item_1, listHospital));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Object object = getListAdapter().getItem(position);
        String strObject = object.toString();

        listHospitalClick(strObject);
    }

    private void listHospitalClick(String strObject) {
        try {
            Intent intent = null;

            switch (strObject) {
                case "Mall SKA" :
                    intent = new Intent(ListStore.this, MenuMallSka.class);
                    break;
                case "Mall Living World" :
                case "Mall Ciputra Seraya" :
                case "Mall Senapelan plaza" :
                case "Mall Pekanbaru" :
                    opsiDekembangkan();
                    break;
            }

            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void opsiDekembangkan() {
        Toast.makeText(this, "Opsi sedang dikembangkan", Toast.LENGTH_SHORT).show();
    }
}
