import system.CommandParser;
import system.DirectorySystem;

public class Main {

    public static void main(String[] args) {

        DirectorySystem dirSystem = new DirectorySystem();
        CommandParser cmdParser = new CommandParser(dirSystem);
    }
}
