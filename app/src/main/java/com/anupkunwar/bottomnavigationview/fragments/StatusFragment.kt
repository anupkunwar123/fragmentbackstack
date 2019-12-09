package com.anupkunwar.bottomnavigationview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anupkunwar.bottomnavigationview.R
import kotlinx.android.synthetic.main.fragment_status.*


class StatusFragment : Fragment() {

    var message = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedInstanceState?.let {
            message = it.getString("message", "")
        }
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView.text = message
        button.setOnClickListener {
            message = "Your Status !!"
            textView.text = message
        }
    }
}