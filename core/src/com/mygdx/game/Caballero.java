package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import Patrones.Entidad;

public class Caballero {
	private float limitSupX;
	private float limitInfX;
	
	private boolean hit;
	private Entidad caballero;
	private Body caballeroBody;
	private TextureRegion caballeroImg;
	private BodyDef caballeroDef;
	private PolygonShape shape;
	private FixtureDef fixDef;
	
	
	public Caballero(Texture img, float x, float y, float accelX, float limitInfX, float limitSupX) {
		this.limitInfX = limitInfX;
		this.limitSupX = limitSupX;
		caballeroImg = new TextureRegion(img);
		caballero = new Enemigo(x, y, accelX);
		createBody();
	}
	
	private void createBody() {
		caballeroDef = new BodyDef();
		caballeroDef.position.set(caballero.getPosX(), caballero.getPosY());
		caballeroDef.type = BodyType.DynamicBody;
		
		shape = new PolygonShape();
		shape.setAsBox(caballero.getWidth(), caballero.getHeight());
		
		fixDef = new FixtureDef();
		fixDef.shape = shape;
		fixDef.density = 15.0f;
		
	}
	
	public void setCaballeroWorld(World world) {
		caballeroBody = world.createBody(caballeroDef);
		caballeroBody.createFixture(fixDef);
		caballeroBody.setUserData(this);
		
		shape.dispose();
	}
	
	public void update(float delta, World world) {
		Vector2 pos = caballeroBody.getPosition();

		float accelX = caballero.getAccelX();
		
		if(pos.x <= limitInfX) {
			accelX = 1;
		}
		else if(pos.x >= limitSupX) {
			accelX = -1;
		}
		
		caballero.update(caballeroBody, delta, accelX);
	}
	
	public boolean getHit() {
		return hit;
	}
	
	public void hit() {
		hit = true;
	}
	
	public void draw(SpriteBatch batch) {
		Vector2 pos = caballeroBody.getPosition();
		
		batch.draw(caballeroImg, pos.x - caballero.getDrawWidth() / 2, pos.y - caballero.getDrawHeigth() / 2, caballero.getDrawWidth() / 2.0f, caballero.getDrawHeigth() / 2.0f, 
				   caballero.getDrawWidth(), caballero.getDrawHeigth(), 1, 1, 0);
	}
}
