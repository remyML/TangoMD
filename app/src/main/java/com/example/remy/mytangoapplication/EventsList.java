package com.example.remy.mytangoapplication;

import android.content.Context;
import android.content.Intent;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class EventsList extends ActionBarActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);

        //start populate list

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.listViewEvents);

        // Create and populate a List of planet names.
        final String[] planets = new String[] { "Practica - A Puro Tango / Jue. 14/05", "Milonga - Ecuela Mayor / Sab. 16/05", "Practica - A Puro Tango / Jue. 21/05", "Milonga - Ecuela Mayor / Sab. 23/05",
                "Milonga - La Playera / Dom. 24/05", "Practica - A Puro Tango / Jue. 28/05", "Milonga - Ecuela Mayor / Sab. 30/05"};
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.event_row, planetList);

        // Add more planets. If you passed a String[] instead of a List<String>
        // into the ArrayAdapter constructor, you must not add more items.
        // Otherwise an exception will occur.
        //listAdapter.add( "Ceres" );


        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter(listAdapter);

        // end populate list

        // start event listening on list

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get selected item
                //long getSelectedItem=(long)(mainListView.getItemIdAtPosition(position));
                int getSelectedItem=(int)(mainListView.getItemIdAtPosition(position));

                String s=String.valueOf(getSelectedItem);
                String eventName = planets[getSelectedItem];
                // end get selected item

                //start display in toast
                Context context = getApplicationContext();
                //CharSequence text = "Esa es la lista!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, eventName, duration);
                toast.show();
                // end display in toast

                //start go to EventDetail activity

                Intent detailIntent = new Intent(EventsList.this, EventDetail.class);
                detailIntent.putExtra("eventName", eventName);
                startActivity(detailIntent);


                //end go to EventDetail activity



            }
        });

        // end event listening on list

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_events_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
