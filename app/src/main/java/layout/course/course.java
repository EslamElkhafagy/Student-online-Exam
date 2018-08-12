package layout.course;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enjoy.study.R;

import layout.Register.Connection;

public class course extends AppCompatActivity {
    Connection db;


    EditText ccode,cname,csem,cdetails;
    Button add,delete,get,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        db = new Connection(this);

        cname = (EditText)findViewById(R.id.cnametxt);

        ccode = (EditText)findViewById(R.id.ccodetxt);
        csem = (EditText)findViewById(R.id.csemtxt);
        cdetails = (EditText)findViewById(R.id.cdetailstxt);




    }


    public void insert(View v){

        Intent x = this.getIntent();
        String iduser=  x.getExtras().getString("userid");
        boolean test=db.insertCourse(ccode.getText().toString(),cname.getText().toString(),csem.getText().toString(),cdetails.getText().toString(),iduser);

        if(test) {
            Toast.makeText(this, "inserted", Toast.LENGTH_LONG).show();

//            Intent i = new Intent(this, Profile.class);
//            i.putExtra("email",email.getText().toString());
//            i.putExtra("pass",pass.getText().toString());
//            startActivity(i);

        }else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();

        }
        emptyf();
    }

    public void  deleteCourse(View v){

            boolean test=db.deleteCourse(ccode.getText().toString());

            if(test)
                Toast.makeText(this,"deleted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

        emptyf();// clear txtfeild

    }


    public void getdata(View v){

        Cursor res=db.getcourseData(ccode.getText().toString());

        if(res.getCount()==0){
            Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
            return;

        }

        String s="";

        while(res.moveToNext()){


            ccode.setText(res.getString(1));
            ccode.setEnabled(false);
            cname.setText(res.getString(2));
            csem.setText(res.getString(3));
            cdetails.setText(res.getString(4));

        }


    }

    public void emptyf(){
        ccode.setText("");
        ccode.setEnabled(true);
        cname.setText("");
        csem.setText("");
        cdetails.setText("");

    }


    public void updatecourse(View v){

        boolean test = db.updateCousreData(ccode.getText().toString(),cname.getText().toString(),csem.getText().toString(),cdetails.getText().toString());

        if (test)
            Toast.makeText(this, "updated", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();

        emptyf();

    }

}
