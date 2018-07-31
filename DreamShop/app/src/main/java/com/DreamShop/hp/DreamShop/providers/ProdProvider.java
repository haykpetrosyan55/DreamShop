package com.DreamShop.hp.DreamShop.providers;

import android.content.Context;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.models.Category;
import com.DreamShop.hp.DreamShop.models.ProductModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.DreamShop.hp.DreamShop.models.Category.CAR;
import static com.DreamShop.hp.DreamShop.models.Category.GUITAR;
import static com.DreamShop.hp.DreamShop.models.Category.GUN;
import static com.DreamShop.hp.DreamShop.models.Category.PLEASURE;

public class ProdProvider {
    public static List<ProductModel> prodList = new ArrayList<>();
    public static int position;

    public static List<ProductModel> getProdList(Context context) {
        if (!prodList.isEmpty()) {
            prodList.clear();
        }

        prodList.add(new ProductModel(context.getString(R.string.dodge), context.getResources().getStringArray(R.array.dodgeList), context.getString(R.string.videoUrl), CAR, 5, context.getString(R.string.price55000), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.bmw), context.getResources().getStringArray(R.array.bmwList), context.getString(R.string.videoUrl), CAR, 5, context.getString(R.string.price30), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.lambo), context.getResources().getStringArray(R.array.lamboList), context.getString(R.string.videoUrl), CAR, 4, context.getString(R.string.price100), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.svd), context.getResources().getStringArray(R.array.svdList), context.getString(R.string.videoUrl), GUN, 5, context.getString(R.string.price10), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.magnum), context.getResources().getStringArray(R.array.magnumList), context.getString(R.string.videoUrl), GUN, 4, context.getString(R.string.pr10), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.t9), context.getResources().getStringArray(R.array.t9List), context.getString(R.string.videoUrl), GUN, 4, context.getString(R.string.pr5), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.ak74), context.getResources().getStringArray(R.array.ak74List), context.getString(R.string.videoUrl), GUN, 4, context.getString(R.string.pr10), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.fender), context.getResources().getStringArray(R.array.fenderList), context.getString(R.string.videoUrl), GUITAR, 4, context.getString(R.string.pr55), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.gibson), context.getResources().getStringArray(R.array.gibsonList), context.getString(R.string.videoUrl), GUITAR, 5, context.getString(R.string.pr48), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.yamaha), context.getResources().getStringArray(R.array.yamahaList), context.getString(R.string.videoUrl), GUITAR, 4, context.getString(R.string.pr35), context.getString(R.string.large_text), false, false));
        prodList.add(new ProductModel(context.getString(R.string.ibanez), context.getResources().getStringArray(R.array.ibanezList), context.getString(R.string.videoUrl), GUITAR, 4, context.getString(R.string.pr44), context.getString(R.string.large_text), false, false));

        Collections.shuffle(prodList);
        return prodList;
    }

    public static List<ProductModel> getListCategory(Enum<Category> category) {
        List<ProductModel> categoryList = new ArrayList<>();
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).getCategory().equals(category)) {
                categoryList.add(prodList.get(i));
            }
        }
        return categoryList;
    }

    public static List<ProductModel> getListBasket() {
        List<ProductModel> basketList = new ArrayList<>();
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).isToBasket()) {
                basketList.add(prodList.get(i));
            }
        }
        return basketList;
    }

    public static List<ProductModel> getListLike() {
        List<ProductModel> likeList = new ArrayList<>();
        for (int i = 0; i < prodList.size(); i++) {
            if (prodList.get(i).isLike()) {
                likeList.add(prodList.get(i));
            }
        }
        return likeList;
    }

    public static ProductModel getItemPosition() {
        return prodList.get(position);
    }

}
