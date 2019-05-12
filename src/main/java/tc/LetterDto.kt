package tc

import java.util.*

data class LetterDto(
        val id: UUID,
        val sender: String,
        val receiver: String,
        val text: String
) {
    companion object StaticConstructors {

        fun of(letter: Letter): LetterDto {
            return LetterDto(letter.id!!, letter.sender!!, letter.receiver!!, letter.text!!)
        }
    }
}
