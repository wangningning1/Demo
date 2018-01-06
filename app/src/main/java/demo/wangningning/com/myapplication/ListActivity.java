package demo.wangningning.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/1/6.
 */

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        MyRecyclerAdapter recycleAdapter = new MyRecyclerAdapter(ListActivity.this, intiData());

        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);//设置为垂直布局，这也是默认的

        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        recyclerView.setAdapter(recycleAdapter);//设置Adapter
        recyclerView.setItemAnimator(new DefaultItemAnimator());//设置增加或删除条目的动画
    }

    private List<String> intiData() {
        List<String> testData = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            testData.add("list" + i);
        }
        return testData;
    }

}
