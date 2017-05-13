package com.discord.bot.Commands;

import at.mukprojects.giphy4j.Giphy;
import at.mukprojects.giphy4j.entity.search.SearchFeed;
import at.mukprojects.giphy4j.exception.GiphyException;
import com.discord.bot.Command;
import com.discord.bot.Utils.Constants;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

/**
 * Created by malens on 2017-02-22.
 */
public class GiphyCommand implements Command {

    private Giphy mainGiphy = new Giphy(Constants.GiphyApi);

    private final String HELP = "USAGE: !giphy <what to search for>";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return args.length>0;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String search = "";
        Random rnd = new Random();
        int num = Math.max(25/args.length, 1);
        for (String s : args){
            search = search + s + " ";
        }
        System.out.println(search);
        try {
            SearchFeed feed = mainGiphy.search(search, num, 0);
            event.getChannel().sendMessage(feed.getDataList().get(rnd.nextInt(num)).getImages().getFixedHeightDownsampled().getUrl()).complete();
        } catch (GiphyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

        if (!success){
            event.getChannel().sendMessage(help()).complete();
        }

    }
}
