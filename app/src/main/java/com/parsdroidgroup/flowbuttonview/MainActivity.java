package com.parsdroidgroup.flowbuttonview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.parsdroidgroup.flowbuttonview.adapters.NothingSelectedSpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView status;

    private final AdapterView.OnItemSelectedListener menuItemClickListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Log.d("menu", "position: " + position);

            //if it's equal to zero so activity started now and nothing selected.
            if (position != 0)
                status.setText(getResources().getStringArray(R.array.spinner_items)[position - 1]);

            switch (position) {
                case 1:
                    //do something
                    break;
                case 2:
                    //do something 2 :D
                    break;
                case 3:
                    //do something 3
            }

            //it's important
            spinner.setSelection(0);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set Custom toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View header = inflater.inflate(R.layout.main_header, null);
        getSupportActionBar().setCustomView(header);

        //get string array for menu items
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_items, R.layout.spinner_dropdown_item);

        /**init spinner and set adapter to {@link NothingSelectedSpinnerAdapter}**/
        spinner = (Spinner) findViewById(R.id.flowSpinner);
        spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapter,
                        R.layout.spinner_view,
                        this));
        spinner.setOnItemSelectedListener(menuItemClickListener);

        //used to show what selected. just for UI
        status = (TextView) findViewById(R.id.status);

    }

    public void flowListener(View view) {
        spinner.performClick();
    }

}
