package com.maximilianried.parcelbackend.service

import com.maximilianried.parcelbackend.model.Parcel

interface ParcelService {

    def saveParcel(Parcel parcel)
    def List<Parcel> getAllParcels()
    def getParcel(long id)
    def deleteParcel(long id)
    def deleteAllParcels()
    def changeStatus(long id, int status)
}