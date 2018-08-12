package layout.CreateAssigmaent;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.enjoy.study.R;

import java.util.ArrayList;

import layout.Register.Connection;



public class CreateAssigmaent extends AppCompatActivity {

    Connection db;
ArrayList<String> arr;
    EditText start,end,details;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_assigmaent);
db = new Connection(this);
arr=new ArrayList<>();
        start=(EditText)findViewById(R.id.sdatetxt);
        end=(EditText)findViewById(R.id.edatetxt);
        details=(EditText)findViewById(R.id.datailstxt);
        spin=(Spinner)findViewById(R.id.spin);


        loadspinnerdata();
    }

    public void Create(View v){


            boolean test = db.CreateQuiz("true",start.getText().toString(),end.getText().toString(),details.getText().toString(),spin.getSelectedItem().toString());

            if (test)
                Toast.makeText(this, "Created", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show();

        empty();

    }

    public void loadspinnerdata(){


        Cursor res=db.Getquiz();

        if(res.getCount()==0){
            Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
            return;

        }


        int i=0;
        while(res.moveToNext()){

            arr.add(res.getString(2));

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        spin.setAdapter(adapter);



    }

public void empty(){

    start.setText("");
    end.setText("");
details.setText("");

}


}
