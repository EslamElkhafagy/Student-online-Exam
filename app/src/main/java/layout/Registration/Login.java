package layout.Registration;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enjoy.study.R;

public class Login extends AppCompatActivity {

    DbConnection mydb;

    EditText email,pass;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mydb= new DbConnection(this);


        email=(EditText)findViewById(R.id.emailtxt);
        pass=(EditText)findViewById(R.id.passtxt);

        login=(Button)findViewById(R.id.loginbtn);
//       signup =(Button)findViewById(R.id.signupbtn);


    }

    public void test(View v) {

        if (v.getId() == R.id.loginbtn) {
            Cursor resu =mydb.check();
if(resu==null) {
    Toast.makeText(this, "res is null", Toast.LENGTH_LONG).show();
return;
}
            if (resu.getCount() == 0) {
                Toast.makeText(this, "res coount = 0 at enter method", Toast.LENGTH_LONG).show();
                return;

            }

            String s = "";
            boolean cond = false;
            while (resu.moveToNext()) {

                if (email.getText().toString().equals(resu.getString(4)) && pass.getText().toString().equals(resu.getString(5))) {
                    cond = true;
                    break;
                }

            }
            if (!cond)
                Toast.makeText(this, "invalid data ", Toast.LENGTH_LONG).show();
            else {
                Intent z = new Intent(this, Registration.class);
                startActivity(z);


            }
   }


    }
}
