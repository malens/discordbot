package com.discord.bot;

import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by malens on 2017-04-10.
 */
public interface DirectCommand {

    public void action (MessageChannel channel, String message);

}