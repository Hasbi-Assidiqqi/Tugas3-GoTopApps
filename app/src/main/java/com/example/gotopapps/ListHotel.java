package com.example.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ListHotel extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listHospital = new String[] {
                "Grand Jatra Hotel Pekanbaru",
                "Pesona Hotel Pekanbaru",
                "Hotel Aryaduta Pekanbaru",
                "Hotel Novotel Pekanabaru",
                "The Premiere Hotel Pekanbaru"
        };

        ListHotel.this.setListAdapter(new ArrayAdapter<>(ListHotel.this, android.R.layout.simple_list_item_1, listHospital));
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
                case "Grand Jatra Hotel Pekanbaru" :
                    intent = new Intent(ListHotel.this, MenuGrandJatra.class);
                    break;
                case "Pesona Hotel Pekanbaru" :
                case "The Premiere Hotel Pekanbaru" :
                case "Hotel Novotel Pekanabaru" :
                case "Hotel Aryaduta Pekanbaru" :
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
