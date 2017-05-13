package com.discord.bot.TwitchBot;

import com.discord.bot.Main;
import com.discord.bot.Utils.CommandParser;
import com.mb3364.twitch.api.Twitch;
import com.mb3364.twitch.api.handlers.ChannelResponseHandler;
import com.mb3364.twitch.api.handlers.StreamResponseHandler;
import com.mb3364.twitch.api.models.Channel;
import com.mb3364.twitch.api.models.Stream;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.MessageChannel;

import static javax.lang.model.type.TypeKind.NULL;

/**
 * Created by malens on 2017-04-10.
 */
public class MyTwitchBot implements Runnable{
    private Thread botThread;
    private String threadName;
    private Twitch twitch;
    private Boolean wasOnline = false;
    private MessageChannel ann;
    public MyTwitchBot(JDA jda)
    {
        threadName = "TwitchThread";
        twitch = new Twitch();
        twitch.setClientId("6tjlohax254wlj9mw08afzduxpsc1y");
        ann = jda.getTextChannelsByName("announcements", false).get(0);

    }


    public void run(){
        while(true) {
            System.out.println(wasOnline);
            try {
                twitch.streams().get("luality", new StreamResponseHandler() {

                    @Override
                    public void onSuccess(Stream stream) {

                        if (stream!=null) {
                            if (stream.isOnline() && !wasOnline) {

                                wasOnline = true;
                                Main.directCommand("wasonline", ann, "Luality has started streaming! \nCome watch now at https://www.twitch.tv/luality");

                            }
                        } else wasOnline = false;
                    }

                    @Override
                    public void onFailure(int i, String s, String s1) {
                        System.out.println("failed");

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println("failed");
                    }
                });
                    Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}
