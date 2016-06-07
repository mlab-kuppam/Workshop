package aamir.workshop2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedHashMap;

public class add_activity extends AppCompatActivity {

    //Declaration
    EditText name,number;
    String Name,Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activity);

        //Initializtion
        name=(EditText) findViewById(R.id.name);
        number=(EditText) findViewById(R.id.number);
    }

    //method to add contact
    public void Finish(View view)
    {
        //Storing name and number
        Name=name.getText().toString();
        Number=number.getText().toString().trim();

        //Initializing Alert Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(Name.isEmpty())
        {
            //Showing message
            builder.setMessage("Enter the name");
        }
        else if(Number.isEmpty())
        {
            //Showing message
            builder.setMessage("Enter the number");
        }
        else
        {
            //changing check value
            MainActivity.check=true;

            /*//Adding to database
            MainActivity.database.execSQL("INSERT INTO contact VALUES ('" + Name +"','"+Number +"')");
            */

            //appending contacts to string
            MainActivity.contacts.append(Name+"\n"+Number+"\n\n");

            builder.setTitle("Success");
            builder.setMessage("Contact Added Successfully!!");

            //On pressing OK
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(add_activity.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();
        }

        //Displaying Alert
        builder.setTitle("Error");
        builder.show();
        return;
    }
}
