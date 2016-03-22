/**
 * Yalantis first task
 *
 * Task has been done by Alexander Kluchnik
 *
 * email: spankyhamtony@gmail.com
 */
package com.example.atg.yalantisfirst;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,RecyclerViewOnClickListener{

    private RecyclerView mRecyclerView;
    private TextView mTvDateCreate, mTvDateRegistered, mTvDateResolve, mTvWhoIsResponsible, mTvInfo, mTvTitle, mTvIconProgress;
    private TextView mTvCreate, mTvRegistered, mTvResolve, mTvResponsible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar;
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        toolbar.setTitle("CE-1257218");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<Uri> picList= new ArrayList<>();
        picList.add(Uri.parse("http://i.imgur.com/aqsvgHP.jpg"));
        picList.add(Uri.parse("http://i.imgur.com/XsuMFob.jpg"));
        picList.add(Uri.parse("http://i.imgur.com/QzPTUFi.jpg"));
        picList.add(Uri.parse("http://i.imgur.com/5L6X4v5.png"));

        init();
        setAllText();

        MyAdapter myAdapter = new MyAdapter(this,picList,this);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(myAdapter);

        mRecyclerView.setOnClickListener(this);
        mTvDateCreate.setOnClickListener(this);
        mTvCreate.setOnClickListener(this);
        mTvDateRegistered.setOnClickListener(this);
        mTvRegistered.setOnClickListener(this);
        mTvDateResolve.setOnClickListener(this);
        mTvResolve.setOnClickListener(this);
        mTvWhoIsResponsible.setOnClickListener(this);
        mTvResponsible.setOnClickListener(this);
        mTvInfo.setOnClickListener(this);
        mTvTitle.setOnClickListener(this);
        mTvIconProgress.setOnClickListener(this);
    }

    private void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recView);
        mTvDateCreate = (TextView) findViewById(R.id.tvDateCreate);
        mTvCreate = (TextView) findViewById(R.id.tvCreate);
        mTvDateRegistered = (TextView) findViewById(R.id.tvDateRegistered);
        mTvRegistered = (TextView) findViewById(R.id.tvRegistered);
        mTvDateResolve = (TextView) findViewById(R.id.tvDateResolve);
        mTvResolve = (TextView) findViewById(R.id.tvResolve);
        mTvWhoIsResponsible = (TextView) findViewById(R.id.tvWhoIsResponsible);
        mTvResponsible = (TextView) findViewById(R.id.tvResponsible);
        mTvInfo = (TextView) findViewById(R.id.tvInfo);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mTvIconProgress = (TextView) findViewById(R.id.tvIconProgress);
    }

    private void setAllText(){
        mTvDateCreate.setText(R.string.text_created);
        mTvDateRegistered.setText(R.string.text_registered);
        mTvDateResolve.setText(R.string.text_resolve);
        mTvWhoIsResponsible.setText(R.string.text_responsible);
        mTvInfo.setText(R.string.text_info);
        mTvTitle.setText(R.string.text_title);
        mTvIconProgress.setText(R.string.text_icon_progress);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tvIconProgress||
                v.getId()==R.id.tvDateCreate||
                v.getId()==R.id.tvDateRegistered||
                v.getId()==R.id.tvDateResolve ||
                v.getId()==R.id.tvWhoIsResponsible||
                v.getId()==R.id.tvInfo||
                v.getId()==R.id.tvTitle||
                v.getId()==R.id.tvCreate||
                v.getId()==R.id.tvRegistered||
                v.getId()==R.id.tvResolve||
                v.getId()==R.id.tvResponsible) {

            Toast.makeText(MainActivity.this,"TextView",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onImageClick(String imageString) {
        Toast.makeText(this, imageString , Toast.LENGTH_SHORT).show();
    }
}
