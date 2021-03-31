package com.example.gotopapps;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ListRepairCar extends ListActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] listHospital = new String[] {
                "Dealer Honda Pekan Baru",
                "HAM Auto Service",
                "Honda Kertajaya",
                "King Bengkel",
                "SS Autoshop Pekanbaru"
        };

        ListRepairCar.this.setListAdapter(new ArrayAdapter<>(ListRepairCar.this, android.R.layout.simple_list_item_1, listHospital));
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
                case "Dealer Honda Pekan Baru" :
                    intent = new Intent(ListRepairCar.this, MenuDealerHonda.class);
                    break;
                case "HAM Auto Service" :
                case "SS Autoshop Pekanbaru" :
                case "King Bengkel" :
                case "Honda Kertajaya" :
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
