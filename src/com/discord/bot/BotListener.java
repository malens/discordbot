package com.discord.bot;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.user.UserOnlineStatusUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Created by malens on 2017-02-22.
 */
public class BotListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getMessage().getContent().startsWith("!")&& !event.getAuthor().isBot()){
            Main.handleCommand(Main.parser.parse(event.getMessage().getContent(), event));
        }
    }


    @Override
    public void onReady (ReadyEvent event)
    {
       // Main.log("status", "Logged in as: "+event.getJDA().getSelfUser().getName());
    }

    @Override
    public void onUserOnlineStatusUpdate(UserOnlineStatusUpdateEvent event) {
        if(!event.getUser().isBot()&& event.getPreviousOnlineStatus().compareTo(OnlineStatus.OFFLINE)==0){
            event.getGuild().getPublicChannel().sendMessage("Hello " + event.getUser().getAsMention().toString()).complete();
        }
    }
}
