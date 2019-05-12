package tc

import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import java.util.*
import kotlin.test.assertEquals

@ContextConfiguration(classes = [LetterServiceTestConfig::class])
class LetterServiceTest : JpaSpringTest() {

    @Autowired
    private lateinit var letterService: LetterService

    private lateinit var existingLetter: LetterDto

    @Before
    fun init() {
        existingLetter = letterService.send(LetterSend("sender", "receiver", "text"))
    }

    @Test(expected = TcException::class)
    fun `When get Letter by nonexistent ID, then fail`() {
        val nonExistingId = UUID.randomUUID()
        letterService.get(nonExistingId)
    }

    @Test
    fun `When get Letter by existing ID, then return same data`() {
        val letter = letterService.get(existingLetter.id)
        assertEquals(existingLetter, letter)
    }

    @Test
    fun `When send Letter, then return the same data`() {
        val sender = "abc"
        val receiver = "xyz"
        val text = "Hello, World!"
        val letter = letterService.send(LetterSend(sender, receiver, text))
        assertEquals(sender, letter.sender)
        assertEquals(receiver, letter.receiver)
        assertEquals(text, letter.text)
    }
}
