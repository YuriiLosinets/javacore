package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution
{
    public static final class Constants
    {
        public static final String const1 = "Server is not accessible for now.";
        public static final String const2 = "User is not authorized.";
        public static final String const3 = "User is banned.";
        public static final String const4 = "Access is denied.";

    }
    public class ServerNotAccessibleException extends Exception
    {
        public ServerNotAccessibleException()
        {
            super(Constants.const1);
        }

        public ServerNotAccessibleException(Throwable cause)
        {
            super(Constants.const1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception
    {
        public UnauthorizedUserException()
        {
            super(Constants.const2);
        }

        public UnauthorizedUserException(Throwable cause)
        {
            super(Constants.const2, cause);
        }
    }

    public class BannedUserException extends Exception
    {
        public BannedUserException()
        {
            super(Constants.const3);
        }

        public BannedUserException(Throwable cause)
        {
            super(Constants.const3, cause);
        }
    }

    public class RestrictionException extends Exception
    {
        public RestrictionException()
        {
            super(Constants.const4);
        }

        public RestrictionException(Throwable cause)
        {
            super(Constants.const4, cause);
        }
    }
}
