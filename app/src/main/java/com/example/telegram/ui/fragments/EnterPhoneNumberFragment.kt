package com.example.telegram.ui.fragments


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.telegram.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

        private lateinit var mButton: FloatingActionButton;
        private lateinit var mInputNumber: EditText


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mButton = view.findViewById<FloatingActionButton>(R.id.register_btn_next)
        mInputNumber = view.findViewById<EditText>(R.id.register_input_phone_number)
        mButton.setOnClickListener{sendCode()}
    }

    private fun sendCode() {
        if(mInputNumber.text.toString().isEmpty()){
            Toast.makeText(activity, getString(R.string.register_toast_enter_phone), Toast.LENGTH_SHORT).show()
        } else {
            parentFragmentManager.beginTransaction().replace(R.id.registerDataContainer, EnterCodeFragment())
                .addToBackStack(null)
                .commit()
        }


    }

}