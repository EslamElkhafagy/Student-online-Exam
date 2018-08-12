package layout.AddCourse;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.enjoy.study.R;

import java.util.ArrayList;

import layout.Register.Connection;

public class AddCourse extends AppCompatActivity {
    Connection db;

ArrayList<String> arr ;
    EditText code,name,sem,details,doc;
    Spinner spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        arr=new ArrayList<>();
        db = new Connection(this);
spin=(Spinner)findViewById(R.id.spin);
        name = (EditText)findViewById(R.id.nametxt);

        code = (EditText)findViewById(R.id.codetxt);
        sem = (EditText)findViewById(R.id.semtxt);
        details = (EditText)findViewById(R.id.detailstxt);

        laodcourses();

    }

public void laodcourses(){

    Cursor res=db.loadcoursesname();

    if(res.getCount()==0){
        Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
        return;

    }


int i=0;
    while(res.moveToNext()){

arr.add(res.getString(0));

    }

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arr);
    spin.setAdapter(adapter);
    spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            setData(spin.getSelectedItem().toString());
            Toast.makeText(getBaseContext(),spin.getSelectedItem().toString(),Toast.LENGTH_LONG).show();


        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    });

}

    public void setData(String namex){

        Cursor res=db.courseDataView(namex);

        if(res.getCount()==0){
            Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
            return;

        }

        String s="";

        while(res.moveToNext()){


            code.setText(res.getString(1));
            name.setText(res.getString(2));
            code.setEnabled(false);
            name.setEnabled(false);
            sem.setEnabled(false);
            details.setEnabled(false);
            sem.setText(res.getString(3));
            details.setText(res.getString(4));

        }

    }


}
