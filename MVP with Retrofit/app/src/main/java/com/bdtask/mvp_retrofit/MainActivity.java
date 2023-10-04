package com.bdtask.mvp_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bdtask.mvp_retrofit.Adapter.AllProductsAdapter;
import com.bdtask.mvp_retrofit.All_Interface.IMain;
import com.bdtask.mvp_retrofit.ModelData.AllProductsModel;
import com.bdtask.mvp_retrofit.ModelData.ResponseObject;
import com.bdtask.mvp_retrofit.Presenter.MainPresenter;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMain.mainView {
    IMain.mainPresenter mainPresenter;
    RecyclerView recyclerView;
    AllProductsAdapter adapter;
    Button btnAll,btnIphone,btnOppo;
    ProgressBar progress_login;
    ArrayList<ResponseObject> myListData=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    public void init(){
        mainPresenter=new MainPresenter(this);
        mainPresenter.getAllData();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btnIphone = (Button) findViewById(R.id.btnIphone);
        btnAll = (Button) findViewById(R.id.btnAll);
        btnOppo = (Button) findViewById(R.id.btnOpp);
        progress_login = (ProgressBar) findViewById(R.id.progress_login);
    }

    @Override
    public void allProductList(AllProductsModel allProductsModel) {
        Log.d("ListOfData",new Gson().toJson(allProductsModel));
        myListData.clear();
        myListData.addAll(allProductsModel.getProducts());
        adapter = new AllProductsAdapter(this,myListData);
        //recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        //  recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void hideLoading() {
        progress_login.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoading() {
      //  progress_login.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError() {

    }
}