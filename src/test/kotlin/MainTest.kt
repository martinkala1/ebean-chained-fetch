import org.example.Car
import org.example.Person
import org.example.Pet
import org.example.query.QPerson
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun personTest() {
        val pepik = Person(firstName = "Pepik", lastName = "Ringl")
        pepik.save()
        val kocicka = Pet("Kotik", "Cat", pepik)
        val pejsek = Pet("Baron", "Idiot dog", pepik)
        kocicka.save()
        pejsek.save()
        val shitbox = Car("ShitBox", 2003, pepik)
        val traktor = Car("Zetor", 1984, pepik)
        shitbox.save()
        traktor.save()

        pepik.pets = listOf(kocicka, pejsek)
        pepik.cars = listOf(shitbox, traktor)
        pepik.save()

        val foundPepik =
            QPerson()
                .fetch("pets")
                .fetch("cars")
                .where()
                .lastName
                .ieq("ringl")
                .findOne()

        assert(foundPepik != null)
        assert(foundPepik!!.firstName == pepik.firstName)
        assert(foundPepik.lastName == pepik.lastName)
    }
}
