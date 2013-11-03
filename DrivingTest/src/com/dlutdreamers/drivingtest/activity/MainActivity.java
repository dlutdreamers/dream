package com.dlutdreamers.drivingtest.activity;


import org.apache.log4j.Logger;

import com.dlutdreamers.drivingtest.R;
import com.dlutdreamers.drivingtest.R.layout;
import com.dlutdreamers.drivingtest.R.menu;
import com.dlutdreamers.drivingtest.log.MyLogger;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	private Logger log=MyLogger.getLogger(this.getClass());
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        log.info("小强这个三炮");
        return true;
    }
    
}
