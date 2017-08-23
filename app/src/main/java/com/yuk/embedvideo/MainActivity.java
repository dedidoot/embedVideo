package com.yuk.embedvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView web_view, web_view2, web_view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web_view = (WebView) findViewById(R.id.web_view);
        web_view2 = (WebView) findViewById(R.id.web_view2);
        web_view3 = (WebView) findViewById(R.id.web_view3);

        WebSettings webSettings = web_view.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadsImagesAutomatically(true);
        web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view.loadDataWithBaseURL("https://www.youtube.com", getVideoHTML("uNkHnY1IvlA"), "text/html", "utf-8", null);


        //https://soundcloud.com/traphousemusic1/despacito-luis-fonsi-daddy-yankee
        WebSettings webSettings2 = web_view2.getSettings();
        webSettings2.setJavaScriptEnabled(true);
        webSettings2.setLoadsImagesAutomatically(true);
        web_view2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view2.loadDataWithBaseURL("https://www.soundcloud.com", getFrameSoundCloud("https://soundcloud.com/traphousemusic1/despacito-luis-fonsi-daddy-yankee"), "text/html", "utf-8", null);


        WebSettings webSettings3 = web_view3.getSettings();
        webSettings3.setJavaScriptEnabled(true);
        webSettings3.setLoadsImagesAutomatically(true);
        web_view3.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        web_view3.loadDataWithBaseURL("https://player.vimeo.com", getFrameVideoVimao("230559377"), "text/html", "utf-8", null);
    }

    /**
     * get Embed Frame SoundCloud based of url
     * used on : arenaSession, StickyPost, and ImageDisplay
     *
     * @param url -> url form api
     * @return String iframe
     */
    public static String getFrameSoundCloud(String url) {
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <script src=\"https://www.youtube.com/iframe_api\"></script>\n" +
                "    <style type=\"text/css\">\n" +
                "        html, body {\n" +
                "            margin: 0px;\n" +
                "            padding: 0px;\n" +
                "            border: 0px;\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "    </style>" +
                "  </head>\n" +
                "  <body>\n" +
                "<iframe width=\"100%\" height=\"100%\" scrolling=\"no\" frameborder=\"no\"" +
                " src=\"https://w.soundcloud.com/player/?url=" + url + "&auto_play=false&" +
                "hide_related=false&show_comments=false&show_user=false&show_reposts=false" +
                "&visual=false&liking=false&sharing=false&show_artwork=false\"></iframe>" +
                "</body>\n" +
                "</html>";

        /*
        https://w.soundcloud.com/player/?url=https://soundcloud.com/traphousemusic1/despacito-luis-fonsi-daddy-yankee&auto_play=false&hide_related=false&show_comments=false&show_user=false&show_reposts=false&visual=false&liking=false&sharing=false&show_artwork=false
        * */
    }

    /**
     * parameter : https://developers.google.com/youtube/youtube_player_demo
     */
    public static String getVideoHTML(String vId) {
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <script src=\"https://www.youtube.com/iframe_api\"></script>\n" +
                "    <style type=\"text/css\">\n" +
                "        html, body {\n" +
                "            margin: 0px;\n" +
                "            padding: 0px;\n" +
                "            border: 0px;\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "    </style>" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <iframe style=\"display: block;\" id=\"player\" frameborder=\"0\"  width=\"100%\" height=\"100%\" " +
                "       src=\"https://www.youtube.com/embed/" + vId +
                "?enablejsapi=1&autoplay=0&iv_load_policy=1&fs=0&rel=0&modestbranding=0&controls=1&showinfo=0\" allowfullscreen>" +
                "    </iframe>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      var tag = document.createElement('script');\n" +
                "      tag.src = \"https://www.youtube.com/iframe_api\";\n" +
                "      var firstScriptTag = document.getElementsByTagName('script')[0];\n" +
                "      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n" +
                "      var player;\n" +
                "      function onYouTubeIframeAPIReady() {\n" +
                "          player = new YT.Player('player', {\n" +
                "              events: {\n" +
                "                  'onReady': onPlayerReady\n" +
                "              }\n" +
                "          });\n" +
                "      }\n" +
                "      function onPlayerReady(event) {\n" +
                "          player.setPlaybackQuality(\" auto\");\n" +
                "      }\n" +
                "    </script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }


    public static String getFrameVideoVimao(String vId) {
        return "<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <script src=\"https://www.youtube.com/iframe_api\"></script>\n" +
                "    <style type=\"text/css\">\n" +
                "        html, body {\n" +
                "            margin: 0px;\n" +
                "            padding: 0px;\n" +
                "            border: 0px;\n" +
                "            width: 100%;\n" +
                "            height: 100%;\n" +
                "        }\n" +
                "    </style>" +
                "  </head>\n" +
                "\n" +
                "  <body>\n" +
                "    <iframe style=\"display: block;\" id=\"player\" frameborder=\"0\"  width=\"100%\" height=\"100%\" " +
                "       src=\"https://player.vimeo.com/video/" + vId +
                "?enablejsapi=1&autoplay=0&iv_load_policy=1&fs=0&rel=0&modestbranding=0&controls=1&showinfo=0\" allowfullscreen>" +
                "    </iframe>\n" +
                "    <script type=\"text/javascript\">\n" +
                "      var tag = document.createElement('script');\n" +
                "      tag.src = \"https://www.youtube.com/iframe_api\";\n" +
                "      var firstScriptTag = document.getElementsByTagName('script')[0];\n" +
                "      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);\n" +
                "      var player;\n" +
                "      function onYouTubeIframeAPIReady() {\n" +
                "          player = new YT.Player('player', {\n" +
                "              events: {\n" +
                "                  'onReady': onPlayerReady\n" +
                "              }\n" +
                "          });\n" +
                "      }\n" +
                "      function onPlayerReady(event) {\n" +
                "          player.setPlaybackQuality(\" auto\");\n" +
                "      }\n" +
                "    </script>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }

}
