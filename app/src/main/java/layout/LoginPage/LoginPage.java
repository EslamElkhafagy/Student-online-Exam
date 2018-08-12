package layout.LoginPage;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enjoy.study.R;

import layout.Profile.Profile;
import layout.Register.Connection;
import layout.Register.Register;
import layout.doctorprofile.doctorprofile;

public class LoginPage extends AppCompatActivity {


    Connection mydb;
    String id,name,phone,address,em,type;
    EditText email,pass;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mydb  = new Connection(this);

        email=(EditText)findViewById(R.id.emailtxt);
        pass=(EditText)findViewById(R.id.passtxt);
        login=(Button)findViewById(R.id.loginbtn);
        signup=(Button)findViewById(R.id.signup);

    }
    public void test(View v) {
        if (v.getId() == R.id.loginbtn) {
            Cursor resu = mydb.getAllData();
            if (resu == null) {
                Toast.makeText(this, "res is null", Toast.LENGTH_LONG).show();
                return;
            }
            if (resu.getCount() == 0) {
                Toast.makeText(this, "res coount = 0 at enter method", Toast.LENGTH_LONG).show();
                return;
            }

            boolean cond = false;
            while (resu.moveToNext()) {
                if (email.getText().toString().equals(resu.getString(4)) && pass.getText().toString().equals(resu.getString(5))) {
                    cond = true;
                    id = resu.getString(0);
                    name = resu.getString(1);
                    phone = resu.getString(2);
                    address = resu.getString(3);
                    em = resu.getString(4);
                    type = resu.getString(6);
                    break;
                }

            }
            if (cond == false)
                Toast.makeText(this, "invalid data ", Toast.LENGTH_LONG).show();
            else {
                if (type.equals("Student")) {
                    Intent i = new Intent(this, Profile.class);
                    i.putExtra("email", email.getText().toString());
                    i.putExtra("pass", pass.getText().toString());

                    startActivity(i);

                }else {
                    Intent i = new Intent(this,doctorprofile.class);
                    i.putExtra("email", email.getText().toString());
                    i.putExtra("pass", pass.getText().toString());
                    startActivity(i);

                }
            }
        }

    }
    public void signup(View v){
        Intent i = new Intent(this, Register.class);
        startActivity(i);

    }

}
