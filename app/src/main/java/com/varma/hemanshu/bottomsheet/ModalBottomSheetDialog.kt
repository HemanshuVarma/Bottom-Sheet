package com.varma.hemanshu.bottomsheet

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.layout_modal_bottom_sheet.*

/**
 * Modal Bottom Sheets are modern version of dialogs but popping up from bottom of screen.
 */
class ModalBottomSheetDialog : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        firstButton.setOnClickListener {
            Toast.makeText(context, "First Button Clicked", Toast.LENGTH_SHORT).show()
        }

        secondButton.setOnClickListener {
            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
        }

        thirdButton.setOnClickListener {
            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    //Called immediately when system back is pressed or any where outside of pop-up
    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        Log.i(TAG, "Modal Bottom Sheet Cancelled")
    }

    //Called immediately after cancel
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.i(TAG, "Modal Bottom Sheet Dismissed")
    }

    companion object {
        const val TAG = "ModalBottomSheetDialog"
    }

}