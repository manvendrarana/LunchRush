package ca.brocku.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    ListView listView;
//    String[] restaurants = {"Pizza Hut", "Pizza Pizza", "Dominos", "Subway", "Burger King", "Bob's Dogs", "Red Swan Pizza", "barBURRITO",
//            "Spice Roots", "Montana's", "Milestones", "Golden Fish & Chips" ,
//            "Harvey's", "McDonald's", "Starbucks", "NOTARESTAURANT"};
//
//    ArrayAdapter<String> arrayAdapter;
//    ListView RestaurantMapsAct;

    RecyclerView views;
    ArrayList<Business> businessArrayList;
    Adapter adpt;
    String [] restaurantHeading;
    int [] imgIdList;





    @Override
    protected void onCreate(Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_main);
//
//
//        listView = findViewById(R.id.listview);
//
//
//        //pre-defined layout in android sdk
//        //restaurant string array has been passed
//        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,restaurants);
//        RestaurantMapsAct = findViewById(R.id.action_search);
//        RestaurantMapsAct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this,restaurantMap.class);
//                startActivity(i);
//
//            }
//        });
//
//
//        //set adapter to listview
//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent i = new Intent(MainActivity.this,restaurantMap.class);
//                startActivity(i);
//            }
//        });
//



        views = findViewById(R.id.restaurant_Viewer);
        views.setLayoutManager(new LinearLayoutManager(this));
        views.setHasFixedSize(true);





        businessArrayList = new ArrayList<Business>();



        adpt = new Adapter(this,businessArrayList);

        views.setAdapter(adpt);


        //restaurant headings


        restaurantHeading = new String[]

                {       " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934 ",
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,
                        " Restaurant: Mcdonald's\n Address: 123 Dealie St\n Rating: 5 Stars \n Phone: 647-332-5934" ,

                };


            //images for restaurants
            imgIdList = new int[]{
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.b,
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.b,
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.b,







            };






        addData();
























    }
    //instantiate Business objects by providing the previously declared elements
    private void addData() {
        for(int i=0; i < restaurantHeading.length;i++){
                Business b = new Business(restaurantHeading[i],imgIdList[i]);
                businessArrayList.add(b);


        }
        adpt.notifyDataSetChanged();
    }

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu,menu);
//
//        MenuItem menuItem = menu.findItem(R.id.action_search);
//
//
//        SearchView searchView = (SearchView) menuItem.getActionView();
//
//        //prompt that shows up when user clicks the search bar
//        searchView.setQueryHint("Enter Restaurant Name");
//
//
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            //this method will be called when user types in text and submits the text
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            //will call while user types when there is change in text
//            public boolean onQueryTextChange(String newText) {
//
//                arrayAdapter.getFilter().filter(newText);
//                return false;
//            }
//
//
//
//
//        });
//
//
//
//        return super.onCreateOptionsMenu(menu);
//    }
}