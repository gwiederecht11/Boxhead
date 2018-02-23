import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class BoxPanel extends JPanel implements ActionListener{
	
	private Timer gameTimer;
	Random rand = new Random();
	protected static Stewie stewie = new Stewie(500,500,10, 101);
	private List<Zombie> zombieList;
	private List<Demon> demonList;
	private List<Boss> bossList=new ArrayList<Boss>();
	private List<Weapon> playerBullets; 
	private List<Fireball> fireballs;
	private List<Fireball> fireballsB;
	private List<String> weapons;
	private List<Fakewall> fakewalls;
	private List<Grenade> grenades;
	private List<Claymore> claymores;
	private List<Healthpack> packs;
	private int control = 0;			//LEVELS STILL NOT WORKING...!!!!
	private int controlDemons = 0;	
	private int controlFireballs = 0;//TRY GETTING AMMO AND DISPLAYING IT!!!
	private int track;
	private int playerDamage= 1;
	private int zombieHealth = 3;
	private int demonHealth = 10;
	private int score;
	private int numEnemiesKilled=0; 
	private int weaponIndex= 0;
	private int ticks=0; 
	private int currentLevel= 1; //doesnt level up?
	private int numberDemonsAllowedInThisLevel= 1;
	private int numberRegularZombiesThatArentDemonsAllowedInThisLevel= 5; 
	private int numberDemonsKilledInThisLevel= 0;
	private int numberRegularZombiesThatArentDemonsKilledInThisLevel=0; 
	private int shotgunRate = 3;
	private int uziRate = 1;
	private int getsHarder = 0;
	private int demonSpawn = 450;
	private int zombieSpawn = 150;
	private int bossLevel = 4;
	private int bossHealth = 45;
	private int healthControl = 0;
	private int raygunRate = 4;

	public BoxPanel() {
		this.setPreferredSize(new Dimension(1300,1000));
		this.setBackground(new Color(245,245,220));
		playerBullets = new ArrayList<Weapon>();
		zombieList = new ArrayList<Zombie>();
//		opponentList= new ArrayList<Zombie>();
		demonList = new ArrayList<Demon>();
		fireballs = new ArrayList<Fireball>();
		weapons= new ArrayList<String>();
		fakewalls = new ArrayList<Fakewall>();
		grenades = new ArrayList<Grenade>();
		claymores = new ArrayList<Claymore>();
		fireballsB= new ArrayList<Fireball>();
		packs = new ArrayList<Healthpack>();
		weapons.add("Uzi");
		addBeginWalls();
		addKeyListener(new KeyAdapt(stewie));
		gameTimer = new Timer(10, this);
		setUpKeyBindings();
		gameTimer.start();

	}
	private void addBeginWalls() {//reeaaally laggy with walls...
		// TODO Auto-generated method stub
		for(int y = 70; y<660; y+=90){
			fakewalls.add(new Fakewall(0,y));
			fakewalls.add(new Fakewall(1240,y));

		}
		for(int x = 60; x<480; x+=70){
			fakewalls.add(new Fakewall(x,700));
			fakewalls.add(new Fakewall(x,0));
		}
		for(int x = 780; x<1260; x+=80){
			fakewalls.add(new Fakewall(x,700));
			fakewalls.add(new Fakewall(x,0));
		}
		fakewalls.add(new Fakewall(420,-60));
		fakewalls.add(new Fakewall(780,-60));
		fakewalls.add(new Fakewall(400,760));
		fakewalls.add(new Fakewall(780,760));

		//this is for making sure that zombies can get into the arena, but not sure
		//if we need, and it adds lag
		
	}
	private void setUpKeyBindings() {
		
		this.getInputMap().put(KeyStroke.getKeyStroke("SPACE"),"fire");
		this.getInputMap().put(KeyStroke.getKeyStroke("1"), "previous weapon");
		this.getInputMap().put(KeyStroke.getKeyStroke("2"), "next weapon");
		
		this.getActionMap().put("fire",
			new AbstractAction() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(weapons.get(weaponIndex).equals("Uzi")){//UZI IS SUPPOSED TO BE FAST...
						if(ticks>=uziRate){
							ticks=0;
							launchWeapon();
						}
					}
					if(weapons.get(weaponIndex).equals("Grenade")){//WHY MAKE IT SO SLOW?!?!
						if(ticks>=2){	//ITS MUCH FASTER IN THE REAL GAME
							ticks=0;
							launchWeapon();
						}
					
					}
					if(weapons.get(weaponIndex).equals("Shotgun")){
						if(ticks>=shotgunRate){
							ticks=0;
							launchWeapon();
						}
					}
					if(weapons.get(weaponIndex).equals("Claymore")){
						if(ticks>=3){
							ticks=0;
							launchWeapon();
						}
					}
					if(weapons.get(weaponIndex).equals("Ray gun")){
						if(ticks>=raygunRate){
							ticks=0;
							launchWeapon();
						}
					}

					ticks++;
				}
				private void launchWeapon() {
					String weaponType= weapons.get(weaponIndex);
//					System.out.println("Now Using "+ weaponType);
					if(weaponType.equals("Uzi"))
						playerBullets.add(new Bullet(stewie.getX(), stewie.getY(), stewie.getDir()));
					else if(weaponType.equals("Shotgun"))
						playerBullets.add(new Shotgun(stewie.getX()+40, stewie.getY()+20, stewie.getDir(), false));
//					else if(weaponType.equals("fakewall"))
//						playerBullets.add(new Fakewall(stewie.getX()+40, stewie.getY()+20));
//					else if(weaponType.equals("barrel")){
//						playerBullets.add(new Barrel(stewie.getX()+40, stewie.getY()+20));
//					}
					else if(weaponType.equals("Grenade"))
						grenades.add(new Grenade(stewie.getX() + 30, stewie.getY() + 20, stewie.getDir()));
					else if(weaponType.equals("Claymore"))
						claymores.add(new Claymore(stewie.getX() + 30, stewie.getY() + 20));
					else if(weaponType.equals("Ray gun"))
						playerBullets.add(new RayGun(stewie.getX(),stewie.getY(), stewie.getDir(),false));
											
				}
			});	
		this.getActionMap().put("previous weapon",
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						prevWeapon();
					}
					private void prevWeapon() {
						if(weaponIndex>0){
							weaponIndex--;
//							System.out.println("Decreased index");
						}
						
					}
				});	
		this.getActionMap().put("next weapon",
				new AbstractAction() {
					@Override
					public void actionPerformed(ActionEvent e) {
						nextWeapon(); 
					}
					private void nextWeapon() {
						if(weaponIndex<weapons.size()-1){
							weaponIndex++;
//							System.out.println("Added to index");
						}
						
					}
				});	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(checkGameOver())
			gameTimer.stop();
		control++;
		controlDemons++;
		controlFireballs++;
		checkUpgrades();
		checkLevels();
		healthControl++;
		replenishHealth();
		addZombies();
		addDemons();
		addHealthPacks();
		if(playerDamage==10){
			stewie.decreaseHealth(2);
			playerDamage = 0;
		}
		if(demonList.size()>0)
			addFireballs();
		if(bossList.size()>0)
			addFireballsAllDir();
		
		moveEverything();
		repaint();
	}
	private void replenishHealth() {
		// TODO Auto-generated method stub
		if(healthControl%200==0 && stewie.getHealth()+7<=101)
			stewie.increaseHealth(7);
	}
	int displayLevel=0; 
	private void checkLevels() {//doesnt level up?
		//numberDemonsAllowedInThisLevel= 1;
		//private int numberRegularZombiesThatArentDemonsAllowedInThisLevel= 5; 
		//private int numberDemonsKilledInThisLevel= 0;
		//private int numberRegularZombiesThatArentDemonsKilledInThisLevel
		
		displayLevel++;
		if(displayLevel%10==0)
//			System.out.println("Number demons killed = "+ (numberDemonsKilledInThisLevel) + 
//					" number allowed is" + numberDemonsAllowedInThisLevel+ 
//					". Number of zombies killed is "+ 
//					(numberRegularZombiesThatArentDemonsKilledInThisLevel) + 
//					"And number allowed is "+ numberRegularZombiesThatArentDemonsAllowedInThisLevel);
//			System.out.println("num demon spawned" + numberDemonsSpawned + "num Zom spawned" + numberZombiesSpawned);
		if(numberDemonsKilledInThisLevel== numberDemonsAllowedInThisLevel &&
				numberRegularZombiesThatArentDemonsKilledInThisLevel==numberRegularZombiesThatArentDemonsAllowedInThisLevel){
			currentLevel++;
//			System.out.println("Current level is "+ currentLevel);
			getsHarder++;
			bossLevel++;
			
			if(getsHarder==2){
				zombieHealth++;
				demonHealth++;
				zombieSpawn-=20;
				demonSpawn-=50;
				getsHarder=0;
			
			}
			if(bossLevel%5==0){
				addBoss();
			}
			numberZombiesSpawned=0; 
			numberDemonsSpawned =0; 
			numberDemonsKilledInThisLevel=0; 
			numberRegularZombiesThatArentDemonsKilledInThisLevel=0; 
			numberDemonsAllowedInThisLevel++;
			numberRegularZombiesThatArentDemonsAllowedInThisLevel+=5; 
			
		}
		
	
	}
	private void checkOffScreenBullets(Fakewall f) {
		for(int x=0; x<playerBullets.size(); x++){
			Weapon d= playerBullets.get(x);
			if(d.collision(f)){
				playerBullets.remove(d);
			}
		}
		
	}
	private void checkOffScreenFireballs(Fakewall f){
		for(int s = 0; s<fireballs.size();s++){
			Fireball fire = fireballs.get(s);
			if(fire.collision(f))
				fireballs.remove(fire);
		}
		for(int s = 0; s<fireballsB.size();s++){
			Fireball fire = fireballsB.get(s);
			if(fire.collision(f))
				fireballsB.remove(fire);
		}
	}
	int displayCounter= 0;
	
	private void checkUpgrades() {
//		if(numEnemiesKilled==0){
//			displayMessage("Shotgun");
//		}
		if(numEnemiesKilled==3){
			displayMessage("Shotgun");	
		}
		if(numEnemiesKilled>3 && numEnemiesKilled<8)
			displayCounter =0;
		if(numEnemiesKilled==8){
			displayMessage("Claymore");
		}
		if(numEnemiesKilled>8 && numEnemiesKilled<13)
			displayCounter =0;
		if(numEnemiesKilled==13){
			displayMessage("Grenade");
		}
		if(numEnemiesKilled>13 && numEnemiesKilled<18)
			displayCounter =0;
		if(numEnemiesKilled==18){
			changeRate("Uzi rapid fire ");
			uziRate = 0;
		}
		if(numEnemiesKilled>18 && numEnemiesKilled<23)
			displayCounter =0;
		if(numEnemiesKilled==23){
			changeRate("Shotgun rapid fire ");
			shotgunRate = 1;	
		}
		if(numEnemiesKilled>23 && numEnemiesKilled<28)
			displayCounter =0;
		if(numEnemiesKilled==28){
			displayMessage("Ray gun");
		}
		if(numEnemiesKilled>28 && numEnemiesKilled<32)
			displayCounter =0;
		if(numEnemiesKilled==32){
			changeRate("Ray gun rapid fire ");
			raygunRate = 2;
		}
		
	
		
		
	}
	private void changeRate(String s){
		if(displayCounter==0){
			JOptionPane.showMessageDialog(null, s + "added!");
				
		}
			
		displayCounter++;
	}
	private void displayMessage(String type) {
		if(displayCounter==0){
			weapons.add(type);
			JOptionPane.showMessageDialog(null, type + " added!");
				
		}
			
		displayCounter++;
		
	}
	private void addFireballs(){
		if(controlFireballs%200==0){//adds fireballs to random demon(lois)
			int r = rand.nextInt(demonList.size());
			Entity b = demonList.get(r);
			fireballs.add(new Fireball(b.x+30,b.y+30, "null"));
		}
		
	}
	private void addFireballsAllDir(){
		if(controlFireballs%600==0){//adds fireballs to random demon(lois)
			int r = rand.nextInt(bossList.size());
			Entity b = bossList.get(r);
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
			fireballsB.add(new Fireball(b.x+30,b.y+30, "null"));
		}
		
	}
	int numberDemonsSpawned=0; 
	private void addDemons() {
		// TODO Auto-generated method stub
		int mid = rand.nextInt(40) + 630;
		track = rand.nextInt(2);
		if(controlDemons>demonSpawn && numberDemonsSpawned<numberDemonsAllowedInThisLevel){
			if(track==0){//puts in diff locations based on track
				demonList.add(new Demon(mid,-40, stewie, demonHealth));
				numberDemonsSpawned++;
				//track++;
			}
			if(track==1){
				demonList.add(new Demon(mid,1040, stewie, demonHealth));
				numberDemonsSpawned++;
				//track--;
			}
		
			controlDemons = 0;
		}
	}
	private void addBoss() {
			// TODO Auto-generated method stub
			int mid = rand.nextInt(40) + 630;
			track = 0;
			if(track==0){//puts in diff locations based on track
				JOptionPane.showMessageDialog(null, "BOSS COMING");
				bossList.add(new Boss(mid,-100, stewie, bossHealth));
//					track++;
				}
			if(track==1){
				bossList.add(new Boss(mid, 1100, stewie, bossHealth));
//					track--;
				}
			
	}
	private void addHealthPacks(){
		int x = rand.nextInt(950) + 100;
		int y = rand.nextInt(500) + 100;
		if(controlFireballs%2000==0)
			packs.add(new Healthpack(x,y));
	}
	int numberZombiesSpawned=0; 
	public void addZombies(){
		int mid = rand.nextInt(20) + 580;
		track = rand.nextInt(2);
		if(control>zombieSpawn && numberZombiesSpawned<numberRegularZombiesThatArentDemonsAllowedInThisLevel){
			if(track==0){
				zombieList.add(new Zombie(mid, -30, stewie, zombieHealth));
				numberZombiesSpawned++;
			//	track++;
			}
			if(track==1){
				zombieList.add(new Zombie(mid,740, stewie, zombieHealth));
				numberZombiesSpawned++;
			//	track--;
			}
			control = 0;
		}
		
	}
	
	private void moveEverything() {
		// TODO Auto-generated method stub
		stewie.update();
		checkPlayerZombieColl();
		checkPlayerBossColl();
		checkPlayerDemonColl();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawHealthpacks(g);
		drawWalls(g);
		drawPlayer(g);
		drawZombies(g);
		drawDemons(g);
		if(bossList.size()>0)
			drawBoss(g);
		drawBullets(g);
		drawGrenades(g);//cant make explosion last longer
		drawClaymores(g);//cant make explosion last longer
		drawFireballs(g);
		if(bossList.size()>0)
			drawFireballsAllDir(g);
		drawHealthBar(g);
		displayScore(g);
		displayWeapon(g);
		displayLevel(g);
//		displayAmmo(g);
		if(checkGameOver())
			drawGameOver(g); 
	}
	private void drawHealthpacks(Graphics g) {
		// TODO Auto-generated method stub
		for(int s = 0; s< packs.size();s++){
			Healthpack p = packs.get(s);
			p.draw(g);
			if(p.collision(stewie)){
				if(101 - stewie.getHealth()<30)
					stewie.increaseHealth(101-stewie.getHealth());
				else
					stewie.increaseHealth(30);
				packs.remove(p);
			}
		}
	}
	private void displayLevel(Graphics g) {
		// TODO Auto-generated method stub
		Font condo= new Font("Dialog", Font.BOLD, 25);
		g.setFont(condo);
		g.setColor(Color.BLACK);
		g.drawString("Level: " +currentLevel, 1100, 25);
	}
	private void drawClaymores(Graphics g) {
		// TODO Auto-generated method stub
		for(int s = 0; s<claymores.size();s++){
			Claymore c = claymores.get(s);
			c.draw(g);
			checkClaymoreZombie(c, g);
			checkClaymoreDemon(c,g);
			
		}
	}
	private void checkClaymoreDemon(Claymore c, Graphics g) {
		// TODO Auto-generated method stub
		for(int z = 0;z<demonList.size();z++){
			if(c.collision(demonList.get(z))){
				c.drawExplosion(g);
				claymores.remove(c);
				demonList.get(z).decreaseHealth(4);
			}
		}
	}
	private void checkClaymoreZombie(Claymore c, Graphics g){
		for(int z = 0;z<zombieList.size();z++){
			if(c.collision(zombieList.get(z))){
				c.drawExplosion(g);
				claymores.remove(c);
				zombieList.remove(z);
			}
		}
	}
	private void displayAmmo(Graphics g) {
		// TODO Auto-generated method stub
		Font condo= new Font("Dialog", Font.BOLD, 25);
		g.setFont(condo);
		g.setColor(Color.BLACK);
		g.drawString("Ammo: " +weapons.get(weaponIndex), 900, 25);
	}
	private void displayWeapon(Graphics g) {
		// TODO Auto-generated method stub
		Font condo= new Font("Dialog", Font.BOLD, 25);
		g.setFont(condo);
		g.setColor(Color.BLACK);
		g.drawString("Weapon: " +weapons.get(weaponIndex), 800, 25);
	}
	private void drawGrenades(Graphics g) {//not sure how to control time of explosion
		// TODO Auto-generated method stub
		for(int s = 0; s<grenades.size();s++){
			Grenade gren = grenades.get(s);
			gren.draw(g);
			gren.increaseTime(1);
			if(gren.status==true)
				gren.move();
			if(gren.getTime()>50){
				gren.explode(g);
				checkZombieGrenadeCollision(gren);
				checkDemonGrenadeCollision(gren);
				grenades.remove(s);
				
			}
			gren.setStatus(false);
		}
	}
	private void checkDemonGrenadeCollision(Grenade g) {
		// TODO Auto-generated method stub
		for(int s = 0;s<demonList.size();s++){
			Demon d = demonList.get(s);
			if(g.collision(d))
				d.decreaseHealth(5);
		}
		
	}

	private void checkZombieGrenadeCollision(Grenade g) {
		// TODO Auto-generated method stub
		for(int s = 0;s<zombieList.size();s++){
			Zombie z = zombieList.get(s);
			if(g.collision(z))
				zombieList.remove(z);
		}
		for(int s = 0; s<bossList.size();s++){
			Boss b = bossList.get(s);
			if(g.collision(b))
				b.decreaseHealth(5);
		}
		
	}

	private void drawWalls(Graphics g) {
		// TODO Auto-generated method stub
		for(int s = 0;s<fakewalls.size();s++){
			Fakewall f = fakewalls.get(s);
			f.draw(g);
			checkOffScreenBullets(f);
			checkOffScreenFireballs(f);
		}
	}
	private void displayScore(Graphics g){
		Font condo= new Font("Dialog", Font.BOLD, 25);
		g.setFont(condo);
		g.setColor(Color.BLACK);
		g.drawString("SCORE: " +score, 20, 25);
	
	}
	
	
	private void drawFireballs(Graphics g){
		for(int s = 0; s<fireballs.size(); s++){
			Fireball f = fireballs.get(s);
			f.draw(g);
			f.move();
			if(this.checkFireBallCollision())
				fireballs.remove(f);
		}
	}
	
	private void drawFireballsAllDir(Graphics g){
		for(int s = 0; s<fireballsB.size(); s++){
			Fireball f = fireballsB.get(s);
			f.draw(g);
			if(s%8==0)	{
			f.shootUp();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==1){
			f.shootDown();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==2){
			f.shootLeft();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==3){
			f.shootRight();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==4){
			f.shootUpRight();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==5){
			f.shootUpLeft();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==6){
			f.shootDownRight();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
			if(s%8==7){
			f.shootDownLeft();
			if(this.checkFireBallBCollision())
				fireballsB.remove(f);
			}
		}
	}

		
	private void drawBullets(Graphics g) {
		// TODO Auto-generated method stub
		for(int s =0;s<playerBullets.size();s++){

			Weapon d= playerBullets.get(s);
			d.draw(g);
			d.move();
			this.checkBulletZombieCollision(d);
			this.checkBulletDemonCollision(d);
			this.checkBulletBossCollision(d);
			
		}
	}
	
	private boolean checkBulletBossCollision(Weapon d) {
		for(int z= 0; z<bossList.size(); z++){
			if(bossList.get(z).collision(d)){
				playerBullets.remove(d);
				bossList.get(z).decreaseHealth(d.damage());
				if(bossList.get(z).getHealth()<=0){
					bossList.remove(z);
					score+=100;
				}
				return true;
			}
		}
		return false;
		
	}

	private boolean checkBulletDemonCollision(Weapon d) {
		for(int z= 0; z<demonList.size(); z++){
			if(demonList.get(z).collision(d)){
				playerBullets.remove(d);
				demonList.get(z).decreaseHealth(d.damage());
				if(demonList.get(z).getHealth()<=0){
					demonList.remove(z);
					score+=10;
					numEnemiesKilled++;
					numberDemonsKilledInThisLevel++;
				}
				return true;
			}
		}
		return false;
		
	}
	private boolean checkBulletZombieCollision(Weapon d) {
		for(int z=0; z<zombieList.size(); z++){
			if(zombieList.get(z).collision(d)){
				zombieList.get(z).decreaseHealth(d.damage());
				playerBullets.remove(d);
				if(zombieList.get(z).getHealth()<=0){
					zombieList.remove(z);
					score+=5;
					numEnemiesKilled++;
					numberRegularZombiesThatArentDemonsKilledInThisLevel++;

				}
				return true;
			}
		}
		return false;
	}
	private void drawGameOver(Graphics g) {
		Font neglectedFetus= new Font("Dialog", Font.BOLD, 160);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 1300, 800);
		g.fillRect(0, 0, 1300, 800);
		g.setColor(Color.BLUE);
		g.setFont(neglectedFetus);
		g.drawString("GAME", 200, 200);
		g.drawString("OVER!", 200, 400);
		neglectedFetus = new Font("Dialog", Font.BOLD, 80);
		g.setFont(neglectedFetus);
		g.drawString("YOUR SCORE WAS: " + score,  200	, 600);
	
		
	}

	private boolean checkGameOver() {
		if(stewie.getHealth()<=0)
			return true;
		return false;
	}

	private void drawHealthBar(Graphics g) {
		Font condo= new Font("Dialog", Font.BOLD, 25);
		g.setFont(condo);
		g.setColor(Color.BLACK);
		g.drawString("Health", 200, 25);
		g.drawRect(300, 5, 100, 20);
		g.setColor(Color.GREEN);
		g.fillRect(300, 5, stewie.getHealth(), 21);
		
		
	}
	private void drawDemons(Graphics g){
		for(int s = 0; s< demonList.size(); s++){
			Demon d = demonList.get(s);
			d.draw(g);
			d.move();
			checkDemonCollision(d);
			checkDemonZombieCollision(d);
			checkDemonWallCollision(d);

		}
	}
	private void drawBoss(Graphics g){
		for(int s = 0; s< bossList.size(); s++){
			Boss d = bossList.get(s);
			d.draw(g);
			d.move();
			checkBossZombieDemonCollision(d);
		}
	//

	}
	private void drawZombies(Graphics g) {
		// TODO Auto-generated method stub
		for(int s = 0; s<zombieList.size();s++){
			Zombie z = zombieList.get(s);
			z.draw(g);
			z.move();
			checkZombieCollision(z);
			checkZombieWallCollision(z);
//			checkZombieGrenadeCollision(z);
		}
	}

	
	private void checkZombieWallCollision(Zombie z) {
		// TODO Auto-generated method stub
		for(int s = 0; s< fakewalls.size(); s++){
			Fakewall f = fakewalls.get(s);
			if(f.collision(z)){
				z.moveOtherWay(f);
//				z.moveOtherWayWall();

		
			}
				
		}
	}

	private void checkDemonWallCollision(Demon z) {
		// TODO Auto-generated method stub
		for(int s = 0; s< fakewalls.size(); s++){
			Fakewall f = fakewalls.get(s);
			if(f.collision(z)){
				z.moveOtherWay(f);
//				z.moveOtherWayWall();
		
			}
				
		}
	}
	private void checkBossZombieDemonCollision(Boss b){
		for(int s = 0; s<zombieList.size();s++){
			if(b.collision(zombieList.get(s)))//if zombie collides another, then move other way
				b.moveOtherWay(zombieList.get(s));
		}
		for(int s = 0; s<demonList.size();s++){
			if(b.collision(demonList.get(s)))//if zombie collides another, then move other way
				b.moveOtherWay(demonList.get(s));
		}
	}
	private void checkZombieCollision(Zombie z){//didnt do demon collision
		for(int s = 0; s<zombieList.size();s++){
			if(z.collision(zombieList.get(s)))//if zombie collides another, then move other way
				z.moveOtherWay(zombieList.get(s));
		}
		
	}
	private void checkDemonZombieCollision(Entity a){
		for(int s = 0; s<zombieList.size();s++){
			if(a.collision(zombieList.get(s)))//if zombie collides another, then move other way
				a.moveOtherWay(zombieList.get(s));
		}
	}
	private void checkDemonCollision(Demon a){
		for(int s = 0; s<demonList.size();s++){
			if(a.collision(demonList.get(s)))//if zombie collides another, then move other way
				a.moveOtherWay(demonList.get(s));
		}
	}
	private boolean checkFireBallCollision(){
		for(int x=0; x<fireballs.size(); x++){
			if(stewie.collision(fireballs.get(x))){
				stewie.decreaseHealth(20);
				return true;
			}
				
		}
		return false;
	}
	private boolean checkFireBallBCollision(){
		for(int x=0; x<fireballsB.size(); x++){
			if(stewie.collision(fireballsB.get(x))){
				stewie.decreaseHealth(10);
				return true;
			}
				
		}
		return false;
	}
	private void checkPlayerZombieColl(){//not solved
		for(int s = 0; s<zombieList.size();s++){
			if(stewie.collision(zombieList.get(s))){
				playerDamage++;
			}
		}
	}
	private void checkPlayerBossColl(){//not solved
		for(int s = 0; s<bossList.size();s++){
			if(stewie.collision(bossList.get(s))){
				playerDamage++;
			}
		}
	}
	private void checkPlayerDemonColl(){//not solved
		for(int s = 0; s<demonList.size();s++){
			if(stewie.collision(demonList.get(s))){
				playerDamage++;
			}
		}
	}
	private void drawPlayer(Graphics g) {
		// TODO Auto-generated method stub
		stewie.draw(g);
	}
	public static Stewie getStewie() {
		return stewie;
	}
}
