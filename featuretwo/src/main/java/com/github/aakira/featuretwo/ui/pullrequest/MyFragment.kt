package com.github.aakira.featuretwo.ui.repolist

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.github.aakira.featuretwo.R
import com.github.aakira.featuretwo.di.FeatureTwoModuleInjector
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MyFragment : Fragment() {

    @Inject
    internal lateinit var preferences: SharedPreferences
//    @Inject
//    internal lateinit var context: Context

    private lateinit var number: String

    companion object {

        fun newInstance(number: Int): MyFragment {
            return MyFragment().apply {
                arguments = Bundle().apply {
                    putInt("qwe", number)
                }
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidSupportInjection.inject(this)

        FeatureTwoModuleInjector.inject(this)
        super.onCreate(savedInstanceState)
//        DaggerFragmentComponent
//                .builder()
//                .inject(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)
        setHasOptionsMenu(true)
        number = arguments!!.getInt("qwe").toString()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferences.edit().putString("qwe", number).apply()
        view.findViewById<TextView>(R.id.textView).apply {
            text = number
            setOnClickListener {
                (activity as RepositoryListActivity).pushFragment(MyFragment.newInstance(number.toInt() + 1))
            }
        }
    }
}
