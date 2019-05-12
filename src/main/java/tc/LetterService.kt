package tc

import java.util.*

interface LetterService {

    fun send(letterSend: LetterSend): LetterDto

    fun get(id: UUID): LetterDto
}
