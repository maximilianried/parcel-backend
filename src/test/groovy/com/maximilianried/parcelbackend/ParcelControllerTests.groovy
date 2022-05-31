package com.maximilianried.parcelbackend

import com.maximilianried.parcelbackend.controller.ParcelController
import com.maximilianried.parcelbackend.model.Parcel
import com.maximilianried.parcelbackend.model.ParcelStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ParcelControllerTests extends Specification {

	@Autowired
	private ParcelController parcelController

	TestRestTemplate restTemplate = new TestRestTemplate()

	def "save and get parcels"() {

		// Create the parcel and save it
		Parcel parcel = new Parcel()
		parcel.setSenderName(senderName)
		parcel.setSenderAddress(senderAddress)
		parcel.setReceiverName(receiverName)
		parcel.setReceiverAddress(receiverAddress)
		parcelController.saveParcel(parcel)

		// Get the parcel and check the response
		expect:
		ResponseEntity<Parcel> responseEntity = restTemplate.getForEntity("http://localhost:8080/parcel/get/" + index, Parcel)
		responseEntity.statusCode == HttpStatus.OK
		responseEntity.getBody().senderName == senderName
		responseEntity.getBody().senderAddress == senderAddress
		responseEntity.getBody().receiverName == receiverName
		responseEntity.getBody().receiverAddress == receiverAddress
		responseEntity.getBody().status == statusCode

		// Data table with the values for the parcels
		where:
		index 	| senderName 	| senderAddress 	| receiverName 	| receiverAddress 	| statusCode
		1 		| "Max" 		| "Musterstraße" 	| "Paul" 		| "Grimmstraße" 	| ParcelStatus.REGISTERED
		2 		| "Jake" 		| "Westminster" 	| "Tom" 		| "Bonnstraße" 		| ParcelStatus.REGISTERED
		3 		| "Tim" 		| "Tomstreet" 		| "Tik" 		| "Koelnstraße" 	| ParcelStatus.REGISTERED
		4 		| "Peter" 		| "Anystreet" 		| "Track" 		| "Verteilerstraße" | ParcelStatus.REGISTERED
	}

}
