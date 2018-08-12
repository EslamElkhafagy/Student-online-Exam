package layout.questions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.enjoy.study.R;

import java.util.ArrayList;


public class InsertQuestions extends BaseAdapter {

    ArrayList<singlerow> list;
    Context contxt;

    InsertQuestions(Context c, ArrayList<singlerow> rows) {
        this.contxt = c;
        list = rows;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = LayoutInflater.from(this.contxt).inflate(R.layout.questions,null);
        EditText edittext=(EditText)view.findViewById(R.id.maintxt);
        RadioButton rd1= (RadioButton) view.findViewById(R.id.rd1);
        this.list.get(position).Title=edittext.getText().toString();
//        Toast.makeText(this.contxt,edittext.getText().toString(),Toast.LENGTH_LONG).show();

        return view;
    }
}
