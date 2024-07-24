package com.example.telegram.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.telegram.R

class EnterCodeFragment : BaseFragment(R.layout.fragment_enter_code) {

    private lateinit var mInputCode: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInputCode = view.findViewById<EditText>(R.id.register_input_code)
        mInputCode.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    val string = mInputCode.text.toString()
                    if (string.length == 6) {
                        verifyCode()
                    }
                }

            }
        )
    }

    fun verifyCode() {
        Toast.makeText(activity, "OK", Toast.LENGTH_SHORT).show()
    }

}