package com.discord.bot.Utils;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;

/**
 * Created by malens on 2017-02-22.
 */
public class CommandParser {
    public CommandContainer parse (String input, MessageReceivedEvent event){
        ArrayList<String> split = new ArrayList<>();
        String raw = input;
        String tail = raw.replaceFirst("!", "");
        String[] splitTail = tail.split(" ");
        for (String s : splitTail){
            split.add(s);
        }
        String invoke = split.get(0);
        String[] args = new String[split.size()-1];
        split.subList(1, split.size()).toArray(args);

        return new CommandContainer(raw, tail, splitTail, invoke, args, event);
    }

    public class CommandContainer {
        public final String raw;
        public final String tail;
        public final String[] splitTail;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public CommandContainer(String raw, String tail, String[] splitTail, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = raw;
            this.tail = tail;
            this.splitTail = splitTail;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }
    }


}
