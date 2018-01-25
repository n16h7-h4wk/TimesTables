package com.developer.ankit.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar mSeekBar ;
    ListView mListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSeekBar = (SeekBar) findViewById(R.id.seek_bar);
        mListView = (ListView) findViewById(R.id.list_view);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("TT","current pos is " + Integer.toString(progress));
                ArrayList<String> TT = table(progress);
                ArrayAdapter<String> mAdapter;
                mAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, TT);
                mListView.setAdapter(mAdapter);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public ArrayList<String> table(int n){
        ArrayList<String> data = new ArrayList<>();
        for(int i =1;i<=10;i++){
            data.add(n + " x " + i + " = " +Integer.toString(n*i));
        }
        return data ;
    }

}
