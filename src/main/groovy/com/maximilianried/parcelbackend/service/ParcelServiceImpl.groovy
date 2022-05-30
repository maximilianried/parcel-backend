package com.maximilianried.parcelbackend.service

import com.maximilianried.parcelbackend.model.Parcel
import com.maximilianried.parcelbackend.repository.ParcelRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ParcelServiceImpl implements ParcelService{

    @Autowired
    ParcelRepository parcelRepository

    // Uses the save method to save the given parcel
    @Override
    def saveParcel(Parcel parcel) {
        return parcelRepository.save(parcel)
    }

    // Uses the findAll method to return the parcels as a list
    @Override
    List<Parcel> getAllParcels() {
        return parcelRepository.findAll()
    }

    // Returns the parcel or a Exception if id is not found
    @Override
    def getParcel(long id) {
        // Create a optional of type parcel
        Optional<Parcel> optional = parcelRepository.findById(id)

        // Check if optional with given id is present
        if (optional.isPresent()) {
            // Return option if not null
            return optional.get()
        } else {
            // Throws Exception if optional with given id is not present
            throw new NoSuchElementException("Parcel for id ${id} not found!")
        }
    }

    // Uses the deleteById method to delete the parcel by the given id
    @Override
    def deleteParcel(long id) {
        return parcelRepository.deleteById(id)
    }

    // Deletes all parcels from database with method deleteAll
    @Override
    def deleteAllParcels() {
        return parcelRepository.deleteAll()
    }

    // Changes the status by the given id to the given status-code
    @Override
    def changeStatus(long id, int status) {
        // Create a optional of type parcel
        Optional<Parcel> optional = parcelRepository.findById(id)

        // Check if optional with given id is present
        if (optional.isPresent()) {
            // Create parcel with the found optional
            Parcel parcel = optional.get()

            // Change the status-code to the given status-code
            parcel.status = status

            // Save the changed parcel to the database
            parcelRepository.save(parcel)
        } else {
            // Throws Exception if optional with given id is not present
            throw new NoSuchElementException("Parcel for id ${id} not found!")
        }
    }
}
