import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.lexicon.command.CommandLineUser;
import se.lexicon.command.CommandLineUserImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CommandLineUserTest {

    private CommandLineUser cluTest;
@Test
    void test_create_new_student_successfully(){
        String userInput = String.format("ly%sly@mail.com%sväxjö",
                System.lineSeparator(),
                System.lineSeparator());

    ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(bais);

    String expected = "Student{id=1, name='ly', email='ly@mail.com', address='växjö'}";
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    CommandLineUser commandLineUser= new CommandLineUserImpl();
    commandLineUser.createNewStudent();

    String[] lines = baos.toString().split(System.lineSeparator());
    String actual = lines[lines.length-1];
    Assertions.assertEquals(expected, actual);
    }
    @Test
    void test_create_course_successfully(){
    String input = String.format("Java%s2022-12-15%s4",
            System.lineSeparator(),
            System.lineSeparator());
    ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
    System.setIn(bais);

    String expected = "Course{courseId=1, courseName='Java', startDate=2022-12-15, weekDuration=4, students=[], teacher=null, lectures=null}";
    ByteArrayOutputStream baos= new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    CommandLineUser commandLineUser = new CommandLineUserImpl();
    commandLineUser.createNewCourse();

    String[] lines = baos.toString().split(System.lineSeparator());
    String actual = lines[lines.length-1];

    Assertions.assertEquals(expected, actual);

    }


}
