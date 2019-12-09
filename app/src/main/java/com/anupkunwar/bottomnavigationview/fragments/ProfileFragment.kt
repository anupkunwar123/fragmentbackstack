package com.anupkunwar.bottomnavigationview.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anupkunwar.bottomnavigationview.R
import kotlinx.android.synthetic.main.frament_profile.*

class ProfileFragment : Fragment() {

    var message = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedInstanceState?.let {
            message = it.getString("message", "")
        }
        return inflater.inflate(R.layout.frament_profile, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("message", message)
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView.text = message
        button.setOnClickListener {
            message = "Profile :D"
            textView.text = message
        }
    }

}