package org.example

import io.ebean.Model
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Car(
    @Column(name = "CAR_NAME", nullable = false)
    val model: String,
    @Column(name = "CAR_TYPE", nullable = false)
    val year: Int,
    @ManyToOne
    @JoinColumn(name = "CAR_OWNER", nullable = false)
    val carOwner: Person,
) : Model() {
    @Id
    @Column(name = "CAR_ID")
    val gid: String = UUID.randomUUID().toString()
}
