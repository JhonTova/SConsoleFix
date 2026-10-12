package me.sirius.sconsolefix;

import me.sirius.core.SiriusPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Filter;

public class SConsoleFix extends SiriusPlugin {
    
    private ConsoleFilter filter;

    @Override
    protected void onStart() {
        try {
            Logger rootLogger = (Logger) LogManager.getRootLogger();
            filter = new ConsoleFilter();
            filter.start();
            rootLogger.addFilter(filter);
            getLogger().info("SConsoleFix habilitado - Filtros aplicados correctamente");
        } catch (Exception e) {
            getLogger().severe("Error al habilitar SConsoleFix: " + e.getMessage());
        }
    }

    @Override
    protected void onStop() {
        try {
            if (filter != null) {
                // Parar el filtro no lo saca del logger raiz: sin quitarlo, cada
                // /reload apilaba otro y el viejo retenia el classloader del plugin.
                ((Logger) LogManager.getRootLogger()).get().removeFilter(filter);
                filter.stop();
                filter = null;
            }
            getLogger().info("SConsoleFix deshabilitado correctamente");
        } catch (Exception e) {
            getLogger().severe("Error al deshabilitar SConsoleFix: " + e.getMessage());
        }
    }

    private static class ConsoleFilter extends AbstractFilter {
        
        public ConsoleFilter() {
            super(Filter.Result.NEUTRAL, Filter.Result.DENY);
        }

        @Override
        public Filter.Result filter(LogEvent event) {
            if (event == null || event.getMessage() == null) {
                return Filter.Result.NEUTRAL;
            }

            String message = event.getMessage().getFormattedMessage();
            String loggerName = event.getLoggerName();
            
            if (shouldBlock(message, loggerName)) {
                return Filter.Result.DENY;
            }

            return Filter.Result.NEUTRAL;
        }

        private boolean shouldBlock(String message, String loggerName) {
            if (message == null) {
                return false;
            }

            if (message.contains("Couldn't look up profile properties")) {
                return true;
            }

            if (message.contains("Status: 429") || message.contains("Status code: 429")) {
                return true;
            }

            if (message.contains("MinecraftClientHttpException")) {
                return true;
            }

            if (message.contains("Got an error with a html body connecting to")) {
                return true;
            }

            if (message.contains("sessionserver.mojang.com")) {
                return true;
            }

            if (message.contains("The request is blocked")) {
                return true;
            }

            if (message.contains("Service unavailable")) {
                return true;
            }

            if (message.contains("<!DOCTYPE html")) {
                return true;
            }

            if (message.contains("<html xmlns=")) {
                return true;
            }

            if (message.contains("<title>Service unavailable</title>")) {
                return true;
            }

            if (message.contains("com.mojang.authlib.minecraft.client.MinecraftClient.readInputStream")) {
                return true;
            }

            if (message.contains("com.mojang.authlib.minecraft.client.MinecraftClient.get")) {
                return true;
            }

            if (message.contains("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService")) {
                return true;
            }

            if (message.contains("com.destroystokyo.paper.profile.PaperMinecraftSessionService")) {
                return true;
            }

            if (message.contains("com.destroystokyo.paper.profile.CraftPlayerProfile")) {
                return true;
            }

            if (message.contains("java.base/java.util.concurrent.CompletableFuture")) {
                return true;
            }

            if (message.contains("java.base/java.util.concurrent.ThreadPoolExecutor")) {
                return true;
            }

            if (message.contains("java.base/java.lang.Thread.run")) {
                return true;
            }

            if (message.contains("authlib") && message.contains(".jar")) {
                return true;
            }

            if (loggerName != null && loggerName.contains("MinecraftSessionService")) {
                return true;
            }

            return false;
        }
    }
}