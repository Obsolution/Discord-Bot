package commands;

import main.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Kick extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split(" ");
		// Administrator role
		boolean admin = event.getMember().getRoles().stream().map(Role::getName)
				.anyMatch(role -> role.equals("Administrator"));
		// Moderator role
		boolean mod = event.getMember().getRoles().stream().map(Role::getName)
				.anyMatch(role -> role.equals("Moderator"));

		// Kick command for Administrators
		if (args[0].equalsIgnoreCase(Main.prefix + "kick") && admin == true) {
			switch (args.length) {
			// If no user is given
			case 1:
				EmbedBuilder b = new EmbedBuilder();
				b.setTitle("Incorrect syntax");
				b.setDescription("Must be !kick @usermention");
				b.setColor(0xf45642);
				event.getChannel().sendMessage(b.build()).queue();
				break;
			case 2:

				break;
			}
		} else if (args[0].equalsIgnoreCase(Main.prefix + "kick") && admin == false && mod == false) {
			event.getChannel().sendMessage("You do not have the role for this command").queue();
		}

		// Kick command for Moderators
		if (args[0].equalsIgnoreCase(Main.prefix + "kick") && mod == true) {
			switch (args.length) {
			// If no user is given
			case 1:
				EmbedBuilder b = new EmbedBuilder();
				b.setTitle("Incorrect syntax");
				b.setDescription("Must be !kick @usermention");
				b.setColor(0xf45642);
				event.getChannel().sendMessage(b.build()).queue();
				break;
			case 2:
				
				break;
			}
		} else if (args[0].equalsIgnoreCase(Main.prefix + "kick") && admin == false && mod == false) {
			event.getChannel().sendMessage("You do not have the role for this command").queue();
		}
	}
}