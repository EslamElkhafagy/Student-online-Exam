package layout.questions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enjoy.study.R;

import java.util.ArrayList;

public class MainQuestions extends AppCompatActivity {

    Button create;
    Button b;
    EditText txt;

    ListView list;

    ArrayList<LinearLayout> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_questions);
        arr = new ArrayList<>();

        list = (ListView) findViewById(R.id.questionList);


    }

    public void TEST(View v) {
        ArrayList<singlerow> rows = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            rows.add(new singlerow("", "", "", "", "", ""));
        }
        InsertQuestions adapter = new InsertQuestions(this, rows);
        list.setAdapter(adapter);


    }

    public void press(View v) {
        LinearLayout rr = null;
        b = (Button) findViewById(R.id.button);
        txt = (EditText) findViewById(R.id.txt);

        for (int i = 0; i < Integer.parseInt(txt.getText().toString()); i++) {

            LayoutInflater l = getLayoutInflater();

            View vv = l.inflate(R.layout.questions, null);
            TextView n = (TextView) findViewById(R.id.num);

            rr = (LinearLayout) findViewById(R.id.ll);
            rr.addView(vv);
            arr.add((LinearLayout) vv);

        }

        Toast.makeText(this, txt.getText(), Toast.LENGTH_LONG).show();

    }

    public void sendQuestions(View v) {
        create = (Button) findViewById(R.id.sumb);
        Toast.makeText(this, arr.size() + "", Toast.LENGTH_LONG);
//       Toast.makeText(this,"test ",Toast.LENGTH_LONG).show();

        for (int i = 0; i < arr.size(); i++) {
            LinearLayout x = arr.get(i);
            EditText z = (EditText) x.findViewById(R.id.maintxt);
            ;
            Toast.makeText(this, z.getText().toString(), Toast.LENGTH_LONG).show();


        }


    }

    public void send(View v) {

       singlerow s= (singlerow)list.getAdapter().getItem(0);

        Toast.makeText(MainQuestions.this,s.Title.toString() +"", Toast.LENGTH_SHORT).show();

    }
}
