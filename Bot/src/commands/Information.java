package commands;

import main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Information extends ListenerAdapter {

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");

		// Commands info
		if (args[0].equalsIgnoreCase(Main.prefix + "cmds")) {
			EmbedBuilder b = new EmbedBuilder();
			b.setTitle("Starter Bot Commands");
			b.setDescription("!hi = Command for bot to say hi\n" + "!owner = tells you about the owner\n"
					+ "!clear = clears messages\n" + "!admin = Info about Admin\n" + "!mod = Info about mod\n"
					+ "!member = Info about member\n" + "!mute = mutes a user\n" + "!unmute = unmutes a user\n"
					+ "!kick = kicks a user\n" + "!rules = shows rules\n" + "!giveMember = gives user member role\n"
					+ "!takeMember = takes member role from user\n");
			b.setColor(0xf45642);
			b.setFooter("Creater by Profound", event.getMember().getUser().getAvatarUrl());

			event.getChannel().sendMessage(b.build()).queue();
		}
		// Hello command
		if (args[0].equalsIgnoreCase(Main.prefix + "hi")) {
			event.getChannel().sendMessage("Hello! Welcome to Absolute Infinity").queue();
		}

		// Administrator info
		if (args[0].equalsIgnoreCase(Main.prefix + "admin")) {
			event.getChannel().sendMessage(
					"Administrators are the highest ranked and the leaders of the domain that make sure everything is in check")
					.queue();
		}

		// Moderator info
		if (args[0].equalsIgnoreCase(Main.prefix + "mod")) {
			event.getChannel().sendMessage(
					"Moderators do the work that Administrators choose not to, but don't forget they have great power as well")
					.queue();
		}

		// Member info
		if (args[0].equalsIgnoreCase(Main.prefix + "member")) {
			event.getChannel().sendMessage("Members are the lowest of the low but are the building blocks of AI")
					.queue();
		}

		// Owner info
		if (args[0].equalsIgnoreCase(Main.prefix + "owner")) {
			event.getChannel().sendMessage("The owner/founder of this server is the infamous Profound").queue();
		}
	}
}
