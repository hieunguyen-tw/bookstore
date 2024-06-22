package sea.tw.bookstore.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import sea.tw.bookstore.model.BookEntity
import sea.tw.bookstore.repository.BookRepository

@Service
class BookService(
  private val bookRepository: BookRepository
) {
  fun getBooks(page: Int, size: Int): Page<BookEntity> {
    //delegate to repository
    return bookRepository.findAll(PageRequest.of(page, size))
  }

  //create methods to get, create, update, and delete books, delegate them to repository
  fun getBooks(): List<BookEntity> {
    return bookRepository.findAll().toList()
  }

  fun createBook(book: BookEntity): BookEntity {
    return bookRepository.save(book)
  }
}