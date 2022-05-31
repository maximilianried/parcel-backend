package com.maximilianried.parcelbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id

    // Addresses for the sender and receiver
    private String senderName
    private String senderAddress
    private String receiverName
    private String receiverAddress

    // Status-codes for the parcel
    // 1 = REGISTERED, 2 = SEND, 3 = DELIVERED
    private ParcelStatus status

    // Current date given by the controller when saved
    private Date date

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getSenderName() {
        return senderName
    }

    void setSenderName(String senderName) {
        this.senderName = senderName
    }

    String getSenderAddress() {
        return senderAddress
    }

    void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress
    }

    String getReceiverName() {
        return receiverName
    }

    void setReceiverName(String receiverName) {
        this.receiverName = receiverName
    }

    String getReceiverAddress() {
        return receiverAddress
    }

    void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress
    }

    ParcelStatus getStatus() {
        return status
    }

    void setStatus(ParcelStatus status) {
        this.status = status
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }
}
