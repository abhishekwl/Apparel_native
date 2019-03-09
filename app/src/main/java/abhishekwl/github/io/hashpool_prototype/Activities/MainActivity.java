package abhishekwl.github.io.hashpool_prototype.Activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import abhishekwl.github.io.hashpool_prototype.Adapters.MainViewPagerAdapter;
import abhishekwl.github.io.hashpool_prototype.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolbar;
    private ViewPager mainViewPager;
    private TabLayout mainTabLayout;

    private InitializeViews initializeViews = new InitializeViews();
    private MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class InitializeViews extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            mainToolbar = findViewById(R.id.mainToolbar);
            mainTabLayout = findViewById(R.id.mainTabLayout);
            mainViewPager = findViewById(R.id.mainViewPager);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), getResources().getStringArray(R.array.sectors));
            mainViewPager.setAdapter(mainViewPagerAdapter);
            mainTabLayout.setupWithViewPager(mainViewPager);
        }
    }

    @Override
    protected void onDestroy() {
        if (initializeViews!=null && initializeViews.getStatus()== AsyncTask.Status.RUNNING) initializeViews.cancel(true);
        super.onDestroy();
    }
}
