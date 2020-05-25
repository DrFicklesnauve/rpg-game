
public class friarRexStats {
	private static int friarRexHp, friarRexLevel, friarRexExp, friarRexAttack,
	friarRexDefense, friarRexNextLevel, friarRexMaxHp, friarRexHeal;
	
	private static Boolean ifFriarRex;

	public friarRexStats() {
		friarRexHp = 150;
		friarRexLevel = 1;
		friarRexExp = 0;
		friarRexAttack = 10;
		friarRexDefense = 20;
		friarRexNextLevel = 100; 
		friarRexMaxHp = 150;
		friarRexHeal = 20;
		ifFriarRex = false;
	}
	
	public void setfriarRexHp(int hp) {
		friarRexHp = hp;
	}
	
	public int getfriarRexHp() {
		return friarRexHp;
	}
	
	public void setfriarRexLevel(int level) {
		friarRexLevel = level;
	}
	
	public int getfriarRexLevel() {
		return friarRexLevel;
	}
	
	public void setfriarRexExp(int exp) {
		friarRexExp = exp;
	}
	
	public int getfriarRexExp() {
		return friarRexExp;
	}
	
	public void setfriarRexAttack(int attack) {
		friarRexAttack = attack;
	}
	
	public int getfriarRexAttack() {
		return friarRexAttack;
	}
	
	public void setfriarRexDefense(int defense) {
		friarRexDefense = defense;
	}
	
	public int getfriarRexDefense() {
		return friarRexDefense;
	}
	
	public void setfriarRexNextLevel(int nextLevel) {
		friarRexNextLevel = nextLevel;
	}
	
	public int getfriarRexNextLevel() {
		return friarRexNextLevel;
	}
	
	public void setfriarRexMaxHp(int maxHp) {
		friarRexMaxHp = maxHp;
	}
	
	public int getfriarRexMaxHp() {
		return friarRexMaxHp;
	}
	
	public void setfriarRexHeal(int heal) {
		friarRexHeal = heal;
	}
	
	public int getfriarRexHeal() {
		return friarRexHeal;
	}
	
	public void setIfFriarRex(Boolean ifFriar) {
		ifFriarRex = ifFriar;
	}
	
	public Boolean getIfFriarRex() {
		return ifFriarRex;
	}
}
