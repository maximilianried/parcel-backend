# Parcel delivery system

## Description
Spring parcel system backend using JPA, Spock, Spring Web and Groovy. <p>
To provide a fully functional UI the project can be extended with Webpages using thymeleaf for example. However, because this was just a quick experiment for learning purposes, I used it with Postman.

## Project Goal
This Project was created for learning more about writing REST backends with Groovy combined with Spock as the testing framework. <p>

## Docs
- Save parcel POST <br/>
  `/parcel/save` <br/>

  ```
  {
    "senderName": "John Doe",
    "senderAddress": "Anystreet 1",
    "receiverName": "Max Mustermann",
    "receiverAddress": "Musterstraße 1"
  }
  ```

- Get all parcels GET <br/>
  `/parcel/getAll`

- Get parcel by id GET <br/>
  `/parcel/get/{id}`

- Delete parcel by id DELETE <br/>
  `/parcel/delete/{id}`

- Delete all parcels DELETE <br/>
  `/parcel/deleteAll`

- Update parcel status PUT <br/>
  `/update/status/{id}/{status}`
