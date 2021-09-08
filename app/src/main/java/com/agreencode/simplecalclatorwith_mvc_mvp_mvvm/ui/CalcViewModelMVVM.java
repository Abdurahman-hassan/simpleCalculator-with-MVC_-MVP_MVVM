package com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.pojo.DataBase;

public class CalcViewModelMVVM extends ViewModel {

    public MutableLiveData<String> multiResultMutableLiveData = new MutableLiveData<>();
    DataBase db = new DataBase();

    public void getMultiNum(){
       int result =  db.getNumbers().getFirstNum() * db.getNumbers().getSecondNum();
       multiResultMutableLiveData.setValue(""+result);
    }


}
