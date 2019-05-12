package tc

import org.springframework.stereotype.Service
import tc.LetterDto.StaticConstructors.of
import java.util.*

@Service
class LetterServiceImpl(private val letterRepository: LetterRepository) : LetterService {

    override fun send(letterSend: LetterSend): LetterDto {
        val id = UUID.randomUUID()
        val letter = Letter(id, letterSend.sender, letterSend.receiver, letterSend.text)
        letterRepository.save(letter)
        return get(id)
    }

    override fun get(id: UUID): LetterDto {
        return letterRepository.findById(id)
                .map(LetterDto.StaticConstructors::of)
                .orElseThrow { TcException("Letter not found") }
    }
}
