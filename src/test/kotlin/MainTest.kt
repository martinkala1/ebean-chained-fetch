import org.example.Car
import org.example.Person
import org.example.Pet
import org.example.query.QPerson
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun personTest_carsWork() {
        val bobby = Person(firstName = "Bobby", lastName = "Somedude")
        bobby.save()
        val kitty = Pet("Kotik", "Cat", bobby)
        val doggie = Pet("Baron", "Dog", bobby)
        kitty.save()
        doggie.save()
        val skoda = Car("Skoda", 2003, bobby)
        val tractor = Car("Zetor", 1984, bobby)
        skoda.save()
        tractor.save()

        bobby.pets = listOf(kitty, doggie)
        bobby.cars = listOf(skoda, tractor)
        bobby.save()

        val foundBobby =
            QPerson()
                .fetch("cars", "*")
                .fetch("pets", "*")
                .where()
                .lastName
                .ieq("somedude")
                .findOne()

        assert(foundBobby != null)
        println(foundBobby)
    }

    @Test
    fun personTest_petsWork() {
        val bobby = Person(firstName = "Bobby", lastName = "Somedude")
        bobby.save()
        val kitty = Pet("Kotik", "Cat", bobby)
        val doggie = Pet("Baron", "Dog", bobby)
        kitty.save()
        doggie.save()
        val skoda = Car("Skoda", 2003, bobby)
        val tractor = Car("Zetor", 1984, bobby)
        skoda.save()
        tractor.save()

        bobby.pets = listOf(kitty, doggie)
        bobby.cars = listOf(skoda, tractor)
        bobby.save()

        val foundBobby =
            QPerson()
                .fetch("pets", "*")
                .fetch("cars", "*")
                .where()
                .lastName
                .ieq("somedude")
                .findOne()

        assert(foundBobby != null)
        println(foundBobby)
    }
}
