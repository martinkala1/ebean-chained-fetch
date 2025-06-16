import org.example.Person
import org.example.query.QPerson
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun personTest() {
        val pepik = Person(firstName = "Pepik", lastName = "Ringl")
        pepik.save()

        val foundPepik =
            QPerson()
                .where()
                .lastName
                .ieq("ringl")
                .findOne()

        assert(foundPepik != null)
        assert(foundPepik!!.firstName == pepik.firstName)
        assert(foundPepik.lastName == pepik.lastName)
    }
}
