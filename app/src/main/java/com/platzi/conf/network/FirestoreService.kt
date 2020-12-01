package com.platzi.conf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker

const val CONNFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService{
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersintenceEnabled(true).buiId()

    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(Callback: Callback<List<Speaker>>){
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
        .orderby(field: "category")
        .get()
         .addOnSuccessListener{ result =>
                for(doc in result){
                    val  list = result.toObjects(Speakers::class.java)
                    Callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(Callback: Callback<List<Conference>>){
        firebaseFirestore.collection(CONNFERENCES_COLLECTION_NAME)
        .get()
            .addOnSuccessListener{ result =>
                for(doc in result){
                    val  list = result.toObjects(Conference::class.java)
                    Callback.onSuccess(list)
                    break
                }
    }
}