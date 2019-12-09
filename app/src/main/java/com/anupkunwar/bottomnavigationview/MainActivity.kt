package com.anupkunwar.bottomnavigationview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.anupkunwar.bottomnavigationview.fragments.AccountFragment
import com.anupkunwar.bottomnavigationview.fragments.ProfileFragment
import com.anupkunwar.bottomnavigationview.fragments.StatusFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentSavedState: HashMap<String, Fragment.SavedState?>

    companion object {
        private const val ACCOUNT = "account"
        private const val STATUS = "status"
        private const val PROFILE = "profile"
        private const val FRAGMENT_STATE = "fragmentState"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            fragmentSavedState = HashMap()
            replaceFragment(ACCOUNT)

        } else {
            fragmentSavedState =
                savedInstanceState.getSerializable(FRAGMENT_STATE) as HashMap<String, Fragment.SavedState?>
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putSerializable(FRAGMENT_STATE, fragmentSavedState)
        super.onSaveInstanceState(outState)
    }


    private fun replaceFragment(fragmentTag: String) {
        val newFrag: Fragment? = when (fragmentTag) {
            ACCOUNT -> AccountFragment()
            PROFILE -> ProfileFragment()
            STATUS -> StatusFragment()
            else -> null
        }

        val currFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer)


        //check if fragment is already there, if not then only proceed
        if (!currFragment?.tag.equals(fragmentTag)) {
            currFragment?.let { frag ->

                //save state of current fragment

                fragmentSavedState.put(
                    frag.tag!!,
                    supportFragmentManager.saveFragmentInstanceState(frag)
                )


            }

            //set initial state of fragment if there is any


            newFrag?.setInitialSavedState(fragmentSavedState[fragmentTag])
            newFrag?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, it, fragmentTag)
                    .commit()
            }
        }


    }
}
