package com.platzi.conf.view.adapter

import com.platzi.conf.model.Conference


interface ScheduleListener {

    fun onConferenceClicked(Conference: Conference, position: Int){

    }
}