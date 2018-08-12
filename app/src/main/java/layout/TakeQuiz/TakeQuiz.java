package layout.TakeQuiz;

import android.content.Intent;
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

import layout.Main_Assigmaent.Main_Assigmaent;
import layout.Register.Connection;

public class TakeQuiz extends AppCompatActivity {
    Connection db;
    ArrayList<String> arr;
    EditText start, end, details;
    Spinner spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);
spin=(Spinner)findViewById(R.id.spin);
        db = new Connection(this);
        arr = new ArrayList<>();

        loadspinnerdata();
    }

    public void loadspinnerdata(){


        Cursor res=db.LoadAvquiz();

        if(res.getCount()==0){
            Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
            return;

        }


        int i=0;
        while(res.moveToNext()){

            arr.add(res.getString(2));

        }

        /*  to insert in spinner */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        spin.setAdapter(adapter);



    }

    public void Load(View v){

        Intent i = new Intent(this, Main_Assigmaent.class);

        startActivity(i);

    }

}
