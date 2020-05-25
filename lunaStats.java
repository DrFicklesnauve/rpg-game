
public class lunaStats {
	private static int lunaHp, lunaLevel, lunaExp, lunaAttack,
		lunaDefense, lunaNextLevel, lunaMaxHp, lunaHeal;
	
	public lunaStats() {
		lunaHp = 200;
		lunaLevel = 1;
		lunaExp = 0;
		lunaAttack = 17;
		lunaDefense = 12;
		lunaNextLevel = 100; 
		lunaMaxHp = 200;
		lunaHeal = 15;
	}
	
	public void setLunaHp(int hp) {
		lunaHp = hp;
	}
	
	public int getLunaHp() {
		return lunaHp;
	}
	
	public void setLunaLevel(int level) {
		lunaLevel = level;
	}
	
	public int getLunaLevel() {
		return lunaLevel;
	}
	
	public void setLunaExp(int exp) {
		lunaExp = exp;
	}
	
	public int getLunaExp() {
		return lunaExp;
	}
	
	public void setLunaAttack(int attack) {
		lunaAttack = attack;
	}
	
	public int getLunaAttack() {
		return lunaAttack;
	}
	
	public void setLunaDefense(int defense) {
		lunaDefense = defense;
	}
	
	public int getLunaDefense() {
		return lunaDefense;
	}
	
	public void setLunaNextLevel(int nextLevel) {
		lunaNextLevel = nextLevel;
	}
	
	public int getLunaNextLevel() {
		return lunaNextLevel;
	}
	
	public void setLunaMaxHp(int maxHp) {
		lunaMaxHp = maxHp;
	}
	
	public int getLunaMaxHp() {
		return lunaMaxHp;
	}
	
	public void setLunaHeal(int heal) {
		lunaHeal = heal;
	}
	
	public int getLunaHeal() {
		return lunaHeal;
	}
}
