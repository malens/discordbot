package com.discord.bot.Utils;

import com.google.api.services.youtube.YouTube;

/**
 * Created by malens on 2017-03-24.
 */
public class YoutubeUtils {

    private static YouTube youtube;

    public static void addToPlaylistById (String vidId)
    {

    }

    public static String getVidIdFromURL (String url)
    {
        return url.split("'?v='")[1];
    }



}
