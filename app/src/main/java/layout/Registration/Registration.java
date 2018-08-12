package layout.Registration;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enjoy.study.R;

public class Registration extends AppCompatActivity {

    DbConnection mydb;
    EditText name;
    EditText phone;
    EditText address;
    EditText email;
    EditText pass,id;
    Button add,update,delete;
    Button view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mydb = new DbConnection(this);

name = (EditText)findViewById(R.id.nametxt);
phone = (EditText)findViewById(R.id.phonetxt);
        address= (EditText)findViewById(R.id.addresstxt);
email= (EditText)findViewById(R.id.emailtxt);
        pass= (EditText)findViewById(R.id.passtxt);
        id= (EditText)findViewById(R.id.id);

        add=(Button)findViewById(R.id.addbtn);
        view=(Button)findViewById(R.id.view);
        delete=(Button)findViewById(R.id.deletebtn);
        update=(Button)findViewById(R.id.updatebtn);


    }


   public void insert(View v){

       boolean test=mydb.insert(name.getText().toString(),phone.getText().toString(),address.getText().toString(),email.getText().toString(),pass.getText().toString());

       if(test)
           Toast.makeText(this,"inserted",Toast.LENGTH_LONG).show();
       else
           Toast.makeText(this,"error",Toast.LENGTH_LONG).show();


   }


    public void viewAllData(View v){

        Cursor res =mydb.getAllData();

        if(res.getCount()==0){
            Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
            return;

        }

        String s="";

        while(res.moveToNext()){

            s+="id = "+res.getString(0)+"\n";
            s+="id = "+res.getString(1)+"\n";
            s+="id = "+res.getString(2)+"\n";
            s+="id = "+res.getString(3)+"\n";
            s+="id = "+res.getString(4)+"\n";
            s+="id = "+res.getString(5)+"\n";



        }

        Toast.makeText(this,s,Toast.LENGTH_LONG).show();

    }

    public void update(View v){

        boolean test=mydb.update(id.getText().toString(),name.getText().toString(),phone.getText().toString(),address.getText().toString(),email.getText().toString(),pass.getText().toString());

        if(test)
            Toast.makeText(this,"updated",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

    }

public void deleteitem(View v){

boolean test=mydb.delete(id.getText().toString());

    if(test)
        Toast.makeText(this,"deleted",Toast.LENGTH_LONG).show();
    else
        Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

}


}
