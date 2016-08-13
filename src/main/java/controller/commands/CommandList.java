package controller.commands;

/**
 * EPAM_Project_4_WEB_APP
 * Created 7/31/16, with IntelliJ IDEA
 *
 * @author Alex
 */
public enum CommandList {
    INDEX(new IndexCommand()),
    LOG_IN(new LogInCommand()),
    LOG_UP(new LogUpCommand()),
    EDIT_PROFILE(new EditProfileCommand()),
    SEND_MAIL(new SendMailCommand()),
    GET_SERVICES(new GetServicesCommand()),
    GET_ADRESSES(new GetAdressesCommand());

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
