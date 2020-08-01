package commands;

import java.util.List;

import main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		// Administrator role
		boolean admin = event.getMember().getRoles().stream().map(Role::getName)
				.anyMatch(role -> role.equals("Administrator"));
		// Moderator role
		boolean mod = event.getMember().getRoles().stream().map(Role::getName)
				.anyMatch(role -> role.equals("Moderator"));

		// Clear command for Administrators
		if (args[0].equalsIgnoreCase(Main.prefix + "clear") && admin == true) {
			// If no amount is specified
			if (args.length == 1) {
				// Usage
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete");
				usage.setDescription("Usage: `" + Main.prefix + "clear [# of messages]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			// If clear amount is given
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1)
							.complete();
					event.getChannel().deleteMessages(messages).queue();

					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("✅ Successfully deleted " + args[1] + " messages.");
					event.getChannel().sendMessage(success.build()).queue();
				} catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						// Too many messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Too many messages selected");
						error.setDescription("Between 1-100 messages can be deleted at one time.");
						event.getChannel().sendMessage(error.build()).queue();
					} else {
						// Messages too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Selected messages are older than 2 weeks");
						error.setDescription("Messages older than 2 weeks cannot be deleted.");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		} else if (args[0].equalsIgnoreCase(Main.prefix + "clear") && admin == false && mod == false) {
			event.getChannel().sendMessage("You do not have the role for this command").queue();
		}

		// Clear command for Moderators
		if (args[0].equalsIgnoreCase(Main.prefix + "clear") && mod == true) {
			// If no amount is specified
			if (args.length == 1) {
				// Usage
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("Specify amount to delete");
				usage.setDescription("Usage: `" + Main.prefix + "clear [# of messages]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			// If clear amount is given
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1]) + 1)
							.complete();
					event.getChannel().deleteMessages(messages).queue();

					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("✅ Successfully deleted " + args[1] + " messages.");
					event.getChannel().sendMessage(success.build()).queue();
				} catch (IllegalArgumentException e) {
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
						// Too many messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Too many messages selected");
						error.setDescription("Between 1-99 messages can be deleted at one time.");
						event.getChannel().sendMessage(error.build()).queue();
					} else {
						// Messages too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("🔴 Selected messages are older than 2 weeks");
						error.setDescription("Messages older than 2 weeks cannot be deleted.");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		} else if (args[0].equalsIgnoreCase(Main.prefix + "clear") && admin == false && mod == false) {
			event.getChannel().sendMessage("You do not have the role for this command").queue();
		}

	}
}