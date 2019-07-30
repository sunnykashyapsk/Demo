package com.example.lenovo.taskdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText editText1,editText2,editText3;
    private poplistner listner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listner = (poplistner) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+ "must implement");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.popupsend,null);

        builder.setView(view)
                .setTitle("Email")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String to = editText1.getText().toString();
                        String subject= editText2.getText().toString();
                        String message= editText3.getText().toString();
                        listner.apply(to,subject,message);

                    }
                });

        editText1=view.findViewById(R.id.to);
        editText2=view.findViewById(R.id.subject);
        editText3=view.findViewById(R.id.emessage);

        return builder.create();
    }

    public interface poplistner{
        void apply(String to,String subject,String message);
    }
}

