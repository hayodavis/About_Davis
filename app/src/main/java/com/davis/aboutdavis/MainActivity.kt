package com.davis.aboutdavis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // call funtion addnickname with click button
        findViewById<Button>(R.id.done_button).setOnClickListener{addNickname(it)}

        // call function update nickname whit click textview
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{updateNickname(it)}
    }

    // funtion for add nickname to textview
    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        // add value textview from edittext
        nickNameTextView.text = editText.text

        // hidden edit text
        editText.visibility = View.GONE

        // hidden button
        view.visibility = View.GONE

        // visible text view
        nickNameTextView.visibility = View.VISIBLE

        // hidden keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // function for update nickname
    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        // visible edittext
        editText.visibility = View.VISIBLE

        // visible button
        doneButton.visibility = View.VISIBLE
        view.visibility = View.VISIBLE

        // set focus to edittext
        editText.requestFocus()

        // show keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
