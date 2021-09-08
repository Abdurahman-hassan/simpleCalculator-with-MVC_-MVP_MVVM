package com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.ui.MVC_MVP;

import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.pojo.DataBase;
public class CalcPresenterMVP {
    CalcViewMVP view;
    DataBase db = new DataBase();

    public CalcPresenterMVP(CalcViewMVP view) {
        this.view = view;
    }

    public void getDivNum(){
        view.onGetResult(div());
    }

    public int div(){
        return db.getNumbers().getFirstNum() / db.getNumbers().getSecondNum();
    }



}
