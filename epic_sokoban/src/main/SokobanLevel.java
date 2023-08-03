import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class SokobanLevel {
    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
        IMPOSSIBLE
    }

    public ArrayList<String> authors;
    public String name;
    public Difficulty difficulty;

    public SokobanLevel(String xmlPath)  {
        var levelFile = new File(xmlPath);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(new File("sokoban.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(levelFile));



        } catch (IOException | SAXException e) {
            System.out.println("Could not load Sokoban Level: " + e.getMessage());
            throw new RuntimeException("Could not load Sokoban level");
        }

    }
}
