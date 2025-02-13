package loader;

import view.Command;

public class UtilLoader {
    public static boolean isExit(final String input) {
        return input.substring(0, 1).equals(Command.EXIT.getNumber());
    }

    public static boolean isAbort(final String input) {
        if (input.length() > 2) {
            return input.substring(0, 3).equals(Command.ABORT.getNumber());
        } else {
            return false;
        }
    }
}