/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package westviewfamilymedicine.com.mvpsample.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import westviewfamilymedicine.com.mvpsample.Adapter.ImageAdapter;
import westviewfamilymedicine.com.mvpsample.Model.GetAllData;
import westviewfamilymedicine.com.mvpsample.R;

public class MainActivity extends Activity implements MainView, ImageAdapter.OnRowClickListener {

    private RecyclerView listView;
    private ProgressBar progressBar;
    private MainPresenter presenter;
    private List<GetAllData> data = new ArrayList<>();
    private ImageAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView) findViewById(R.id.list);
        //listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        presenter = new MainPresenterImpl(this, new FindItemsInteractorImpl());

    }

    @Override protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override public void setItems(List<GetAllData> items) {
        data.clear();
        data = items;
        mLayoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());
        mAdapter  = new ImageAdapter(this, items);
        mAdapter.setOnRowClickListenere(this);
        listView.setAdapter(mAdapter);
        //mAdapter.notifyDataChange(items);
        Toast.makeText(this,"Fetch Successfully",Toast.LENGTH_SHORT).show();
    }

    @Override public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onOwnerClick(int position) {

        presenter.onItemClicked(position,data);
    }

    @Override
    public void onApplyClick(int position){

        presenter.onApplyClicked(position);

    }
}
