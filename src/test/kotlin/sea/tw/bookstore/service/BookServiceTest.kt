package sea.tw.bookstore.service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageRequest
import sea.tw.bookstore.repository.BookRepository

class BookServiceTest {
  //setup mock service, service is private val
  private val bookRepository = mockk<BookRepository>()
  private val bookService = BookService(bookRepository)

  //create a test to get books by pages
  //verify that repository method is called with the correct parameters
  @Test
  fun `should return page of books`() {
    // given
    val page = 0
    val size = 10

    // when
    val books = bookService.getBooks(page, size)

    // then
    //verify that repository method is called with the correct parameters
    verify { bookRepository.findAll(PageRequest.of(page, size)) }
  }



}