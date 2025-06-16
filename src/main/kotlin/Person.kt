package org.example

import io.ebean.Model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.UUID

@Entity
class Person(
    @Id
    @Column(name = "GID")
    val gid: String = UUID.randomUUID().toString(),
    @Column(name = "FIRST_NAME")
    val firstName: String = "",
    @Column(name = "LAST_NAME")
    val lastName: String = "",
) : Model() {
    override fun toString() = "$firstName $lastName"
}
