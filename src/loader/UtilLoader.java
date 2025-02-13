package loader;

import view.Command;

public class UtilLoader {
    public static boolean isExit(final String input) {
        if (input.length() > 2) {
            return input.substring(0, 3).equals(Command.EXIT.getNumber());
        } else {
            return false;
        }
    }

    public static boolean isAbort(final String input) {
        return input.substring(0, 1).equals(Command.ABORT.getNumber());
    }
}