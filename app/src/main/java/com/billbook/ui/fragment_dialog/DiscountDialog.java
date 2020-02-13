package com.billbook.ui.fragment_dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.billbook.R;

public class DiscountDialog extends DialogFragment {
    String TAG = DiscountDialog.class.getName();
    Activity activity;
    LayoutInflater inflater;
    private AlertDialog d;

    public static DiscountDialog getInstance(String someArgument) {
        DiscountDialog appCompatMaterialAlertDialog = new DiscountDialog();
        Bundle bundle = new Bundle();
        bundle.putString("someArgument", someArgument);
        appCompatMaterialAlertDialog.setArguments(bundle);
        return appCompatMaterialAlertDialog;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.activity = getActivity();
        this.inflater = activity.getLayoutInflater();
        Bundle bundle = getArguments();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_discount_dialog, null);
        initDialogUi(v);
        d = new AlertDialog.Builder(activity, R.style.AppCompatAlertDialogStyleTwo)
                .setTitle(getString(R.string.add_discount))
                .setCancelable(false)
                .setPositiveButton(activity.getString(R.string.submit),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                .setNegativeButton(activity.getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dismiss();
                            }
                        })
                .setView(v)
                .create();

        // change color of positive button
        d.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button b = d.getButton(DialogInterface.BUTTON_POSITIVE);
                //b.setTextColor(getResources().getColor(R.color.colorPrimary));
            }
        });
        setCancelable(false);
        d.setCanceledOnTouchOutside(false);

        return d;
    }

    @Override
    public void onStart() {
        super.onStart();
        super.onStart();    //super.onStart() is where dialog.show() is actually called on the underlying dialog, so we have to do it after this point
        d = (AlertDialog) getDialog();
        if (d != null) {
            Button positiveButton = d.getButton(Dialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        doSomething();
                }
            });
        }
    }

    private void doSomething() {


    }

    private void initDialogUi(View root)
    {

    }
}
