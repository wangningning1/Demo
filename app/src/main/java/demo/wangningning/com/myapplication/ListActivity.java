package demo.wangningning.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import  android.widget.ListView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/6.
 */

public class ListActivity extends AppCompatActivity {
    private RecyclerView rececyclerView;
    private List<String> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );
        rececyclerView = (RecyclerView)findViewById( R.id.recyclerView );
        intiData();

        LinearLayout layout = new LinearLayout( this );
    }
    private void intiData(){
        mDatas = new ArrayList<String>(  );
        for ( int i = 0;i < 100;i++){
            mDatas.add("list"+i);
        }
    }

}
