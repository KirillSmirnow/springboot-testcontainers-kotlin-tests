package tc

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LetterRepository : JpaRepository<Letter, UUID>
