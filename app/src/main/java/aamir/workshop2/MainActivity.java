package aamir.workshop2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaring Variables
    TextView show;
    static StringBuilder contacts=new StringBuilder();

    //Database Part
    //static SQLiteDatabase database;

    static boolean check=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialising Variables
        show= (TextView)findViewById(R.id.showContacts);

        //if Contact Added, Displaying
        if(check)
            Show();//method to display

        //Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating intent to move do Add activity
                Intent intent= new Intent(MainActivity.this,add_activity.class);
                startActivity(intent);
            }
        });

        /*//Database initializations
        database=openOrCreateDatabase("Contacts", Context.MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS contact( name VARCHAR[140],  phoneNumber VARCHAR[10])");
        */
    }

    public void Show()
    {

        /* // DATABASE method of Displaying
        StringBuilder contacts=new StringBuilder();

        Cursor cursor=database.rawQuery("SELECT name,phoneNumber FROM contact",null);
        cursor.moveToFirst();
        do{
            //appending to String Builder
            contacts.append(cursor.getString(0)+"\n"+cursor.getString(1)+"\n\n");
        }while(cursor.moveToNext());//moving to next row

        //closing Cursor
        cursor.close();
        */
        //Setting text in TextView
        show.setText(contacts);
    }

    //the method below are not necessary
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
