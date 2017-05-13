package com.discord.bot.DirectCommands;

import com.discord.bot.DirectCommand;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.Event;
import com.discord.bot.Command;
import com.discord.bot.Utils.Constants;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Created by malens on 2017-04-10.
 */
public class GotOnline implements DirectCommand {
    @Override
    public void action(MessageChannel channel, String message) {
        channel.sendMessage(message).complete();
    }
}
