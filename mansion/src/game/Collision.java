package game;

public class Collision {
	private static CollisionGrid collide;
	private GameCharSprite character;
	public Collision(CollisionGrid collide,GameCharSprite character) {
		this.character = character;
		Collision.collide = collide;
	}
	boolean findNextB() {

		if (collide.getTile((int) character.getX()/16, (int)character.getY()/16-1).canCollide()) {
			{
				System.out.println("Bottom");
				return true;
			}
		}
		return false;

	}

	boolean findNextL() {

		if (collide.getTile((int) character.getX()/16-1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Left"+character.getXInt2());
				return true;
			}
		}
		return false;

	}

	boolean findNextR() {

		if (collide.getTile((int) character.getX()/16+1, (int) character.getY()/16).canCollide()) {
			{
				 System.out.println("Right");
				return true;
			}
		}
		return false;

	}

	boolean findNextT() {

		if (collide.getTile((int) character.getX()/16, (int) character.getY()/16+1).canCollide()) {
			{
				System.out.println("Top");
				return true;
			}
		}
		return false;

	}

}
