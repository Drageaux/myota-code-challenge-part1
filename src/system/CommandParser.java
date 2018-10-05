package system;

public class CommandParser {
    enum Command {
        CMD_ROOT, CMD_ADD_CHILD, CMD_DETECT_CYCLE, CMD_RETRIEVE, CMD_QUIT;
    }

    public CommandParser(DirectorySystem ds) {

    }


    void executeCommand(Command cmd) {
        switch (cmd) {
            default:
                return;
            case CMD_ROOT:
                return;
            case CMD_ADD_CHILD:
                return;
            case CMD_DETECT_CYCLE:
                return;
            case CMD_RETRIEVE:
                return;
            case CMD_QUIT:
                return;

        }
    }
}
