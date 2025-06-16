@file:Suppress("ktlint:standard:no-wildcard-imports")

package org.example

import io.ebean.Model
import jakarta.persistence.*
import java.util.UUID

@Entity
class Pet(
    @Column(name = "PET_NAME")
    val name: String,
    @Column(name = "PET_TYPE")
    val type: String,
    @ManyToOne
    @JoinColumn(name = "PET_OWNER", nullable = false)
    val petOwner: Person,
) : Model() {
    @Id
    @Column(name = "PET_ID")
    val gid: String = UUID.randomUUID().toString()
}
