package sea.tw.bookstore

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import sea.tw.bookstore.model.BookEntity
import sea.tw.bookstore.repository.BookRepository

@SpringBootApplication
class BookstoreApplication {

  @Autowired
  private lateinit var bookRepository: BookRepository

  //create sample books in db after start using spring event listener
  //use book repository to create books
  //books have title and author from real world
  //books have random price and quantity
  @EventListener(ApplicationReadyEvent::class)
  fun setupSampleBooks() {
    bookRepository.saveAll(
      listOf(
        BookEntity(title = "Clean Code", author = "Robert C. Martin", price = 100.0, quantity = 10),
        BookEntity(
          title = "The Pragmatic Programmer",
          author = "Andrew Hunt, David Thomas",
          price = 200.0,
          quantity = 20
        ),
        BookEntity(title = "Domain-Driven Design", author = "Eric Evans", price = 150.0, quantity = 15),
        BookEntity(
          title = "Design Patterns",
          author = "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
          price = 250.0,
          quantity = 25
        ),
        BookEntity(title = "Refactoring", author = "Martin Fowler", price = 120.0, quantity = 12),
        BookEntity(
          title = "Working Effectively with Legacy Code",
          author = "Michael Feathers",
          price = 180.0,
          quantity = 18
        ),
        //give me 10 more books
        BookEntity(title = "Test Driven Development", author = "Kent Beck", price = 300.0, quantity = 30),
        BookEntity(title = "Continuous Delivery", author = "Jez Humble, David Farley", price = 210.0, quantity = 21),
        BookEntity(
          title = "Extreme Programming Explained",
          author = "Kent Beck, Cynthia Andres",
          price = 220.0,
          quantity = 22
        ),
        BookEntity(
          title = "Agile Principles, Patterns, and Practices in C#",
          author = "Robert C. Martin",
          price = 230.0,
          quantity = 23
        ),
        BookEntity(title = "Code Complete", author = "Steve McConnell", price = 240.0, quantity = 24),
        // 10 more books from history category
        BookEntity(
          title = "Sapiens: A Brief History of Humankind",
          author = "Yuval Noah Harari",
          price = 400.0,
          quantity = 40
        ),
        BookEntity(title = "Guns, Germs, and Steel", author = "Jared Diamond", price = 410.0, quantity = 41),
        BookEntity(
          title = "1491: New Revelations of the Americas Before Columbus",
          author = "Charles C. Mann",
          price = 420.0,
          quantity = 42
        ),
        BookEntity(
          title = "The Silk Roads: A New History of the World",
          author = "Peter Frankopan",
          price = 430.0,
          quantity = 43
        ),
        BookEntity(
          title = "The Swerve: How the World Became Modern",
          author = "Stephen Greenblatt",
          price = 440.0,
          quantity = 44
        ),

        )
    )
  }
}

fun main(args: Array<String>) {
  runApplication<BookstoreApplication>(*args)
}

