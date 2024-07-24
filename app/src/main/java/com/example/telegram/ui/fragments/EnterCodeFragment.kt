package com.example.telegram.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.telegram.R
import com.example.telegram.utilits.AppTextWatcher
import com.example.telegram.utilits.showToast

class EnterCodeFragment : BaseFragment(R.layout.fragment_enter_code) {

    private lateinit var mInputCode: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInputCode = view.findViewById<EditText>(R.id.register_input_code)
        mInputCode.addTextChangedListener(
            AppTextWatcher  {
                    val string = mInputCode.text.toString()
                    if (string.length == 6) {
                        verifyCode()
                    }
            }
        )
    }

    private fun verifyCode() {
        showToast("OK")
    }
}