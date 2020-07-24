package commands;

import main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Information extends ListenerAdapter {

	public void onGuildMessageReceivedEvent(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		// Commands info
		if (args[0].equalsIgnoreCase(Main.prefix + "cmds1")) {
			EmbedBuilder b = new EmbedBuilder();
			b.setTitle("Starter Bot Commands");
			b.setDescription("!hi = Command for bot to say hi\n" + "!owner = tells you about the owner\n"
					+ "!clear = clears messages\n" + "!admin = Info about Admin\n" + "!mod = Info about mod\n"
					+ "!member = Info about member\n" + "!mute = mutes a user\n" + "!unmute = unmutes a user\n"
					+ "!kick = kicks a user\n" + "!rules = shows rules\n" + "!giveMember = gives user member role\n"
					+ "!takeMember = takes member role from user\n");
			b.setColor(0xf45642);
			b.setFooter("Creater by ", event.getMember().getUser().getAvatarUrl());

			event.getChannel().sendMessage(b.build()).queue();
		}
		// Hello command
		if (args[0].equalsIgnoreCase(Main.prefix + "hi")) {
			event.getChannel().sendMessage("Hello! Welcome to Absolute Infinity").queue();
		}

		// Administrator info
		if (args[0].equalsIgnoreCase(Main.prefix + "admin")) {
			event.getChannel().sendMessage("Admins are amazing").queue();
		}

		// Moderator info
		if (args[0].equalsIgnoreCase(Main.prefix + "mod")) {
			event.getChannel().sendMessage("Mods are good").queue();
		}
	}
}
