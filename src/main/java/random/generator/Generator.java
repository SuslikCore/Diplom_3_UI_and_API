package random.generator;
import org.apache.commons.text.RandomStringGenerator;


public class Generator {

    public String generateEmail(int length) {

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();

        String generatedEmail = generator.generate(length) + "@mail.ru";

        return generatedEmail.toLowerCase();
    }

    public String generatePassword(int length) {

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();

        String generatedPassword = generator.generate(length);

        return generatedPassword.toLowerCase();
    }

    public String generateUserName(int length) {

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();

        String generatedUserName = generator.generate(length) + "User";

        return generatedUserName.toLowerCase();
    }



}
