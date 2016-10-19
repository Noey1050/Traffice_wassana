package com.wassana.traffice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pc on 19/10/2559.
 */
public class ShowDetailActivity extends AppCompatActivity {

    //Explicit
    private TextView showTitleTextView,showDetailTextView;
    private ImageView showTrafficImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        //Bind widget
        bindWidget();

        //Show widget
        showWidget();
    } //onCtete

    private  void bindWidget(){
        showTitleTextView = (TextView)findViewById(R.id.txtTitleDetail);
        showDetailTextView = (TextView)findViewById(R.id.txtDetail);
        showTrafficImageView = (ImageView)findViewById(R.id.imvTrafficDetail);
    } //bindWidget

    private void showWidget(){

        //Receive from Intent
        int intClick = getIntent().getIntExtra("click",0);

        //Show Title
        Mydata objmydata = new Mydata();
        String[] strTitle = objmydata.title();
        showTitleTextView.setText(strTitle[intClick]);

        //Show Traffic image
        int[]intDrawable = objmydata.icon();
        showTrafficImageView.setImageResource(intDrawable[intClick]);

        //Show Detail
        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        showDetailTextView.setText(strDetail[intClick]);

    }  //Show Widget
}
