
package com.example.remotecontrol.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.remotecontrol.R;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

     protected   int getLayoutResid() {
         return R.layout.activity_fragment;
     };
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResid());
        FragmentManager manager = getSupportFragmentManager();
        Fragment frag = manager.findFragmentById(R.id.fragmentContainer);
        if (frag == null) {
            frag = createFragment();
            manager.beginTransaction().add(R.id.fragmentContainer, frag).commit();
        }
    }

}
