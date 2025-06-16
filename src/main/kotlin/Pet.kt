package org.example

import io.ebean.Model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Pet(
    @Column(name = "PET_NAME")
    val name: String,
    @Column(name = "PET_TYPE")
    val type: String,
) : Model() {
    @Id
    @Column(name = "PET_ID")
    val gid: String = UUID.randomUUID().toString()
}
