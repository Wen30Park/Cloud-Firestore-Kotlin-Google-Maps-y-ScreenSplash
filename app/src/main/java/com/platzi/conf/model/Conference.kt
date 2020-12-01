package com.platzi.conf.model

import java.io.Serializable
import java.util.*

class Conference: Serializable{
    lateinit var title: String
    lateinit var  description: String
    lateinit var lag: String
    lateinit var datetime: Date
}