package com.maximilianried.parcelbackend.controller

import com.maximilianried.parcelbackend.model.Parcel
import com.maximilianried.parcelbackend.model.ParcelStatus
import com.maximilianried.parcelbackend.service.ParcelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/parcel")
class ParcelController {

    @Autowired
    private ParcelService parcelService

    // Append date and status-code then save parcel
    @PostMapping("/save")
    def saveParcel(@RequestBody Parcel parcel) {
        parcelService.saveParcel(parcel)
        return "Parcel is saved"
    }

    // Get all parcels as list
    @GetMapping("/getAll")
    def getAllParcels() {
        return parcelService.getAllParcels()
    }

    // Get parcel by id
    @GetMapping("/get/{id}")
    def getParcel(@PathVariable (value = "id") Long id) {
        return parcelService.getParcel(id)
    }

    // Delete parcel by id
    @DeleteMapping("/delete/{id}")
    def deleteParcel(@PathVariable (value = "id") Long id) {
        parcelService.deleteParcel(id)
        return "Parcel with id ${id} is deleted"
    }

    @DeleteMapping("/deleteAll")
    def deleteAllParcels() {
        parcelService.deleteAllParcels()
        return "All parcels are deleted"
    }

    // Update parcel status by id and status-code
    @PutMapping("/update/status/{id}/{status}")
    def changeStatus(@PathVariable (value = "id") Long id, @PathVariable (value = "status") Integer status) {
        parcelService.changeStatus(id, status)
        return "Parcel with id ${id} changed status to ${status}"
    }
}
