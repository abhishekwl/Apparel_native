package abhishekwl.github.io.hashpool_prototype.Adapters;

import abhishekwl.github.io.hashpool_prototype.Fragments.SectorFragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] pageTitlesStrings;

    public MainViewPagerAdapter(@NonNull FragmentManager fm, String[] pageTitlesStrings) {
        super(fm);
        this.pageTitlesStrings = pageTitlesStrings;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        SectorFragment sectorFragment = new SectorFragment();
        sectorFragment.setSectorName(pageTitlesStrings[position]);
        return sectorFragment;
    }

    @Override
    public int getCount() {
        return pageTitlesStrings.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitlesStrings[position];
    }
}
