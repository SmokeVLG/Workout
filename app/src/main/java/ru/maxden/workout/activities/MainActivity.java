package ru.maxden.workout.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ru.maxden.workout.R;
import ru.maxden.workout.fragments.WorkoutDetailFragment;
import ru.maxden.workout.fragments.WorkoutListFragment;
import ru.maxden.workout.interfaces.OnListItemClickListener;

public class MainActivity extends AppCompatActivity implements OnListItemClickListener {
    WorkoutListFragment listFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        listFragment = new WorkoutListFragment();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentManager.beginTransaction().replace(R.id.container, listFragment).commit();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            WorkoutDetailFragment detailFragment = WorkoutDetailFragment.initFragment(0);
            fragmentManager.beginTransaction().replace(R.id.list_container, listFragment).commit();
            fragmentManager.beginTransaction().replace(R.id.detail_container, detailFragment).commit();
        }
    }

    @Override
    public void onListItemClickListener(int index) {
        WorkoutDetailFragment detailFragment = WorkoutDetailFragment.initFragment(index);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            fragmentManager.beginTransaction().replace(R.id.container, detailFragment).addToBackStack(null).commit();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction().replace(R.id.detail_container, detailFragment).commit();
        }
    }
}
