package com.davis.aboutdavis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.davis.aboutdavis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val myName: MyName = MyName("Davis RIfandi")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // call funtion addnickname with click button
        binding.doneButton.setOnClickListener{addNickname(it)}

        // call function update nickname whit click textview
        binding.nicknameText.setOnClickListener { updateNickname(it) }

        // access variabel my name with object
        binding.myName = myName
    }

    // funtion for add nickname to textview
    private fun addNickname(view: View){

        // apply binding to reduce the use findviewbyid
        binding.apply {
            // add value textview from edittext
            myName?.nickname = nicknameEdit.text.toString()
            // UI refresh update
            invalidateAll()
            // hidden edit text
            nicknameEdit.visibility = View.GONE
            // hidden button
            doneButton.visibility = View.GONE
            // visible text view
            nicknameText.visibility = View.VISIBLE
        }
        // hidden keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // function for update nickname
    private fun updateNickname(view: View){

        // apply binding to reduce the use findviewbyid
        binding.apply {
            // visible edittext
            nicknameEdit.visibility = View.VISIBLE
            // visible button
            doneButton.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
            // set focus to textview
            nicknameText.requestFocus()
        }
        // show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nicknameEdit, 0)
    }
}
