package layout.Profile;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.enjoy.study.R;

import layout.Register.Connection;
import layout.TakeQuiz.TakeQuiz;

public class Profile extends AppCompatActivity {
Connection db;
    public int click=0;
    EditText nametxt,idtxt,phonetxt,addresstxt,emailtxt,typetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        db=new Connection(this);
        nametxt=(EditText)findViewById(R.id.nametxt);
        idtxt=(EditText)findViewById(R.id.idtxt);
        phonetxt=(EditText)findViewById(R.id.phonetxt);
        emailtxt=(EditText)findViewById(R.id.emailtxt);
        addresstxt=(EditText)findViewById(R.id.addresstxt);
        typetxt=(EditText)findViewById(R.id.typetxt);

        loadData();


    }

public void loadData(){
    Intent x = this.getIntent();
    String email=  x.getExtras().getString("email");
    String pass=x.getExtras().getString("pass");
    Cursor res=db.getProfileData(email,pass);//curser

    if(res.getCount()==0){
        Toast.makeText(this,"res coount = 0",Toast.LENGTH_LONG).show();
        return;

    }

    String s="";

    while(res.moveToNext()){

        idtxt.setText(res.getString(0));
        idtxt.setEnabled(false);
        nametxt.setText(res.getString(1));
        nametxt.setEnabled(false);
        phonetxt.setText(res.getString(2));
        phonetxt.setEnabled(false);
        addresstxt.setText(res.getString(3));
        addresstxt.setEnabled(false);
        emailtxt.setText(res.getString(4));
        emailtxt.setEnabled(false);
        typetxt.setText(res.getString(6));
        typetxt.setEnabled(false);
    }


}

public void updatedata(View v){

if(click==0 || click%2!=0) {
    nametxt.setEnabled(true);
    phonetxt.setEnabled(true);
    addresstxt.setEnabled(true);
    emailtxt.setEnabled(true);

    click++;
}

if(click%2==0 &&click!=0) {
    boolean test = db.update(idtxt.getText().toString(), nametxt.getText().toString(), phonetxt.getText().toString(), addresstxt.getText().toString(), emailtxt.getText().toString(), typetxt.getText().toString());

    if (test) {
        Toast.makeText(this, "updated", Toast.LENGTH_LONG).show();
        nametxt.setEnabled(false);
        phonetxt.setEnabled(false);
        addresstxt.setEnabled(false);
        emailtxt.setEnabled(false);
    }
    else
        Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
    click++;
}

}
//take quiz
    public void now(View v){
        Intent i = new Intent(this, TakeQuiz.class);
        startActivity(i);
    }
}
