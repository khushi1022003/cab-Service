package com.epam.taxi.command.common;

import com.epam.taxi.Path;
import com.epam.taxi.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

/**
 * Command allows to change language.
 *
 * 
 */
public class ChangeLanguageCommand extends Command {
    private static final long serialVersionUID = 8421403039606311780L;
    private static final Logger LOGGER = Logger.getLogger(ChangeLanguageCommand.class);

    @Override
    public Path execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.info("Command starts");

        HttpSession session = request.getSession();
        String localeValue = request.getParameter("locale");
        Locale locale;



switch (localeValue) {
    case "uk":
        locale = new Locale("uk", "UA");
        LOGGER.info("Changed locale to " + localeValue);
        break;
    case "us":
        locale = new Locale("en", "US");
        LOGGER.info("Changed locale to en");
        break;
    
    case "hi":
        locale = new Locale("hi", "IN");
        LOGGER.info("Changed locale to " + localeValue);
        break;
    case "ta": // Add Tamil (India)
        locale = new Locale("ta", "IN");
        LOGGER.info("Changed locale to " + localeValue);
        break;
    case "es":
        locale = new Locale("es", "ES");
        LOGGER.info("Changed locale to " + localeValue);
        break;
    default:
        locale = new Locale("en", "US"); // Default to English (United States)
        LOGGER.info("Changed locale to " + locale.toLanguageTag());
        break;
}



        session.setAttribute("locale", localeValue);
        Config.set(session, Config.FMT_LOCALE, locale);

        LOGGER.info("Command finished");
        return new Path(Path.MAIN, true);
    }
}
