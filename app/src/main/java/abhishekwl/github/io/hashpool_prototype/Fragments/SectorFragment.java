package abhishekwl.github.io.hashpool_prototype.Fragments;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import abhishekwl.github.io.hashpool_prototype.Adapters.CategoriesRecyclerViewAdapter;
import abhishekwl.github.io.hashpool_prototype.Models.Category;
import abhishekwl.github.io.hashpool_prototype.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectorFragment extends androidx.fragment.app.Fragment {

    private View rootView;
    private String sectorName;
    private RecyclerView categoriesRecyclerView;
    private CategoriesRecyclerViewAdapter categoriesRecyclerViewAdapter;
    private PopulateCategoryArrayList populateCategoryArrayList = new PopulateCategoryArrayList();

    public SectorFragment() {
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sector, container, false);
        initializeViews();
        return rootView;
    }

    private void initializeViews() {
        categoriesRecyclerView = rootView.findViewById(R.id.sectorFragmentCategoriesRecyclerView);
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        categoriesRecyclerView.setItemAnimator(new DefaultItemAnimator());
        categoriesRecyclerView.setHasFixedSize(true);
        populateCategoryArrayList.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class PopulateCategoryArrayList extends AsyncTask<String, Void, ArrayList<Category>> {

        @Override
        protected ArrayList<Category> doInBackground(String... strings) {
            ArrayList<Category> categoryArrayList = new ArrayList<>();
            for (String category: getResources().getStringArray(R.array.Home))  categoryArrayList.add(new Category(category));
            return categoryArrayList;
        }

        @Override
        protected void onPostExecute(ArrayList<Category> categories) {
            super.onPostExecute(categories);
            categoriesRecyclerViewAdapter = new CategoriesRecyclerViewAdapter(categories);
            categoriesRecyclerView.setAdapter(categoriesRecyclerViewAdapter);
        }
    }

    @Override
    public void onDestroyView() {
        if (populateCategoryArrayList!=null && populateCategoryArrayList.getStatus()== AsyncTask.Status.RUNNING) populateCategoryArrayList.cancel(true);
        super.onDestroyView();
    }
}
