package com.maximilianried.parcelbackend

import com.maximilianried.parcelbackend.controller.ParcelController
import com.maximilianried.parcelbackend.model.Parcel
import com.maximilianried.parcelbackend.model.ParcelStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ParcelControllerTests extends Specification {

	@Autowired
	private ParcelController parcelController

	TestRestTemplate restTemplate = new TestRestTemplate()

	def "save parcels"() {

		// Create the parcel
		Parcel parcel = new Parcel()
		parcel.setSenderName(senderName)
		parcel.setSenderAddress(senderAddress)
		parcel.setReceiverName(receiverName)
		parcel.setReceiverAddress(receiverAddress)

		// Save the created parcel
		parcelController.saveParcel(parcel)

		expect:
		parcelController.getParcel(index)

		// Data table with the values for the parcels
		where:
		index 	| senderName 	| senderAddress 	| receiverName 	| receiverAddress 	| statusCode
		1 		| "Max" 		| "Musterstraße" 	| "Paul" 		| "Grimmstraße" 	| ParcelStatus.REGISTERED
		2 		| "Jake" 		| "Westminster" 	| "Tom" 		| "Bonnstraße" 		| ParcelStatus.REGISTERED
		3 		| "Tim" 		| "Tomstreet" 		| "Tik" 		| "Koelnstraße" 	| ParcelStatus.REGISTERED
		4 		| "Peter" 		| "Anystreet" 		| "Track" 		| "Verteilerstraße" | ParcelStatus.REGISTERED
	}

	def "get parcel"() {

		// Get parcel with ID 1
		Parcel parcel = parcelController.getParcel(1)

		expect:
		parcel.senderName == "Max"
		parcel.senderAddress == "Musterstraße"
		parcel.receiverName == "Paul"
		parcel.receiverAddress == "Grimmstraße"
		parcel.status == ParcelStatus.REGISTERED
	}

	def "get all parcels"() {

		// Get all parcels as a list
		List<Parcel> list = parcelController.getAllParcels()

		expect:
		list.size() == 4
	}

	def "update parcel status"() {

		// Change status for parcel with ID 1 to status-code 2: SEND
		parcelController.changeStatus(1,2)

		expect:
		Parcel parcel = parcelController.getParcel(1)
		parcel.status == ParcelStatus.SEND
	}

	def "delete parcel"() {

		// Delete parcel with ID 1
		parcelController.deleteParcel(1)

		// Get List of all parcels
		List<Parcel> list = parcelController.getAllParcels()

		expect:
		list.size() == 3
	}

	def "delete all parcels"() {

		// Delete all parcels from DB
		parcelController.deleteAllParcels()

		// Get List of all parcels
		List<Parcel> list = parcelController.getAllParcels()

		expect:
		list.size() == 0
	}
}
