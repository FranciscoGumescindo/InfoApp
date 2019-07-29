package com.android.aaronbonilla.infoapp.Activities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
/**
 * Clase Utilizada para el la ubicacion en el Mapa....
 */
public class UpdateLocation implements LocationListener{
    private MapsActivity actividad;

    public UpdateLocation(MapsActivity actividad) {
        this.actividad = actividad;
    }

    @Override
    public void onLocationChanged(Location location) {
        actividad.actualizaPosicionActual(location);
    }
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }
}