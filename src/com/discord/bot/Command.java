package com.discord.bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by malens on 2017-02-22.
 */
public interface Command {

    public boolean called (String[] args, MessageReceivedEvent event);
    public void action (String[] args, MessageReceivedEvent event);
    public String help ();
    public void executed (boolean success, MessageReceivedEvent event);

}
