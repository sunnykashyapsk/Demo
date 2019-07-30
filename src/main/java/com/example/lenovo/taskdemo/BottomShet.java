package com.example.lenovo.taskdemo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BottomShet extends BottomSheetDialogFragment {
    private bottomsheetlistner mlistner;
    CardView cv1,cv2,cv3,cv4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.bottomsheet,container,false);


        cv1= v.findViewById(R.id.paytmcash);
        cv2= v.findViewById(R.id.hdfc);
        cv3= v.findViewById(R.id.axis);
        cv4= v.findViewById(R.id.upi);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistner.listner(1);

            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistner.listner(2);
            }
        });
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistner.listner(3);
            }
        });
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlistner.listner(4);
            }
        });
        return v;
    }



    public interface bottomsheetlistner{
        void listner(int a);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mlistner = ( bottomsheetlistner ) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement");
        }
    }
}

