package layout.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.enjoy.study.R;

import layout.Profile.Profile;
import layout.doctorprofile.doctorprofile;

public class Register extends AppCompatActivity {
    Connection db;


String type[]={"Student","Doctor"};
    Spinner spin;
    Button regist;
    EditText name;
    EditText phone;
    EditText address;
    EditText email;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Connection(this);
        setContentView(R.layout.activity_register);

        name = (EditText)findViewById(R.id.nametxt);
        phone = (EditText)findViewById(R.id.phonetxt);
        address= (EditText)findViewById(R.id.addresstxt);
        email= (EditText)findViewById(R.id.emailtxt);
        pass= (EditText)findViewById(R.id.passtxt);
        spin=(Spinner)findViewById(R.id.spinner);
        regist=(Button)findViewById(R.id.regest_btn);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,type);
        spin.setAdapter(adapter);

    }
//not used
 public void onclick(View v){

     Toast.makeText(this,spin.getSelectedItem().toString(),Toast.LENGTH_LONG).show();

 }

    public void insert(View v){

        boolean test=db.insert(name.getText().toString(),phone.getText().toString(),address.getText().toString(),email.getText().toString(),pass.getText().toString(),spin.getSelectedItem().toString());

        if(test) {
            Toast.makeText(this, "inserted", Toast.LENGTH_LONG).show();

            if(spin.getSelectedItem().toString().equals("Student")) {
                 Intent i = new Intent(this, Profile.class);
                 i.putExtra("email", email.getText().toString());
                 i.putExtra("pass", pass.getText().toString());
                 startActivity(i);
            }else{
                Intent i = new Intent(this, doctorprofile.class);
                i.putExtra("email", email.getText().toString());
                i.putExtra("pass", pass.getText().toString());
                startActivity(i);

}

        }else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();

        }
    }

}
