package abhishekwl.github.io.hashpool_prototype.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import abhishekwl.github.io.hashpool_prototype.Models.Category;
import abhishekwl.github.io.hashpool_prototype.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesRecyclerViewAdapter extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoryViewHolder> {

    private ArrayList<Category> categoryArrayList = new ArrayList<>();

    public CategoriesRecyclerViewAdapter(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    @NonNull
    @Override
    public CategoriesRecyclerViewAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesRecyclerViewAdapter.CategoryViewHolder holder, int position) {
        Category category = categoryArrayList.get(position);
        holder.bind(holder.itemView.getContext(), category);
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryNameTextView;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryNameTextView = itemView.findViewById(R.id.categoryListItemCategoryNameTextView);
        }

        void bind(Context context, Category category) {
            categoryNameTextView.setText(category.getCategoryName());
        }
    }
}
