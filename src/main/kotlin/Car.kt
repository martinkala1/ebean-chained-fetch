package org.example

import io.ebean.Model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Car(
    @Column(name = "CAR_NAME")
    val model: String,
    @Column(name = "CAR_TYPE")
    val year: Int,
) : Model() {
    @Id
    @Column(name = "CAR_ID")
    val gid: String = UUID.randomUUID().toString()
}
