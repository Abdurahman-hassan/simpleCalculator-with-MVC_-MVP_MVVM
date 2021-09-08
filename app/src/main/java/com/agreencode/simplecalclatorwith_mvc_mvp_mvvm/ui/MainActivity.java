package com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.R;
import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.databinding.ActivityMainBinding;
import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.pojo.DataBase;
import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.ui.MVC_MVP.CalcPresenterMVP;
import com.agreencode.simplecalclatorwith_mvc_mvp_mvvm.ui.MVC_MVP.CalcViewMVP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CalcViewMVP {

    DataBase db = new DataBase();
    CalcPresenterMVP calcPresenterMVP;
    CalcViewModelMVVM calcViewModelMVVM;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // MVC - MVP
        binding.plusButton.setOnClickListener(this);
        binding.divButton.setOnClickListener(this);
        calcPresenterMVP = new CalcPresenterMVP(this);

        // MVVM
        calcViewModelMVVM = new ViewModelProvider(this).get(CalcViewModelMVVM.class);

        binding.setViewModel(calcViewModelMVVM);
        binding.setLifecycleOwner(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //MVC
            case R.id.plus_button:
                binding.plusResultTextView.setText(String.format("%d", sum()));
                break;
            //MVP
            case R.id.div_button:
                calcPresenterMVP.getDivNum();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    // MVP
    @Override
    public void onGetResult(int result) {
        binding.divResultTextView.setText(String.format("%d", result));
    }

    public int sum() {
        return db.getNumbers().getFirstNum() + db.getNumbers().getSecondNum();
    }

}