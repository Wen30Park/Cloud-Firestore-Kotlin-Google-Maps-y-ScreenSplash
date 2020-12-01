package com.platzi.conf.view.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.google.type.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker

import androidx.navigation.fragment.findNavController

import com.platzi.conf.model.Ubication

import com.platzi.conf.R

/**
 * A simple [Fragment] subclass.
 */
class UbicationFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.navMapFragment) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val ubication = Ubication()

        val zoom = 16f
        val centerMap = com.google.android.gms.maps.model.LatLng(ubication.latitude, ubication.longitude)

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))

        val centerMark = com.google.android.gms.maps.model.LatLng(ubication.latitude, ubication.longitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(centerMark)
        markerOptions.title("Coferencia")

        googleMap?.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.custom_map))
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        findNavController().navigate(R.id.ubicationDetailFragmentDialog)
        return true

    }


}
