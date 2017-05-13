package com.discord.bot.Commands;

import com.discord.bot.Command;
import com.google.api.services.youtube.YouTube;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by malens on 2017-02-23.
 */
public class YoutubeCommand implements Command {



    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
