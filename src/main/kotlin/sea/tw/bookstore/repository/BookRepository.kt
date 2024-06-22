package sea.tw.bookstore.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import sea.tw.bookstore.model.BookEntity

@Repository
interface BookRepository : PagingAndSortingRepository<BookEntity, Long>, JpaRepository<BookEntity, Long>