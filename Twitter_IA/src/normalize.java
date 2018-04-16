
import static java.nio.charset.StandardCharsets.UTF_8;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Status;

public class normalize {

    private static final String ACCENTS_REGEX = "\\p{M}";
    private static final String URL_REGEX = "(((http|ftp|https):\\/\\/)?[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?)";
    private static final String PUNCTUATION_REGEX = "[\\[\\](){},.;:Â¡!Â¿?<>%$&/^*+-=~\"â€œâ€�â€¦â†”â™‚â¤µ|]";
    private static final String SPACES_REGEX = "\\s+";
    private static final String NUMBERS_REGEX = "\\d";
    private static final String PREPOSITIONS_REGEX = "\\b(a|ante|bajo|cabe|con|contra|de|desde|en|entre|hacia|hasta|para|por|segun|sin|so|sobre|tras|durante|mediante|versus|via)\\b\\s?";
    private static final String CONJUNCTIONS_REGEX = "\\b(y|o|u|e)\\b\\s?";
    private static final String PRONOUNS_REGEX = "\\b(yo|tu|el|ella|nosotros|vosotros|ellos|ustedes)\\b\\s?";
    private static final String WORDS_REGEX = "\\b(al|am|pm|asi|aun|cc|cll|da|dan|del|dos|es|esa|esta|estan|este|fue|gran|ha|hace|han|hay|he|jaja|la|las|le|les|lo|los|mas|mi|muy|ni|no|si|nos|otra|otro|photo|posted|que|q|rt|se|ser|solo|son|su|sus|tan|te|un|una|just)\\b\\s?";

    public static String removeAccents(String text) {
        String resp = Normalizer.normalize(text, Normalizer.Form.NFD);
        return resp.replaceAll(ACCENTS_REGEX, "");
    }

    public static String removeUrl(String text) {
        return text.replaceAll(URL_REGEX, "");
    }

    public static String removePunctuation(String text) {
        return text.replaceAll(PUNCTUATION_REGEX, "");
    }

    public static String removeSpaces(String text) {
        return text.replaceAll(SPACES_REGEX, " ");
    }

    public static String removeNumbers(String text) {
        return text.replaceAll(NUMBERS_REGEX, "");
    }

    public static String toLowerUpper(String text, boolean lower) {
        if (lower) {
            return text.toLowerCase();
        } else {
            return text.toUpperCase();
        }
    }

    public static String removePrepositions(String text) {
        return text.replaceAll(PREPOSITIONS_REGEX, "");
    }

    public static String removeConjunctions(String text) {
        return text.replaceAll(CONJUNCTIONS_REGEX, "");
    }

    public static String removePronouns(String text) {
        return text.replaceAll(PRONOUNS_REGEX, "");
    }
    
    public static String removeWords(String text) {
        return text.replaceAll(WORDS_REGEX, "");
    }
    
    public static String NormalizeText(String text) {
        String resp = Normalizer.normalize(text, Normalizer.Form.NFD);
        resp = resp.replaceAll(ACCENTS_REGEX, "");
        resp = resp.replaceAll(URL_REGEX, "");
        resp = resp.replaceAll(PUNCTUATION_REGEX, "");
        resp = resp.replaceAll(SPACES_REGEX, " ");
        resp = resp.replaceAll(NUMBERS_REGEX, "");
        resp = resp.toLowerCase();
        resp = resp.replaceAll(PREPOSITIONS_REGEX, "");
        resp = resp.replaceAll(CONJUNCTIONS_REGEX, "");
        resp = resp.replaceAll(PRONOUNS_REGEX, "");
        resp = resp.replaceAll(WORDS_REGEX, "");
        return resp;
    }
    
    public static String toUTF8(String s) {              
        byte[] ptext = s.getBytes(UTF_8);
        String cad = new String(ptext, UTF_8);
        cad = cad.replace("'", "");
        return cad; 
    }
    
    public static ArrayList<String> normalizeList(List<String> texts){
        ArrayList<String> resp   = new ArrayList<>();
        TextPreprocess tp = new TextPreprocess();        
        for(String text: texts){
            resp.add(NormalizeText(text));
        }        
        return resp;  
    }
}
