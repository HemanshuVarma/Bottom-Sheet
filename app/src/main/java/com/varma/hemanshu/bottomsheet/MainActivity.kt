package com.varma.hemanshu.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_persistent_bottom_sheet.*

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding to view
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //Handle state changes
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        showButtons()
                        Log.i(TAG, "STATE COLLAPSED")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> Log.i(TAG, "STATE EXPANDED")
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        hideButtons()
                        Log.i(TAG, "STATE DRAGGING")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> Log.i(TAG, "STATE SETTLING")
                    BottomSheetBehavior.STATE_HIDDEN -> Log.i(TAG, "STATE HIDDEN")
                    else -> Log.i(TAG, "STATE UNKNOWN")
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //Handle Slide
            }
        })

        btnPersistentBottomSheet.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                showButtons()
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
                hideButtons()
            }
        }

        btnModalBottomSheet.setOnClickListener {
            ModalBottomSheetDialog().apply {
                show(supportFragmentManager, ModalBottomSheetDialog.TAG)
            }
        }
    }

    //Controlling button visibility to VISIBLE
    private fun showButtons() {
        btnPersistentBottomSheet.visibility = View.VISIBLE
        btnModalBottomSheet.visibility = View.VISIBLE
    }

    //Controlling button visibility to GONE
    private fun hideButtons() {
        btnPersistentBottomSheet.visibility = View.GONE
        btnModalBottomSheet.visibility = View.GONE
    }

    companion object {
        const val TAG = "MainActivity"
    }
}