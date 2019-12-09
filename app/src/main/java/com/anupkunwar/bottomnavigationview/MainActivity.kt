package com.anupkunwar.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.anupkunwar.bottomnavigationview.fragments.AccountFragment
import com.anupkunwar.bottomnavigationview.fragments.ProfileFragment
import com.anupkunwar.bottomnavigationview.fragments.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ACCOUNT = "account"
        const val STATUS = "status"
        const val PROFILE = "profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            replaceFragment(ACCOUNT)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.account -> replaceFragment(ACCOUNT)
                R.id.profile -> replaceFragment(PROFILE)
                R.id.status -> replaceFragment(STATUS)
            }
            true
        }
    }


    private fun replaceFragment(fragmentTag: String) {
        var newFrag: Fragment? = when (fragmentTag) {
            ACCOUNT -> AccountFragment()
            PROFILE -> ProfileFragment()
            STATUS -> StatusFragment()
            else -> null
        }

        newFrag?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, it, fragmentTag).commit()
        }
    }
}
