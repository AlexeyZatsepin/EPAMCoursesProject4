package controller.commands;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public enum CommandList {
    INDEX(new IndexCommand()),
    LOG_IN(new LogInCommand());

    private Command command;

    /**
     * command constructor
     */
    private CommandList(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
