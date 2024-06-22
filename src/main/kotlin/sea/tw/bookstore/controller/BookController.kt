package sea.tw.bookstore.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import sea.tw.bookstore.model.BookEntity
import sea.tw.bookstore.service.BookService

@RestController
@RequestMapping("/api/v1/book")
class BookController(@Autowired private val bookService: BookService) {


  //create an api to get books by pages
  //delegate to service
  //can be accessed by GET /api/v1/book?page=0&size=10
  //default value of page is 0, size is 10
  @GetMapping
  fun getBooks(
    @RequestParam("page", defaultValue = "0") page: Int,
    @RequestParam("size", defaultValue = "10") size: Int
  ): List<BookEntity> {
    return bookService.getBooks(page, size).toList()
  }

  //create an api to create a book
  //delegate to service
  //can be accessed by POST /api/v1/book
  @PostMapping
  fun createBook(@RequestBody book: BookEntity): BookEntity {
    return bookService.createBook(book)
  }
}