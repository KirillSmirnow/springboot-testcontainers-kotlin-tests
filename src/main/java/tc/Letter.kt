package tc

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Letter(

        @Id
        val id: UUID?,

        val sender: String?,
        val receiver: String?,
        val text: String?
) {
    private constructor() : this(null, null, null, null)
}
