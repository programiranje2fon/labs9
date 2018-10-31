# Lab exercise 6

## Task 1
(to be done by the tutor together with students)

Create a public class **Book**, in the package **task1**, with:

1. Private attribute **title** that represents the title of the book.
2. Private attribute **year** that represents the year of publication of the book (integer).
3. Public **get and set methods** for the two attributes.
4. Redefined public method **equals** of the Object class. The method first checks if the input object is of the class **Book**, and if it is not, it returns FALSE. The method returns TRUE if the book's title and year of publication are equal to the title and publication year of the entered book, otherwise it returns FALSE.

Create public class **TestBook** in the package **task1**. In the main method of this class, create one object of the class **Book** and print the length of the book's title.

Extend class **Book** as follows:

1. The initial value for the **title** attribute is an empty String ("").
2. Edit the **set method for the title attribute** so that the title can not be NULL. If NULL is passed as the parameter value, throw an **unchecked exception** with message "Title cannot be NULL".

Modify the **TestBook** class so that the title of the (existing) book object is set to NULL. Catch the unchecked exception thrown by the **setTitle** method and print the error message in the console.

Extend class **Book** as follows: 

1. Modify the **set method for the year attribute**. If the value passed to the method is not in the range from 1950 (including this year) to the current year, throw a **checked exception** with the message "Year is not in the appropriate range".

Modify the **TestBook** class so that the year of publication of the (existing) book object is set to 2015. Catch the exception that may be thrown by the method **setYear** and if the exception is thrown, print the error message in the console.
<br><br>

Create the **Library** class, in the package **task1.library**, with the following elements:

1. Private attribute **books** (type List) that represents a list of objects of the **Book** class. Initialize the list as a **LinkedList**.
2. Public method **addBook** that receives as its input parameter an instance of the Book class and adds it to the end of the list.
3. Public method **isItAvailable** that receives an object of the Book class as the input parameter. The method returns TRUE if there is a book with the same title and publication year in the list; otherwise the method returns FALSE.
4. Public method **deleteBook** that receives an object of the Book class as its input parameter, and if the book is in the list, deletes it from the list.
5. Public method **searchBooks** that receives a String as the input parameter. The method finds and returns a list of all books in the library whose titles start with the text given as the parameter.
6. Public method **archiveBooks** that receives as its parameter an integer representing a year. The method finds and removes from the books list those books that were published either before or during the given year.

Create the **TestLibrary** class in the package **task1.library**. In the main method of this class, create one object of the **Library** class. In addition, create two objects of the **Book** class:
- Title: "Signs by the Road", year: 1976
- Title: "Mansard", year: 1960

Add both books to the library. Then, archive all the books that were published in 2010.


## Task 2
*(students work on it on their own)*

Create a public class **Restaurant** in the package **task2**, which has:

1. Private attribute **name**.
2. Private attribute **rating** that represents the rating of restaurants from 1 to 5.
3. Public **get and set methods** for the two attributes. The attribute name must be neither NULL, nor an empty String. The rating attribute must be in the range 1 to 5. In case of entering illegal values, an **unchecked** exception should be thrown with the message "ERROR".

Make class **RestaurantGuide** in the package **task2**, which has:
1. Private attribute **restaurants** (type List) that represents a list of objects of the Restaurant class.
2. Public **constructor** that initializes the **restaurants** list as **ArrayList**.
3. Public method **addAsFirst** that receives as its input parameter an object of the class **Restaurant** and adds it to the beginning of the list.
4. Public method **printsRestaurantsWithRating** that receives as its input parameter a rating value and prints names of all restaurants with the given rating.
5. Public method **removeBadRestaurants** that from the list **restaurants** removes all restaurants with rating equal to 1.

Create **TestRestorants** class in the package **task2**. In the main method of this class, create one object of the RestorantGuide class and add to it the following restaurants: "Blue Hill" (rating 4), "Per Se" (rating 1), "Daniel" (rating 4). Print all restaurants with the rating 4, and then delete the bad restaurants from the guide.