package ca.brocku.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] restaurants = {"Pizza Hut", "Pizza Pizza", "Dominos", "Subway", "Burger King", "Bob's Dogs", "Red Swan Pizza", "barBURRITO",
            "Spice Roots", "Montana's", "Milestones", "Golden Fish & Chips" ,
            "Harvey's", "McDonald's", "Starbucks", "NOTARESTAURANT"};

    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listview);

        //passed restaurant array
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,restaurants);
        //set adapter to listview
        listView.setAdapter(arrayAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) menuItem.getActionView();
        //prompt that shows up when user clicks the search bar
        searchView.setQueryHint("Please type the name of the restaurant");



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //this method will be called when user types in text and submits the text
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            //will call while user types when there is change in text
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}