package org.example

import io.ebean.Model
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.UUID

@Entity
class Person(
    @Column(name = "FIRST_NAME")
    val firstName: String = "",
    @Column(name = "LAST_NAME")
    val lastName: String = "",
    @OneToMany(mappedBy = "carOwner", cascade = [CascadeType.ALL], orphanRemoval = true)
    var cars: List<Car> = emptyList(),
    @OneToMany(mappedBy = "petOwner", cascade = [CascadeType.ALL], orphanRemoval = true)
    var pets: List<Pet> = emptyList(),
) : Model() {
    @Id
    @Column(name = "GID")
    val gid: String = UUID.randomUUID().toString()

    override fun toString() = "$firstName $lastName"
}
