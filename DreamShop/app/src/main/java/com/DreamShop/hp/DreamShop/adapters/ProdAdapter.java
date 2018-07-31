package com.DreamShop.hp.DreamShop.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.activityes.InfoActivity;
import com.DreamShop.hp.DreamShop.models.ProductModel;
import com.DreamShop.hp.DreamShop.providers.ProdProvider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProdAdapter extends RecyclerView.Adapter<ProdAdapter.ProdViewHolder> implements Filterable {
    private Context context;
    private List<ProductModel> list;
    private List<ProductModel> filteredList;

    public ProdAdapter(Context context, List<ProductModel> list) {
        this.context = context;
        this.list = list;
        this.filteredList = list;
    }

    @NonNull
    @Override
    public ProdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        final View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProdViewHolder holder, final int position) {
        final ProductModel prModel = filteredList.get(position);
        holder.title.setText(prModel.getTitle());
        holder.price.setText(prModel.getPrice());
        holder.rating.setRating(prModel.getRating());
        Picasso.get().load(prModel.getImageUrl()[0]).placeholder(R.drawable.joker).into(holder.prodImage);
        holder.likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //like Buttoni sexmelu depqum karmri!!!
                holder.likeButton.setBackgroundResource(R.drawable.heart_red);
                prModel.setLike(true);
            }
        });
        holder.basketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.basketButton.setBackgroundResource(R.drawable.basket_red);
                prModel.setToBasket(true);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upDatePosition(filteredList, position);
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {
                    filteredList = list;
                } else {
                    List<ProductModel> listForFilter = new ArrayList<>();
                    for (ProductModel model : list) {
                        if (model.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            listForFilter.add(model);
                        }
                    }
                    filteredList = listForFilter;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                filterResults.count = filteredList.size();

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (List<ProductModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public class ProdViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView prodImage;
        TextView price;
        RatingBar rating;
        Button likeButton;
        Button basketButton;

        ProdViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.prodNameId);
            prodImage = itemView.findViewById(R.id.prodImageId);
            price = itemView.findViewById(R.id.priceId);
            rating = itemView.findViewById(R.id.ratingBar);
            likeButton = itemView.findViewById(R.id.likeButtonId);
            basketButton = itemView.findViewById(R.id.basketButtonId);
        }
    }

    private static void upDatePosition(List<ProductModel> list, int position) {
        for (int i = 0; i < ProdProvider.prodList.size(); i++) {
            if (ProdProvider.prodList.get(i).getTitle().equals(list.get(position).getTitle())) {
                ProdProvider.position = i;
            }
        }
    }
}
