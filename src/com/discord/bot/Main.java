package com.discord.bot;

import com.discord.bot.Commands.GiphyCommand;
import com.discord.bot.Commands.PingCommand;
import com.discord.bot.DirectCommands.GotOnline;
import com.discord.bot.TwitchBot.MyTwitchBot;
import com.discord.bot.Utils.CommandParser;
import com.discord.bot.Utils.Constants;
import com.mb3364.twitch.api.Twitch;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.HashMap;

public class Main {

    private static JDA jda;
    public static final CommandParser parser = new CommandParser();

    private static HashMap<String, Command> commands = new HashMap<String, Command>();
    private static HashMap<String, DirectCommand> directCommands = new HashMap<>();

    public static void main(String[] args) {
        try {
            jda = new JDABuilder(AccountType.BOT).addListener(new BotListener()).setToken(Constants.token).buildBlocking();
            jda.setAutoReconnect(true);
        } catch (Exception e){
            e.printStackTrace();
        }
        commands.put("ping", new PingCommand());
        commands.put("giphy", new GiphyCommand());
        directCommands.put("wasonline", new GotOnline());
        MyTwitchBot twitchBot = new MyTwitchBot(jda);
        twitchBot.run();

    }

    public static void handleCommand (CommandParser.CommandContainer cmd){
        if (commands.containsKey(cmd.invoke)){
            boolean safe = commands.get(cmd.invoke).called(cmd.args, cmd.event);
            if (safe){
                commands.get(cmd.invoke).action(cmd.args, cmd.event);
                commands.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }

        }
    }

    public static void directCommand (String invoke, MessageChannel channel, String message){
        if (directCommands.containsKey(invoke)){
                directCommands.get(invoke).action(channel, message);
        }
    }

}
