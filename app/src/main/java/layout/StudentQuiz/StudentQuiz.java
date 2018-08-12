package layout.StudentQuiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.enjoy.study.R;

import java.util.ArrayList;

public class StudentQuiz extends AppCompatActivity {

    ArrayList<LinearLayout> arr;
ArrayList<String> que;
    ArrayList<String> a1;
    ArrayList<String> a2;
    ArrayList<String> a3;
    ArrayList<String> a4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_quiz);
        data();
        LoadQuestions();
    }

public void data(){
    que= new ArrayList<>();
    a1= new ArrayList<>();
    a2= new ArrayList<>();
    a3= new ArrayList<>();
    a4= new ArrayList<>();

    que.add("Questions 1");
    que.add("Questions 2");
    que.add("Questions 3");
    que.add("Questions 4");
    que.add("Questions 5");

    a1.add("Questions a(a1)");
    a1.add("Questions a(a1)");
    a1.add("Questions a(a1)");
    a1.add("Questions a(a1)");
    a1.add("Questions a(a1)");

    a2.add("Questions b(a2)");
    a2.add("Questions b(a2)");
    a2.add("Questions b(a2)");
    a2.add("Questions b(a2)");
    a2.add("Questions b(a2)");

    a3.add("Questions c(a3)");
    a3.add("Questions c(a3)");
    a3.add("Questions c(a3)");
    a3.add("Questions c(a3)");
    a3.add("Questions c(a3)");

    a4.add("Questions d(a4)");
    a4.add("Questions d(a4)");
    a4.add("Questions d(a4)");
    a4.add("Questions d(a4)");
    a4.add("Questions d(a4)");


}

    public void LoadQuestions() {

        LinearLayout rr = null;

        for (int i = 0; i < 5; i++) {

            LayoutInflater l = getLayoutInflater();

            View vv = l.inflate(R.layout.questions, null);

        rr= (LinearLayout)findViewById(R.id.ll);
          EditText maintxt= (EditText)vv.findViewById(R.id.maintxt);
            maintxt.setText(que.get(i));
            maintxt.setEnabled(false);
            EditText txt1= (EditText)vv.findViewById(R.id.txt1);
txt1.setText(a1.get(i));
            txt1.setEnabled(false);
//            txt1.setEnabled(false);
            EditText txt2= (EditText)vv.findViewById(R.id.txt2);
            txt2.setText(a2.get(i));
            txt2.setEnabled(false);
            EditText txt3= (EditText)vv.findViewById(R.id.txt3);
            txt3.setText(a3.get(i));
            txt3.setEnabled(false);
            EditText txt4= (EditText)vv.findViewById(R.id.txt4);
            txt4.setText(a4.get(i));
            txt4.setEnabled(false);
        rr.addView(vv);
//        arr.add((LinearLayout)vv);

        }

    }


}