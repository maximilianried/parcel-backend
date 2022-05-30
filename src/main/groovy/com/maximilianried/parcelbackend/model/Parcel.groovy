package com.maximilianried.parcelbackend.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id

    // Addresses for the sender and receiver
    private String senderName
    private String senderAddress
    private String receiverName
    private String receiverAddress

    // Status-codes for the parcel
    // 1 = registered, 2 = send, 3 = received
    private int status

    // Current date given by the controller when saved
    private Date date

    long getId() {
        return id
    }

    void setId(long id) {
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

    int getStatus() {
        return status
    }

    void setStatus(int status) {
        this.status = status
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }
}
