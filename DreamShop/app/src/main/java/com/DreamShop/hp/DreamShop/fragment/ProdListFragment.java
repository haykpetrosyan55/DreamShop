package com.DreamShop.hp.DreamShop.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.DreamShop.hp.DreamShop.R;
import com.DreamShop.hp.DreamShop.adapters.ProdAdapter;
import com.DreamShop.hp.DreamShop.models.Category;
import com.DreamShop.hp.DreamShop.providers.ProdProvider;

public class ProdListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProdAdapter adapter;
    private SearchView searchView;

    public ProdListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_prod_list, container, false);
        adapter = new ProdAdapter(getContext(), ProdProvider.getProdList(getContext()));
        recyclerView = view.findViewById(R.id.recyclerId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void updateAdapter() {
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void updateListData(Enum<Category> category) {
        recyclerView.setAdapter(new ProdAdapter(getActivity(), ProdProvider.getListCategory(category)));

    }

    public void setListByFavorite() {
        recyclerView.setAdapter(new ProdAdapter(getActivity(), ProdProvider.getListLike()));
    }

    public void setListByBasket() {
        recyclerView.setAdapter(new ProdAdapter(getActivity(), ProdProvider.getListBasket()));

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search_id);
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.getFilter().filter(newText);
                    return false;
                }
            });
        }
    }

}
