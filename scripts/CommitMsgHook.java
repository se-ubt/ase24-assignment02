import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CommitMsgHook {
    private static final Pattern linePattern = Pattern.compile("^([a-zA-Z0-9]+):.+$");

    public static void main(String[] args) {
        String commitMessage = args[0];
        System.out.printf("Commit Message:\n%s\n\n", commitMessage);

        Matcher lineMatcher = linePattern.matcher(commitMessage);

        if (lineMatcher.matches()) { // match entire string
            String title = lineMatcher.group(1);
            System.out.printf("Title:\n%s\n\n", title);
            System.out.println("Commit message is valid.");
            System.exit(0);
        }

        System.out.println("Commit message is invalid.");
        System.exit(1);
    }
}
