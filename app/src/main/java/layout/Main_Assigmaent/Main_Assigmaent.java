package layout.Main_Assigmaent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.enjoy.study.R;

import layout.Profile.Profile;

public class Main_Assigmaent extends AppCompatActivity {

    ListView simpleList;
    String[] questions={"questions 1","questions 2","questions 3","questions 4","questions 5","questions 6","questions 7"};
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__assigmaent);


        simpleList = (ListView) findViewById(R.id.simpleListView);
        submit = (Button) findViewById(R.id.submit);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), questions);
        simpleList.setAdapter(customAdapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "";
                for (int i = 0; i < CustomAdapter.selectedAnswers.size(); i++) {
                    message = message + "\n" + (i + 1) + " " + CustomAdapter.selectedAnswers.get(i);
                }
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

  int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    /*  not used  */
    public void retu(View v){

        Intent i = new Intent(this, Profile.class);
//                i.putExtra("id",id);
//                i.putExtra("name",name);
//                i.putExtra("phone",phone);
//                i.putExtra("address",address);
//        i.putExtra("email", email.getText().toString());
//        i.putExtra("pass", pass.getText().toString());
//                i.putExtra("type",type);

        startActivity(i);

    }

}
