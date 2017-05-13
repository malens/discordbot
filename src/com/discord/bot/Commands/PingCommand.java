package com.discord.bot.Commands;

import com.discord.bot.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by malens on 2017-02-22.
 */
public class PingCommand implements Command {

    private final String HELP = "USAGE: !ping";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getMessage().getChannel().sendMessage("PONG").complete();
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        return;
    }
}
