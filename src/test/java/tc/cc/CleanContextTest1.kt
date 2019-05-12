package tc.cc

import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import tc.JpaSpringTest
import tc.Letter
import tc.LetterRepository
import tc.LetterServiceTestConfig
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.test.assertEquals

@ContextConfiguration(classes = [LetterServiceTestConfig::class])
class CleanContextTest1 : JpaSpringTest() {

    private val initialLettersCount = ThreadLocalRandom.current().nextInt(0, 100)

    @Autowired
    private lateinit var letterRepository: LetterRepository

    @Before
    fun init() = saveLetters(initialLettersCount)

    @Test
    fun test1() = test()

    @Test
    fun test2() = test()

    @Test
    fun test3() = test()

    private fun test() {
        val saveLettersCount = ThreadLocalRandom.current().nextInt(0, 100)
        assertEquals(initialLettersCount.toLong(), letterRepository.count())
        saveLetters(saveLettersCount)
        assertEquals(initialLettersCount.toLong() + saveLettersCount, letterRepository.count())
    }

    private fun saveLetters(count: Int) {
        for (i in 1..count) {
            letterRepository.save(Letter(UUID.randomUUID(), "", "", ""))
        }
    }
}
