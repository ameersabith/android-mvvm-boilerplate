package com.sabith_ak.mvvmbase.util

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.sabith_ak.mvvmbase.R

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showProgressDialog(): AlertDialog {

    val builder = AlertDialog.Builder(this)
    builder.setView(R.layout.layout_gradient_progress)
    val dialog = builder.create()
    dialog.setCanceledOnTouchOutside(false)
    dialog.window!!.setBackgroundDrawable(
        ColorDrawable(Color.TRANSPARENT)
    )

    /* val tvTitle: TextView = dialowView.findViewById<TextView>(R.id.tv_title)
     if (titleFlag) {
         tvTitle.visibility = View.VISIBLE
         tvTitle.text = title ?: ""
     } else tvTitle.visibility = View.GONE*/
    dialog.show()
    return dialog

}