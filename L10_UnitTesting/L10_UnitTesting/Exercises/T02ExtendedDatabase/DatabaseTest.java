package M04_JavaOOP.L10_UnitTesting.Exercises.T02ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person PERSON_ONE = new Person(12345, "John");
    private static final Person PERSON_TWO = new Person(23456, "Mark");

    private static final Person[] PEOPLE = new Person[]{PERSON_ONE, PERSON_TWO};
    private static final Person[] TOO_BIG_ARRAY = new Person[17];
    private static final Person[] TOO_SMALL_ARRAY = new Person[0];

    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.database = new Database(PEOPLE);
    }

    @Test
    public void testShouldCreateValidDatabaseWithPeople() {
        Person[] peopleData = database.getElements();
        Assert.assertEquals(2, peopleData.length);

        for (int i = 0; i < PEOPLE.length; i++) {
            Assert.assertEquals(PEOPLE[i], peopleData[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        new Database(TOO_BIG_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForTooSmallArraySize() throws OperationNotSupportedException {
        new Database(TOO_SMALL_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testShouldThrowExceptionForNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testShouldAddPersonToDatabaseCorrectly() throws OperationNotSupportedException {
        Person validPerson = new Person(34567, "Frank");
        database.add(validPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowSExceptionForInvalidIndexInArray() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemovedLastElementFromDatabaseSuccessfully() throws OperationNotSupportedException {
        database.remove();
        Person[] dbElements = database.getElements();
        Assert.assertEquals(PEOPLE.length - 1, dbElements.length);
    }

    @Test
    public void testShouldFindPersonFromDatabaseByName() throws OperationNotSupportedException {
        database.findByUsername("John");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testExceptionForNoSuchPersonWithName() throws OperationNotSupportedException {
        database.findByUsername("Darwin");
    }

    @Test
    public void testShouldFindPersonFromDatabaseById() throws OperationNotSupportedException {
        database.findById(12345);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForNoSuchPersonInDatabase() throws OperationNotSupportedException {
        database.findById(99999);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsExceptionForNullUsername() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
}