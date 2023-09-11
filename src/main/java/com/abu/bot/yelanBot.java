package com.abu.bot;

import com.abu.bot.commands.CommandManager;
import com.abu.bot.events.ChannelCreateandDelete;
import com.abu.bot.events.Greetings;
import com.abu.bot.events.GuildJoinandLeave;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;



public class yelanBot {


    JDA botManager ;
    public yelanBot() {
        String token = getenvToken();
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.enableIntents(GatewayIntent.GUILD_MEMBERS,GatewayIntent.GUILD_MESSAGES,GatewayIntent.GUILD_PRESENCES);
        builder.addEventListeners(new ChannelCreateandDelete(),new CommandManager(),new GuildJoinandLeave(),new Greetings());

        botManager = builder.build();


    }

    private static String getenvToken() {
        Dotenv config = Dotenv.configure().load();

        return config.get("TOKEN");
    }

}
