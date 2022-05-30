package com.maximilianried.parcelbackend.repository

import com.maximilianried.parcelbackend.model.Parcel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParcelRepository extends JpaRepository<Parcel, Long> {
}