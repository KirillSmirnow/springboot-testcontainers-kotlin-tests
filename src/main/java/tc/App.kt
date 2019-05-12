package tc

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Component

@Component
class AppRunner(private val letterService: LetterService) : ApplicationRunner {

    private val log = LoggerFactory.getLogger(AppRunner::class.java)

    override fun run(args: ApplicationArguments?) {
        val letter = letterService.send(LetterSend("Ben", "Leo", ":)"))
        log.info("Letter saved: $letter")
        val retrievedLetter = letterService.get(letter.id)
        log.info("Letter retrieved: $retrievedLetter")
    }
}

@SpringBootApplication
open class App

fun main() {
    SpringApplication.run(App::class.java)
}
