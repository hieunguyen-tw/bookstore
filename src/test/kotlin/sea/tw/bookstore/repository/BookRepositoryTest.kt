package sea.tw.bookstore.repository

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.greaterThan
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class BookRepositoryTest {

  @Autowired
  private lateinit var bookRepository: BookRepository

  @Test
  fun `should return page of books`() {
    // given

    val page = 0
    val size = 10

    // when
    val books = bookRepository.findAll(PageRequest.of(page, size))

    // then
    assertThat(books.totalElements, greaterThan(0))
  }
}