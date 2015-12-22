package com.andyiac.zcommon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.andyiac.zcommon.db.DatabaseExampleActivity;
import com.andyiac.zcommon.ui.DividerItemDecoration;
import com.andyiac.zcommon.utlis.KeyBoardTools;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ListAdapterHolder mAdapter;

    private List<String> mData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();

        initView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                KeyBoardTools.actionKey(KeyEvent.KEYCODE_BACK);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        this.databaseList();
    }

    private void initData() {
        mData.add("get device id");
        mData.add("get device height");
        mData.add("git device weight");
        mData.add("get current date");
        mData.add("get app version code");
        mData.add("show time picker");
        mData.add("get database list");
        mData.add("goto Databases Activity");
    }

    private void initView() {
        mAdapter = new ListAdapterHolder(mData);


        mRecyclerView = (RecyclerView) findViewById(R.id.id_main_recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        float paddingStart = getResources().getDimension(R.dimen.divider_padding_start);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST, paddingStart, false));

        mAdapter.setOnItemClickListener(new ListAdapterHolder.ItemClickListener() {
            @Override
            public void onItemClick(View view, String content) {
                routeFunction(view, content);
            }
        });

    }

    private void routeFunction(View view, String which) {

        if (which.equals(mData.get(0))) {
            ZCommon.showAlertDialog(this, "device id", ZCommon.getDeviceId(this), false);
        } else if (which.equals(mData.get(1))) {
            ZCommon.showAlertDialog(this, "device height", ZCommon.getDeviceHeight(this) + "", false);
        } else if (which.equals(mData.get(2))) {
            ZCommon.showAlertDialog(this, "device width", ZCommon.getDeviceWidth(this) + "", false);
        } else if (which.equals(mData.get(3))) {
            ZCommon.showAlertDialog(this, "current date", ZCommon.getCurrentDate("yyyy-MM-dd hh:mm:ss"), false);
        } else if (which.equals(mData.get(4))) {
            ZCommon.showAlertDialog(this, "get app version code", ZCommon.getAppVersionCode(this) + "", false);
        } else if (which.equals(mData.get(5))) {
            ZCommon.showTimePickerDialog(this, (TextView) view.findViewById(R.id.tv_main_activity_list_item_content));
        } else if (which.equals(mData.get(6))) {
            ZCommon.showAlertDialog(this, "data base list", StringUtils.joinArrayOnComma(databaseList()), false);
        } else if (which.equals(mData.get(7))) {
            Intent intent = new Intent();
            intent.setClass(this, DatabaseExampleActivity.class);
            startActivity(intent);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
