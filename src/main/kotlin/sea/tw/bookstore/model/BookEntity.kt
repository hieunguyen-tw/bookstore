package sea.tw.bookstore.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//create book entity to work with database
//book has these field: Id, title, author, price, quantity
//javax is changed to jarkarta in newer version

@Entity
data class BookEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  val id: Long? = 0,
  val title: String,
  val author: String,
  val price: Double,
  val quantity: Int
)