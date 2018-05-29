package menu.service;

import character.Person;

/**
 * Service to display text information on console.
 */
public interface DisplayService {

	static void printMainLogo() {
		System.out.println("          .                                                      .");
		System.out.println("        .n                   .                 .                  n.");
		System.out.println("  .   .dP                  dP                   9b                 9b.    .");
		System.out.println(" 4    qXb         .       dX                     Xb       .        dXp     t");
		System.out.println("dX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb");
		System.out.println("9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP");
		System.out.println(" 9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP");
		System.out.println("  `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'");
		System.out.println("    `9XXXXXXXXXXXP' `9XX'   DIE    `98v8P'  HUMAN   `XXP' `9XXXXXXXXXXXP'");
		System.out.println("        ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~");
		System.out.println("                        )b.  .dbo.dP'`v'`9b.odb.  .dX(");
		System.out.println("                      ,dXXXXXXXXXXXb     dXXXXXXXXXXXb.");
		System.out.println("                     dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb");
		System.out.println("                    dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb");
		System.out.println("                    9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP");
		System.out.println("                     `'      9XXXXXX(   )XXXXXXP      `'");
		System.out.println("                              XXXX X.`v'.X XXXX");
		System.out.println("                              XP^X'`b   d'`X^XX");
		System.out.println("                              X. 9  `   '  P )X");
		System.out.println("                              `b  `       '  d'");
		System.out.println("                               `             '");
	}

	static void printDeathLogo() {
		System.out.println("    .o oOOOOOOOo                                            OOOo");
		System.out.println("    Ob.OOOOOOOo  OOOo.      oOOo.                      .adOOOOOOO");
		System.out.println("    OboO\"\"\"\"\"\"\"\"\"\"\"\".OOo. .oOOOOOo.    OOOo" +
				".oOOOOOo..\"\"\"\"\"\"\"\"\"'OO");
		System.out.println("    OOP.oOOOOOOOOOOO \"POOOOOOOOOOOo.   `\"OOOOOOOOOP,OOOOOOOOOOOB'");
		System.out.println("    `O'OOOO'     `OOOOo\"OOOOOOOOOOO` .adOOOOOOOOO\"oOOO'    `OOOOo");
		System.out.println("    .OOOO'            `OOOOOOOOOOOOOOOOOOOOOOOOOO'            `OO");
		System.out.println("    OOOOO                 '\"OOOOOOOOOOOOOOOO\"`                oOO");
		System.out.println("   oOOOOOba.                .adOOOOOOOOOOba               .adOOOOo.");
		System.out.println("  oOOOOOOOOOOOOOba.    .adOOOOOOOOOO@^OOOOOOOba.     .adOOOOOOOOOOOO");
		System.out.println(" OOOOOOOOOOOOOOOOO.OOOOOOOOOOOOOO\"`  '\"OOOOOOOOOOOOO.OOOOOOOOOOOOOO");
		System.out.println(" \"OOOO\"       \"YOoOOOOMOIONODOO\"`  .   '\"OOROAOPOEOOOoOY\"     \"OOO\"");
		System.out.println("    Y           'OOOOOOOOOOOOOO: .oOOo. :OOOOOOOOOOO?'         :`");
		System.out.println("    :            .oO%OOOOOOOOOOo.OOOOOO.oOOOOOOOOOOOO?         .");
		System.out.println("    .            oOOP\"%OOOOOOOOoOOOOOOO?oOOOOO?OOOO\"OOo");
		System.out.println("                 '%o  OOOO\"%OOOO%\"%OOOOO\"OOOOOO\"OOO':");
		System.out.println("                      `$\"  `OOOO' `O\"Y ' `OOOO'  o             .");
		System.out.println("    .                  .     OP\"          : o     .");
		System.out.println("                              :");
		System.out.println("                              .");
	}

	static void printTreasure() {
		System.out.println("                            _.--.");
		System.out.println("                        _.-'_:-'||");
		System.out.println("                    _.-'_.-::::'||");
		System.out.println("               _.-:'_.-::::::'  ||");
		System.out.println("             .'`-.-:::::::'     ||");
		System.out.println("            /.'`;|:::::::'      ||_");
		System.out.println("           ||   ||::::::'     _.;._'-._");
		System.out.println("           ||   ||:::::'  _.-!oo @.!-._'-.");
		System.out.println("           \\`.  ||:::::.-!()oo @!()@.-'_.|");
		System.out.println("            '.'-;|:.-'.&$@.& ()$%-'o.'\\U||");
		System.out.println("              `>'-.!@%()@'@_%-'_.-o _.|'||");
		System.out.println("               ||-._'-.@.-'_.-' _.-o  |'||");
		System.out.println("               ||=[ '-._.-\\U/.-'    o |'||");
		System.out.println("               || '-.]=|| |'|      o  |'||");
		System.out.println("               ||      || |'|        _| ';");
		System.out.println("               ||      || |'|    _.-'_.-'");
		System.out.println("               |'-._   || |'|_.-'_.-'");
		System.out.println("                '-._'-.|| |' `_.-'");
		System.out.println("                    '-.||_/.-'");
	}

	static void printEndLevelLogo() {
		System.out.println("                 ¶¶¶¶¶¶¶¶¶¶¶¶ ");
		System.out.println("                 ¶¶            ¶¶ ");
		System.out.println("   ¶¶¶¶¶        ¶¶                ¶¶ ");
		System.out.println("   ¶     ¶     ¶¶      ¶¶    ¶¶     ¶¶ ");
		System.out.println("    ¶     ¶    ¶¶       ¶¶    ¶¶      ¶¶ ");
		System.out.println("     ¶    ¶   ¶¶        ¶¶    ¶¶      ¶¶ ");
		System.out.println("      ¶   ¶   ¶                         ¶¶ ");
		System.out.println("    ¶¶¶¶¶¶¶¶¶¶¶¶                         ¶¶ ");
		System.out.println("   ¶            ¶    ¶¶            ¶¶    ¶¶ ");
		System.out.println("  ¶¶            ¶    ¶¶            ¶¶    ¶¶ ");
		System.out.println(" ¶¶   ¶¶¶¶¶¶¶¶¶¶¶      ¶¶        ¶¶     ¶¶ ");
		System.out.println(" ¶               ¶       ¶¶¶¶¶¶¶       ¶¶ ");
		System.out.println(" ¶¶              ¶                    ¶¶ ");
		System.out.println("  ¶   ¶¶¶¶¶¶¶¶¶¶¶¶                   ¶¶ ");
		System.out.println("  ¶¶           ¶  ¶¶                ¶¶ ");
		System.out.println("  ¶¶¶¶¶¶¶¶¶¶¶¶    ¶¶            ¶¶");
		System.out.println("                  ¶¶¶¶¶¶¶¶¶¶¶");
	}

	/**
	 * Draw stats table of the character and creature. Displays logs of the fight.
	 *
	 * @param person   the character
	 * @param creature the enemy
	 */
	void drawFightStatsAndLogs(Person person, Person creature);

	/**
	 * Adds fight log.
	 *
	 * @param log to add
	 */
	void addFightLog(String log);

	/**
	 * Draws stats of the person.
	 *
	 * @param person with stats
	 */
	void drawStats(Person person);

	/**
	 * Draws map legend.
	 */
	void drawMapLegend();
}
