package com.DreamShop.hp.DreamShop.activityes;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.adapters.InfoImageAdapter;
import com.DreamShop.hp.DreamShop.dialogFragments.VideoDialogFragment;
import com.DreamShop.hp.DreamShop.models.ProductModel;
import com.DreamShop.hp.DreamShop.providers.ProdProvider;
import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    private static final String VIDEO_DIALOG = "VIDEO DIALOG";
    ProductModel productModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        productModel = ProdProvider.getItemPosition();
        final LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL, false);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(productModel.getTitle());
        initializationRecycler(layoutManager);
        getProductData();
        getVideoDialog();
    }

    private void getProductData() {
        final TextView textView = findViewById(R.id.descriptionId);
        final RatingBar rab = findViewById(R.id.infoRatingBarId);
        ImageView imageView = findViewById(R.id.infoImageId);
        Picasso.get()
                .load(productModel.getImageUrl()[0])
                .placeholder(R.drawable.joker)
                .into(imageView);
        rab.setRating(productModel.getRating());
        textView.setText(productModel.getDescription());
    }

    private void getVideoDialog() {
        final FragmentManager ft = getFragmentManager();
        ImageView videoImg = findViewById(R.id.imgVideo);
        videoImg.setImageResource(R.drawable.ic_play_circle);
        videoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new VideoDialogFragment();
                dialogFragment.show(ft, VIDEO_DIALOG);
            }
        });
    }

    private void initializationRecycler(LinearLayoutManager layoutManager) {
        InfoImageAdapter adapter =
                new InfoImageAdapter(InfoActivity.this, productModel.getImageUrl());
        RecyclerView recyclerView = findViewById(R.id.imageListId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
