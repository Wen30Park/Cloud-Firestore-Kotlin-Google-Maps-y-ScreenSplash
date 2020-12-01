package com.platzi.conf.view.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.platzi.conf.R

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.platzi.conf.model.Speaker
import com.platzi.conf.view.adapter.SpeakerAdapter
import com.platzi.conf.view.adapter.SpeakerListener
import com.platzi.conf.viewmodel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*

/**
 * A simple [Fragment] subclass.
 */
class SpeakersFragment : Fragment() {
    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel: SpeakersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()


        rvSpeakers.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = speakerAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.listSpeakers.observe(this,Observer<List<Speaker>> { speakers ->
            speakers.let {
                speakerAdapter.updateData(speakers)
            }
            viewModel.isLoading.observe(this,Observer<Boolean> {
                if(it != null)
                    rlBase.visibility = View.INVISIBLE
            } )
        })
    }


}
