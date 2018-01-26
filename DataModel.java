package com.example.antoine.projet_contact;

import android.location.Address;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Antoine on 23/01/2018.
 */

public class DataModel {
    private String name;
    private String fname;
    private String contact;
    private String address;
    private LatLng pos;

    public DataModel(String _name, String _contact, LatLng _pos, String _fname, String _adress) {
        this.name = _name;
        this.contact = _contact;
        this.pos = _pos;
        this.fname = _fname;
        this.address = _adress;
    }

    public String getName() {
        return name;
    }
    public String getContact() {
        return contact;
    }
    public LatLng getPos() {return pos;}
    public String getFname() {
        return fname;
    }
    public String getAddress() {
        return address;
    }
}
