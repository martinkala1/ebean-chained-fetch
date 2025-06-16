# Chained fetch() calls on ebean query-bean

This repo demonstrates the issue, where multiple calls of `fetch()` on a QueryBean does not behave as expected and only
the first `fetch()` actually executes, the rest silently fails.

### Test
The `MainTest.kt` contains the tests to verify functionality. The created person has 2 pets and 2 cars, but when
that person is retrieved from the database, only the first `fetch()` statement is effective, the others are ignored.

### Expected Behavior
After executing both of the tests, the console should print `Bobby Somedude has 2 cars and 2 pets.` 

### Current Behavior
In `personTest_carsWork`, the console prints `Bobby Somedude has 2 cars and 0 pets.`. 

In `personTest_petsWork`, the console prints `Bobby Somedude has 0 cars and 2 pets.`. 

