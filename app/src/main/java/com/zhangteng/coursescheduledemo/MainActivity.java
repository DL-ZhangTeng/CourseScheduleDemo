package com.zhangteng.coursescheduledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private HomeCourseScheduleFragment homeCourseScheduleFragment;
    private HomeCourseScheduleFragment2 homeCourseScheduleFragment2;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeCourseScheduleFragment = new HomeCourseScheduleFragment();
        homeCourseScheduleFragment2 = new HomeCourseScheduleFragment2();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.home_root, homeCourseScheduleFragment, HomeCourseScheduleFragment.class.getSimpleName())
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.home_root, homeCourseScheduleFragment2, HomeCourseScheduleFragment2.class.getSimpleName())
                .show(homeCourseScheduleFragment2)
                .commit();
    }

    public void onClick(View view) {
        if (flag) {
            flag = false;
            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(homeCourseScheduleFragment2)
                    .show(homeCourseScheduleFragment)
                    .commit();
        } else {
            flag = true;
            getSupportFragmentManager()
                    .beginTransaction()
                    .hide(homeCourseScheduleFragment)
                    .show(homeCourseScheduleFragment2)
                    .commit();
        }
    }
}
