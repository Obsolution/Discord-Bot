package main;

import javax.security.auth.login.LoginException;

import commands.Information;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main{
	
	public static String prefix = "@";
	public static JDA jda;

	public static void main(String[] args) throws LoginException{
		jda = new JDABuilder(AccountType.BOT).setToken("NzM0ODkyNzM0MjkyNDI2ODIz.XxYX1Q.hWjhmlhDNV4dRJ0NmNg6p_DdNME").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.watching("starter shit"));
		
		// Calls commands
		jda.addEventListener(new Information());
	}

}
